
DROP TABLE IF EXISTS location;

CREATE TABLE location (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address1 VARCHAR(250) NOT NULL,
  city VARCHAR(250) NOT NULL,
  state VARCHAR(250) NOT NULL,
  country VARCHAR(250) NOT NULL,
  reception VARCHAR(250) DEFAULT NULL,
  phone BIGINT DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  services VARCHAR(250) DEFAULT NULL,
  facilities VARCHAR(250) DEFAULT NULL
);

INSERT INTO location (name, address1, city,state,country,reception,phone,email,services,facilities) VALUES
  ('tcs-bangalore', 'electronic city', 'bangalore','karnataka','india','test',123456,'tcs-bangalore@tcs.com','IT',''),
  ('tcs-hyderabad', 'Hitec city', 'hyderabad','Telangana','india','test',789887,'tcs-hyderabad@tcs.com','IT',''),
  ('tcs-chennai', 'Chennai One ', 'chennai','TamilNade','india','test',12767126,'tcs-chennai@tcs.com','IT','');