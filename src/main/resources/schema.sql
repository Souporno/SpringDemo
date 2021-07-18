DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS address;

CREATE TABLE employee(
  employeeid INT PRIMARY KEY,
  employeename VARCHAR(250) NOT NULL
);

CREATE TABLE address(
  addressid INT AUTO_INCREMENT  PRIMARY KEY,
  city VARCHAR(250),
  pin VARCHAR(6),
  state VARCHAR(250),
  employeeid INT,
  FOREIGN KEY (employeeid) REFERENCES employee(employeeid)
);



