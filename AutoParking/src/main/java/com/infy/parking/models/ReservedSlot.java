package com.infy.parking.models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "booked_slot")
public class ReservedSlot {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "booking_id")
	private int bookingId ;
	
	@Column(name = "slot_id")
	private String slotId ;
	
	@Column(name = "employee_id")
	private int employeeId ;
	
	@Column(name = "booked_time")
	private Date bookedTime;
	
	@Column(name = "booked_flag")
	private int bookedFlag ;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getBookedTime() {
		return bookedTime;
	}

	public void setBookedTime(Date bookedTime) {
		this.bookedTime = bookedTime;
	}

	public int getBookedFlag() {
		return bookedFlag;
	}

	public void setBookedFlag(int bookedFlag) {
		this.bookedFlag = bookedFlag;
	}

	@Override
	public String toString() {
		return "ReservedSlot [bookingId=" + bookingId + ", slotId=" + slotId + ", employeeId=" + employeeId
				+ ", bookedTime=" + bookedTime + ", bookedFlag=" + bookedFlag + "]";
	}
	
	 
}
