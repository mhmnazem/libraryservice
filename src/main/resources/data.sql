CREATE TABLE IF NOT EXISTS MEMBER_TEMP(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255),first_name VARCHAR(255), member_since_str VARCHAR(10), member_till_str VARCHAR(10), gender CHAR(1));
INSERT INTO MEMBER_TEMP (name, first_name, member_since_str, member_till_str, Gender)
SELECT * FROM CSVREAD('../library-service/src/main/resources/h2/csv/user.csv');

CREATE TABLE IF NOT EXISTS BOOKS (id INT AUTO_INCREMENT PRIMARY KEY,title VARCHAR(255), author VARCHAR(255), genre VARCHAR(100), publisher VARCHAR(255));
INSERT INTO BOOKS (title, author, genre, publisher)
SELECT * FROM CSVREAD('../library-service/src/main/resources//h2/csv/books.csv');

CREATE TABLE BORROWED_TEMP (id INT AUTO_INCREMENT PRIMARY KEY,borrower VARCHAR(255), book VARCHAR(255), borrowedFrom_str VARCHAR(10), borrowedTo_str VARCHAR(10));
INSERT INTO BORROWED_TEMP (borrower, book, borrowedFrom_str, borrowedTo_str)
SELECT * FROM CSVREAD('../library-service/src/main/resources/h2/csv/borrowed.csv');

CREATE TABLE IF NOT EXISTS MEMBER(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), first_name VARCHAR(255), member_since Date, member_till Date, gender CHAR(1));
INSERT INTO MEMBER (name, first_name, member_since, member_till, gender)
SELECT name, first_name, PARSEDATETIME(member_since_str, 'MM/dd/yyyy'),
                         PARSEDATETIME(member_till_str, 'MM/dd/yyyy'), gender FROM Member_Temp;

CREATE TABLE BORROWED (id INT AUTO_INCREMENT PRIMARY KEY,borrower VARCHAR(255), book VARCHAR(255), borrowed_from DATE, borrowed_to DATE);
INSERT INTO BORROWED (borrower, book, borrowed_from, borrowed_to)
SELECT borrower, book, PARSEDATETIME(borrowedFrom_str, 'MM/dd/yyyy'),
       PARSEDATETIME(borrowedTo_str, 'MM/dd/yyyy') FROM BORROWED_TEMP;

