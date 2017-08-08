CREATE DATABASE udemy_spring
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE udemy_spring;

CREATE USER 'us_db_usr'@localhost IDENTIFIED BY 'UAtFVKdWeVHbcp8R';
GRANT SELECT, INSERT, UPDATE ON udemy_spring.* TO 'us_db_usr'@localhost;

CREATE TABLE udemy_spring.offer (
  id         SERIAL,
  name       VARCHAR(100)   NOT NULL,
  email      VARCHAR(60)    NOT NULL,
  text 	     TEXT 			NOT NULL,
  
  PRIMARY KEY (id)
)ENGINE=InnoDB;

INSERT INTO udemy_spring.offer(name, email, text) values 
	('cat', 'cat@sale.com', 'cute cat for sale'),
	('dog', 'dog@sale.com', 'cute dog for sale')
;

select * from offer;