create database cg;
use cg;

create table instructor (
	instructorCode int primary key,
    iname varchar(20) not null,
    salary int not null,
    jobStartYear int not null
    );
    
    create table instructorInfo (
	recordId int primary key,
    instructorCode int references instructor(instructorCode),
    address varchar(100),
    email varchar(30),
    phone bigint(10),
    firstLanguage varchar(20),
    secondLanguage varchar(20)
    );
    
    -- Add entries to the 'instructor' table
insert into instructor (instructorCode, iname, salary, jobStartYear)
values
    (1, 'John Doe', 50000, 2010),
    (2, 'Jane Smith', 60000, 2012),
    (3, 'Bob Johnson', 55000, 2013),
    (4, 'Alice Brown', 58000, 2014),
    (5, 'Ella Davis', 52000, 2015),
    (6, 'Mike Wilson', 53000, 2016),
    (7, 'Linda Lee', 57000, 2017),
    (8, 'Chris Evans', 61000, 2018),
    (9, 'David White', 54000, 2019),
    (10, 'Sarah Black', 59000, 2020),
    (11, 'Paul Adams', 51000, 2021),
    (12, 'Grace Brown', 56000, 2022),
    (13, 'Robert Smith', 60000, 2023),
    (14, 'Olivia Taylor', 52500, 2024),
    (15, 'James Johnson', 54500, 2025);

-- Add entries to the 'instructorInfo' table
insert into instructorInfo (recordId, instructorCode, address, email, phone, firstLanguage, secondLanguage)
values
    (1, 1, '123 Main St, City', 'john.doe@example.com', 1234567890, 'English', 'Spanish'),
    (2, 2, '456 Elm St, Town', 'jane.smith@example.com', 9876543210, 'English', 'French'),
    (3, 3, '789 Oak St, Village', 'bob.johnson@example.com', 5555555555, 'English', 'German'),
    (4, 4, '567 Pine St, Suburb', 'alice.brown@example.com', 9999999999, 'English', 'Italian'),
    (5, 5, '321 Oak Ave, City', 'ella.davis@example.com', 5551234567, 'English', 'Spanish'),
    (6, 6, '789 Elm Dr, Town', 'mike.wilson@example.com', 8888888888, 'English', 'French'),
    (7, 7, '456 Birch Rd, Village', 'linda.lee@example.com', 7777777777, 'English', 'German'),
    (8, 8, '654 Maple Ln, Suburb', 'chris.evans@example.com', 6666666666, 'English', 'Italian'),
    (9, 9, '789 Cedar St, City', 'david.white@example.com', 4444444444, 'English', 'Spanish'),
    (10, 10, '987 Oak St, Town', 'sarah.black@example.com', 3333333333, 'English', 'French'),
    (11, 11, '234 Elm Rd, Village', 'paul.adams@example.com', 2222222222, 'English', 'German'),
    (12, 12, '123 Pine Dr, Suburb', 'grace.brown@example.com', 1111111111, 'English', 'Italian'),
    (13, 13, '456 Birch Ave, City', 'robert.smith@example.com', 9998887777, 'English', 'Spanish'),
    (14, 14, '789 Oak Rd, Town', 'olivia.taylor@example.com', 8887776666, 'English', 'French'),
    (15, 15, '987 Maple Ln, Village', 'james.johnson@example.com', 7776665555, 'English', 'German');
    
-- Extract all instructors based on salary > 2000:
select * from instructor where salary > 59000;

-- Alter the instructor table and add one more column TechnologyName. Type varchar and InstructorType varchar
ALTER TABLE instructor
ADD TechnologyName varchar(50),
ADD InstructorType varchar(50);

-- Populate data for the new columns
update instructor
set
    TechnologyName = case
        when instructorCode in (1, 4, 9, 12) then 'FSD'
        when instructorCode in (2, 7, 14) then 'Angular'
        when instructorCode in (3, 11) then 'Testing'
        when instructorCode in (5, 6, 8, 10, 13, 15) then 'SAP'
        else 'SalesForce'
    end,
    InstructorType = case
        when instructorCode in (1, 4, 9, 12) then 'Programming'
        when instructorCode in (2, 7, 14) then 'Infra'
        when instructorCode in (3, 11) then 'Database'
        when instructorCode in (5, 6, 8, 10, 13, 15) then 'Communication'
        else 'Programming'
    end;

-- Extract all instructors based on technology type (assuming TechnologyName is the column for technology type)
select * from instructor where InstructorType = 'Programming';

-- Increase the salary of all Instructors of Communication
UPDATE instructor
SET salary = salary - 9999
WHERE InstructorType = 'Communication';
select * from instructor;

-- How much total Salary paid to Programming Instructors
select InstructorType, sum(salary) as TotalSal from instructor where InstructorType = 'Programming'; 

-- Render Total Salary paid based on Instructor Type
select InstructorType, sum(salary) as TotalSal from instructor group by InstructorType;

-- Sort Instructor based on name
select * from instructor order by iname;

-- Extract all Instructors from address "123 Main St, City"
select * from instructorInfo where address like '%123 Main St, City';

-- Extract all Instructors whose TechnologyName contains "FSD"
select * from instructor where TechnologyName like "%FSD";

-- Get the name and code of All Instructors who have the first language as "Spanish"
select instructor.instructorCode, instructor.iname
from instructor
inner join instructorInfo on instructor.instructorCode = instructorInfo.instructorCode
where instructorInfo.secondLanguage = 'Spanish';

-- Count the number of Instructors who can speak "Spanish"
select count(*) as Count from instructorInfo where secondLanguage = "Spanish";

-- Update the Salary of All instructors who can speak "Spanish"
update instructor
set salary = salary + 1000
where instructorCode in (select instructorCode from instructorInfo where firstLanguage = 'Spanish');

-- Display InstructorCode, JobStartYear, email, phone of Instructors who have the first language as "Spanish"
select i.instructorCode, i.jobStartYear, ii.email, ii.phone
from instructor as i
inner join instructorInfo as ii on i.instructorCode = ii.instructorCode
where ii.secondLanguage = 'Spanish';

-- SQL Query to drop column Second Language
ALTER TABLE instructorInfo DROP COLUMN firstLanguage;
select * from instructorInfo;
