drop table user_details;
drop table building_details;
drop table slots_details;

create table user_details(
    user_id number(8) PRIMARY KEY,
    email varchar2(25) NOT NULL,
    password varchar2(100) NOT NULL
)

create table building_details(
    building_id varchar2(10) PRIMARY KEY,
    vacant_slots number(4) NOT NULL
)

create table slots_details(
    slot_id varchar2(20) PRIMARY KEY,
    building_id varchar2(10),
    booking_flag number(1),
    user_id number(8),
    booking_time date
)

