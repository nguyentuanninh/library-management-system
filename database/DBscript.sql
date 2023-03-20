USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Library_Manager')
BEGIN
	ALTER DATABASE Library_Manager SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE Library_Manager SET ONLINE;
	DROP DATABASE Library_Manager;
END

GO

CREATE DATABASE Library_Manager
GO

USE [Library_Manager]
GO

CREATE TABLE category(
	id int primary key NOT NULL,
	name nvarchar(50) NOT NULL
)

CREATE TABLE book(
	id INT PRIMARY KEY NOT NULL,
	name NVARCHAR(300) NOT NULL,
	img NVARCHAR(50) DEFAULT 'img/book/book.jpg',
	author NVARCHAR(200),
	category INT FOREIGN KEY REFERENCES dbo.category(id) NOT NULL,
	publisher NVARCHAR(200),
	[language] NVARCHAR(50),
	total INT,
	[current] INT,
	position NVARCHAR(100),
)

CREATE TABLE [USER](
	username NVARCHAR(50) PRIMARY KEY NOT NULL,
	[password] NVARCHAR(50) NOT NULL,
	[role] BIT NOT NULL, -- 0: user, 1: admin
	[name] NVARCHAR(50),
	avt NVARCHAR(50) DEFAULT 'img/avt/avt.jpg',
	sex BIT, -- 0:female, 1:male
	datebirth DATE,
	phone NVARCHAR(15),
	gmail NVARCHAR(30),
)

CREATE TABLE borrower(
	id INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
	username  NVARCHAR(50) FOREIGN KEY REFERENCES dbo.[USER](username),
	book_id INT FOREIGN KEY REFERENCES dbo.book(id),
	form DATE,
	[to] DATE,
	[status] NVARCHAR(20),
)

CREATE TABLE feedback(
	id INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
	[user_id] NVARCHAR(50) FOREIGN KEY REFERENCES dbo.[USER](username),
	title NVARCHAR(50),
	[content] NVARCHAR(300),
)

Go
-- Điền thêm thông tin insert vào chỗ này
INSERT INTO dbo.category (id,name) VALUES (1,'Computer Science' );
INSERT INTO dbo.category (id,name) VALUES (2,'Math' );
INSERT INTO dbo.category (id,name) VALUES (3,'Language' );
INSERT INTO dbo.category (id,name) VALUES (4,'Economic' );


-----------------------------------------------------
Go
INSERT INTO dbo.book(id,[name],img, author,category, publisher,language,total,[current],position)
VALUES
 (10001,'Code: The Hidden Language of Computer Hardware and Software','img/book/book1.jpg','Charles Petzold',1,'Microsoft Press; 1st edition (October 11, 2000)','english',5,0,'F34' )
