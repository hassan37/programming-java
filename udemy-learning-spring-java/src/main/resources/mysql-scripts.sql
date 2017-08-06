CREATE DATABASE udemy_spring
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

USE udemy_spring;

CREATE USER 'us_db_usr'@localhost IDENTIFIED BY 'UAtFVKdWeVHbcp8R';
GRANT SELECT, INSERT, UPDATE ON us_db_usr.* TO 'us_db_usr'@localhost;

CREATE TABLE udemy_spring.offer (
  id         SERIAL,
  name       VARCHAR(100)   NOT NULL,
  email      VARCHAR(60)    NOT NULL,
  text 	     TEXT 			NOT NULL,
  
  PRIMARY KEY (id)
)ENGINE=InnoDB;

select * from offer;