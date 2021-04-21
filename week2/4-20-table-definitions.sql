-- employee_schema.employee definition

-- Drop table

DROP TABLE employee_schema.employee;

CREATE TABLE employee_schema.employee (
	id bigserial NOT NULL,
	"name" varchar(20) NOT NULL,
	age int4 NOT NULL,
	contact int8 NOT NULL,
	city varchar(40) NOT NULL,
	gender varchar(1) NOT NULL,
	deptid int4  NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id)
);

-- employee_schema.department definition

-- Drop table

DROP TABLE employee_schema.department;

CREATE TABLE employee_schema.department (
	deptid int4 NOT NULL,
	"name" varchar(20) NOT NULL,
	base_location varchar(25) NOT NULL,
	CONSTRAINT department_pk PRIMARY KEY (deptid)
);

-- employee_schema.employee foreign keys

ALTER TABLE employee_schema.employee 
	ADD CONSTRAINT employee_fk FOREIGN KEY (deptid) 
	REFERENCES employee_schema.department (deptid);