,(10002,'The Self-Taught Computer Scientist ','img/book/book2.jpg','Cory Althoff ',1,'Wiley; 1st edition (October 1, 2021)','english',4,1,'F36' )
,(10003,'The Chip : How Two Americans Invented the Microchip and Launched a Revolution','img/book/book3.jpg','T. R. Reid',1,'Random House Trade Paperbacks; Revised edition (October 9, 2001)','english',3,2,'F35' )
,(10004,'The Second Machine Age: Work, Progress, and Prosperity in a Time of Brilliant Technologies','img/book/book4.jpg','Erik Brynjolfsson',1,N'giáo dục','english',2,0,'A37' )
,(10005,'The Innovators: How a Group of Hackers, Geniuses, and Geeks Created the Digital Revolution','img/book/book5.jpg','Walter Isaacson',1,'Walter Isaacson','english',3,2,'E12' )
,(10006,'A Programmers Guide to Computer Science: A virtual degree for the self-taught developer','img/book/book6.jpg','Dr. William M Springer II',1,'Jaxson Media; Illustrated edition (July 28, 2019)','english',3,1,'E54' )
,(10007,'A handbook for teacher research : From design to implementation','img/book/book7.jpg','Colin Lankshear, Michele Knobel',2,'Open University Press','english',3,2,'B34' )
,(10008,'A course in phonetics','img/book/book8.jpg',' Ladefoged, Peter',2,'Cengage Learning, 2011','english',3,2,'G54' )
,(10009,'Language: Its structure and use','img/book/book9.jpg','Finegan, Edward',2,'Thomson Wadsworth, c2004,p','english',3,2,'S34' )
,(10010,'An introduction to linguistic theory and language acquisition','img/book/book10.jpg','Crain, Stephen; Lillo-Martin, Diane C. (Diane Carolyn)',2,'Wiley, 1999','english',3,3,'G54' )
,(10011,'An introduction to functional grammar','img/book/book11.jpg','Zoe Erotopoulos',2,'Arnold, 2004','english',3,1,'C54' )
,(10012,'An introduction to pragmatics: Social action for language teachers','img/book/book12.jpg','Halliday, M. A. K. (Michael Alexander Kirkwood)',2,'University of Michigan Press, 2003','english',4,0,'D31' )
,(10013,'500 Activities for the Primary Classroom','img/book/book13.jpg','LoCastro, Virginia.',3,'Macmillan Education','english',3,1,'D43' )
,(10014,'The Economics Book','img/book/book14.jpg','Carol Read',3,'Dorling Kindersley, 2012','english',3,2,'Q21' )
,(10015,'Principles for Dealing with the Changing World Order: Why Nations Succeed and Fail','img/book/book15.jpg','Dorling Kindersley',3,'Avid Reader Press / Simon & Schuster; 1st edition (November 30, 2021)','english',3,3,'A02' )
,(10016,'Business Valuation: The Most Complete Guide on How to Value a Business Through Updated Financial Valuation Methods','img/book/book16.jpg','Ray Dalio',3,'EquaMoney Press (February 17, 2023)','english',3,2,'D87' )
,(10017,'Financial Management Essentials You Always Wanted To Know (Color) (Self Learning Management)','img/book/book17.jpg','Nathan S. Goodwin',3,'Vibrant Publishers (September 19, 2019)','english',3,2,'N21' )
,(10018,'The Psychology of Money: Timeless lessons on wealth, greed, and happiness','img/book/book18.jpg','Kalpesh Ashar',3,'Harriman House (September 8, 2020)','english',3,2,'A44' )
,(10019,'Millionaire Mindset','img/book/book19.jpg','Paperback',3,'Get Rich Books (February 22, 2023)','english',4,1,'A34' )
,(10020,'English Grammar for Students of Spanish: The Study Guide for Those Learning Spanish, 7th edition','img/book/book20.jpg','Reveal Riches',4,'Olivia & Hill Press; 7th edition (December 18, 2012)','english',3,3,'J78' )
,(10021,'FRENCH, ENGLISH GRAMMAR FOR STUDENTS OF FRENCH, 7TH ED','img/book/book21.jpg','Emily Spinelli',4,'Olivia & Hill Press; 7th edition (July 17, 2013)','english',3,2,'K51' )
,(10022,'French All-in-One For Dummies','img/book/book22.jpg','Jacqueline Morton',4,'For Dummies; 1st edition (October 9, 2012)','english',3,2,'F23' )
,(10023,'Easy French Step-By-Step: Master High-Frequency Grammar for French Proficiency--Fast','img/book/book23.jpg','The Experts at Dummies',4,'McGraw Hill; 1st edition (December 1, 2008)','english',3,3,'L44' )
,(10024,'French For Dummies 2nd Edition','img/book/book24.jpg','Myrna Bell Rochester',4,'For Dummies; 2nd edition (August 30, 2011)','english',3,2,'M34' )
,(10025,N'Tiếng Việt Văn Việt cho người Việt','img/book/book25.jpg',N'Cao Xuân Hạo',4,N'Nhã Nam','vietnamese',3,3,'T34' )
,(10026,N'Dẫn Luận Về Ngôn Ngữ Học','img/book/book26.jpg','Partha Dasgupta',4,N'Nhà xuất bản Đồng Đức',N'vietnamese',3,2,'N34' )
-------------------------------------------------
Go
INSERT INTO dbo.[USER](username,password,role) 
VALUES('admin','admin',1);
INSERT INTO dbo.[USER](username,password,role,name,avt,sex,datebirth,phone,gmail) 
VALUES('user1','123456',0,'alex1','img/avt/avt1.jpg',1,'2000-12-23','0123443789','user1@gmail.com');
INSERT INTO dbo.[USER](username,password,role,name,avt,sex,datebirth,phone,gmail) VALUES('user2','123456',0,'alex2','img/avt/avt2.jpg',1,'2000-12-23','0195456789','user2@gmail.com');
INSERT INTO dbo.[USER](username,password,role,name,avt,sex,datebirth,phone,gmail) VALUES('user3','123456',0,'alex3','img/avt/avt3.jpg',0,'2000-12-23','0123493489','user3@gmail.com');
INSERT INTO dbo.[USER](username,password,role,name,avt,sex,datebirth,phone,gmail) VALUES('user4','123456',0,'alex4','img/avt/avt4.jpg',1,'2000-12-23','0193214789','user4@gmail.com');
---------------------------------------------------
GO
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10001,'2023-3-9','2023-3-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10002,'2023-2-9','2023-2-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10013,'2023-3-9','2023-3-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10019,'2023-2-9','2023-2-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10001,'2023-3-9','2023-3-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10004,'2023-3-9','2023-3-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10006,'2023-3-9','2023-3-24','Borrowed');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10012,'2023-3-9','2023-3-24','Borrowed');

INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10018,'2022-11-2','2022-11-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10008,'2022-11-2','2022-11-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10021,'2022-11-2','2022-11-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10011,'2022-11-2','2022-11-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10016,'2022-12-2','2022-12-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10012,'2022-12-2','2022-12-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10011,'2022-12-2','2022-12-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10002,'2022-12-2','2022-12-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10017,'2022-12-2','2022-12-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10022,'2023-1-2','2023-1-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10005,'2023-1-2','2023-1-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10003,'2023-1-2','2023-1-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10007,'2023-2-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10024,'2023-2-2','2023-2-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10017,'2023-2-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10001,'2023-2-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user4',10014,'2023-3-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10016,'2023-3-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10012,'2023-3-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user2',10026,'2023-3-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user1',10019,'2023-3-2','2023-3-24','Returned');
INSERT INTO dbo.borrower(username,book_id,form,[to],status)VALUES('user3',10009,'2023-3-2','2023-3-24','Returned');

INSERT INTO dbo.borrower(username,book_id,status)VALUES('user1',10001,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user1',10002,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user2',10013,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user2',10019,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user3',10001,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user4',10004,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user4',10006,'Processing');
INSERT INTO dbo.borrower(username,book_id,status)VALUES('user3',10012,'Processing');
-----------------------------------------------------------------
GO
INSERT INTO dbo.feedback(user_id,title,content)VALUES('user1',N'Đánh giá thư viện',N'Thư viện có rất nhiều đầu sách hay');
INSERT INTO dbo.feedback(user_id,title,content)VALUES('user2',N'sách thú vị ',N'thư viện thiết kế đẹp');
INSERT INTO dbo.feedback(user_id,title,content)VALUES('user3',N'sách rất bổ ích',N'thư viện rất hữu ích cho sinh viên');
INSERT INTO dbo.feedback(user_id,title,content)VALUES('user1',N'Góp Ý',N'thư viện nên bổ xung thêm bàn ghế cho sinh viên tự học ạ');
