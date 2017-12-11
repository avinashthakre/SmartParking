package com.infy.parking.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.infy.parking.models.SlotDetails;

public class CSVReader {

	//CSV file header
	private static final String [] FILE_HEADER_MAPPING = {"buildingId","slotId"};

	public static List<SlotDetails> readSlotDetails(MultipartFile  mFile) {

		FileReader fileReader = null;

		CSVParser csvFileParser = null;

		//Create the CSVFormat object with the header mapping
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		//Create a new list of student to be filled by CSV file data 
		List<SlotDetails> slots = new ArrayList<SlotDetails>();

		try {
			//initialize FileReader object
			File file = new File(mFile.getOriginalFilename());
			mFile.transferTo(file);
			
			fileReader = new FileReader(file);

			//initialize CSVParser object
			csvFileParser = new CSVParser(fileReader, csvFileFormat);

			//Get a list of CSV file records
			List csvRecords = csvFileParser.getRecords(); 

			//Read the CSV file records starting from the second record to skip the header
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = (CSVRecord) csvRecords.get(i);
				//Create a new student object and fill his data
				SlotDetails slot = new SlotDetails();
				slot.setBuildingId(record.get("buildingId"));
				slot.setSlotId(record.get("slotId"));
				System.out.println(record.get("buildingId"));
				System.out.println(record.get("slotId"));
				slots.add(slot);	
			}
		} 
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader/csvFileParser !!!");
				e.printStackTrace();
			}
		}
		return slots;
	}
}
