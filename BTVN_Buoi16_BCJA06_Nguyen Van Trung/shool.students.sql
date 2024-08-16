CREATE DATABASE school;
USE school;

CREATE TABLE students(
	id int AUTO_INCREMENT,
	fullname varchar(255) NOT NULL,
	gender varchar(10),
	age int,
	city varchar(100),
	weight float,
	
	PRIMARY KEY (id)
);

INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Nguyen Thanh Nhan" , "Nam", 19, "Can Tho", 56.5674);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Pham Thu Huong" , "Nu", 20, "Vinh Long", 72.456);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Nguyen Nhu Ngoc" , "Nu", 20, "Soc Trang", 85.387);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Bui Thanh Bao" , "Nam", 19, "Soc Trang", 49.3);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Le My Nhan" , "Nu", 22, "Can Tho", 62.963);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Tan Thuc Bao" , "Nam", 35, "An Giang", 55.5678);
INSERT INTO students (fullname, gender, age, city, weight) 
VALUES ("Trinh Giao Kim" , "Nam", 44, "Bac Lieu", 67.34);

SELECT * FROM school.students s;
