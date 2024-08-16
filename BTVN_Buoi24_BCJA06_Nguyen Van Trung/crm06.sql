CREATE DATABASE crm06;
USE crm06;

CREATE TABLE roles (
	id int auto_increment,
	name varchar(20),
	description varchar(100),
	
	primary key (id)
);

CREATE TABLE users (
	id int auto_increment,
	email varchar(100),
	password varchar(100),
	first_name varchar(50),
	last_name varchar(50),
	phone varchar(20),
	id_role int,
	
	primary key(id)
);

CREATE TABLE task (
	id int auto_increment,
	name varchar(50),
	start_date timestamp,
	end_date timestamp,
	id_user int,
	id_project int,
	id_status int,

	primary key(id)
);

CREATE TABLE status (
	id int auto_increment,
	name varchar(50),
	
	primary key(id)
);
	
CREATE TABLE project(
	id int auto_increment,
	name varchar(100),
	start_date timestamp,
	end_date timestamp,
	
	primary key(id)
);


ALTER TABLE users ADD CONSTRAINT fk_users_id_role FOREIGN KEY(id_role) REFERENCES roles(id);
ALTER TABLE task ADD CONSTRAINT fk_task_id_user FOREIGN KEY(id_user) REFERENCES users(id);
ALTER TABLE task ADD CONSTRAINT fk_task_id_project FOREIGN KEY(id_project) REFERENCES project(id);
ALTER TABLE task ADD CONSTRAINT fk_task_id_status FOREIGN KEY(id_status) REFERENCES status(id);


