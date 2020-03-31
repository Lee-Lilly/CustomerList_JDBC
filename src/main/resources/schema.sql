DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS customers (
    id int(5) NOT NULL AUTO_INCREMENT,
    first_name varchar(50) DEFAULT NULL,
    last_name varchar(50) DEFAULT NULL,
    email varchar(50) DEFAULT NULL,
    PRIMARY KEY(id),
    CONSTRAINT email_unique UNIQUE(email)
    );
    
INSERT INTO customers(first_name, last_name, email) values ('John', 'West', 'West.John@gmail.com');
INSERT INTO customers(first_name, last_name, email) values ('Mike', 'Mars', 'Mar.Mike@yahoo.com');
INSERT INTO customers(first_name, last_name, email) values ('Anne', 'Watson','Watson.Anne@aol.com');
INSERT INTO customers(first_name, last_name, email) values ('Craig', 'Scott', 'Scott.Craig@gmail.com');
INSERT INTO customers(first_name, last_name, email) values ('Kate', 'Johnson', 'Johnson.kate@hotmail.com');
INSERT INTO customers(first_name, last_name, email) values ('Sam', 'West', 'West.sam@hotmail.com');