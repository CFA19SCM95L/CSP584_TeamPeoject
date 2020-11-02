create database project_database;

use project_database;

create table Registration
(
userId integer,
userName varchar(40),
password varchar(40),
email varchar(60),
usertype varchar(40),
address varchar(60),
locationLat varchar(20),
locationLong varchar(20),
location  varchar(30),
Primary key(userId)
);


Create table Appointment
(
providerId integer,
customerId integer,
appointmentDate date,
appointmentTime time
);

Create table Doctordetails
(
postId integer,
doctorId integer,
realName varchar(30),
department varchar(40),
address varchar(60),
locationLat varchar(20),
locationLong varchar(20),
location  varchar(30),
openTime varchar(20), 
closeTime varchar(20), 
postTime date,
Primary key(postId)
);


INSERT INTO Registration (userId, userName, password, email, usertype, address, locationLat, locationLong, location)
VALUES (1,'Tom','tom','tom@gmail.com','customer','215 West Washington, W Washington St, Chicago, IL 60606','41.8828584','-87.6363466','Chicago, IL'),
(2,'Bill', 'bill','bill@gmail.com','doctor','3000 N Halsted St Ste 720, Chicago, IL 60657','38.2450581','-123.0060601','Chicago, IL'),
(3,'Lily','lily','lily@gmail.com','customer','255 King St, San Francisco, CA 94107','37.7495887','-122.4381021','San Francisco, CA'),
(4,'Jason','jason','jason@gmail.com','customer','1700 Newbury Park Dr, San Jose, CA 95133','37.3750217','-121.8650577','San Jose, CA'),
(5,'Ming','ming','ming@gmail.com','doctor','909 Hyde St #432, San Francisco, CA 94109','37.789371','-122.4194441','San Francisco, CA'),
(6,'Justin','justin','justin@gmail.com','customer','101 Colorado St, Austin, TX 78701','30.2641372','-97.7477867','Austin, TX'),
(7,'Brynna','brynna ','brynna@gmail.com','doctor','2911 Medical Arts St Building #10, Austin, TX 78705','30.2880745','-97.7295075','Austin, TX'),
(8,'Gina','gina','tina@gmail.com','customer','2829 27th St W, Williston, ND 58801','48.1700719','-103.6650649','Williston, ND'),
(9,'Ryan ','ryan ','ryan@gmail.com','doctor','1321 W Dakota Pkwy, Williston, ND 58801','48.1559559','-103.6530379','Williston, ND'),
(10,'David','david','david@gmail.com','customer','111 N Wabash Ave STE 1412, Chicago, IL 60602','41.8834746','-87.6279434','Chicago, IL'),
(11,'Milton','milton','milton@gmail.com','doctor','210 East 64th Street, 7th Floor, New York City, NY 10065','40.7640723','-73.9655038','New York City, NY'),
(12,'David','david','david@gmail.com','doctor','111 N Wabash Ave STE 1412, Chicago, IL 60602','41.8834746','-87.6279434','Chicago, IL'),
(13,'Shirish','shirish','shirish@gmail.com','doctor','5600 W Addison St Ste 400, Chicago, IL 60634','41.9460911','-87.7693311','Chicago, IL'),
(14,'Adrian','adrian','adrian@gmail.com','doctor','5200 Jose Figueres Ave #215, San Jose, CA 95116','37.3615718','-121.8524164','San Jose, CA'),
(15,'Russell','russell','russell@gmail.com','doctor','8875 Centre Park Dr suite d, Columbia, MD 21045','39.2289939','-76.8156736','Columbia, MD'),
(16,'March','march','march@gmail.com','doctor','131 Summer Pl Dr, West Columbia, SC 29169','34.0042347','-81.1231826','West Columbia, SC'),
(17,'Mark','mark','mark@gmail.com','doctor','11200 Gov Manly Way #309, Raleigh, NC 27614','35.9477509','-78.543784','Raleigh, NC'),
(18,'Jon','jon','jon@gmail.com','doctor','55 Fruit St, Boston, MA 02114','42.362706','-71.0708467','Boston, MA'),
(19,'Peter','peter','peter@gmail.com','doctor','330 Brookline Ave, Boston, MA 02215','42.3398798','-71.106747','Boston, MA'),
(20,'Robert','robert','robert@gmail.com','doctor','725 Albany St #3b, Boston, MA 02118','42.3348727','-71.0743435','Boston, MA'),
(21,'Edward','edward','edward@gmail.com','doctor','175 Remsen St 12th floor, Brooklyn, NY 11201','40.6934999','-73.9935536','Brooklyn, NY'),
(22,'Ken','ken','ken@gmail.com','doctor','110 E 40th St Floor 6, New York, NY 10016','40.7504117','73.980187','New York, NY'),
(23,'Wong','wong','wong@gmail.com','doctor','945 Hildebrand Ln NE, Bainbridge Island, WA 98110','47.6336187','-122.5199271','Bainbridge Island, WA'),
(24,'John','john','john@gmail.com','doctor','9155 SW Barnes Rd #430, Portland, OR 97225','45.510411','-122.772308','Portland, OR');



INSERT INTO Appointment (providerId, customerId, appointmentDate, appointmentTime)
VALUES (2,1,'2020-10-20','2020-10-20 10:00:00'),
(2,10,'2020-10-07','2020-10-07 15:00:00'),
(5,4,'2020-10-31','2020-10-31 09:30:00'),
(5,3,'2020-11-01','2020-11-01 13:45:00'),
(2,1,'2020-11-20','2020-11-20 10:00:00'),
(7,6,'2020-10-15','2020-10-15 10:15:00'),
(7,6,'2020-11-20','2020-11-20 10:30:00'),
(5,3,'2020-10-06','2020-10-06 09:20:00'),
(5,10,'2020-11-06','2020-11-06 14:30:00'),
(5,8,'2020-10-30','2020-10-30 09:20:00');


INSERT INTO Doctordetails (postId, doctorId, realName, department, address, locationLat, locationLong, location, OpenTime,closeTime,postTime)
VALUES (1,2,'Dr. Sue Kafali-Nazarof','gynecologic & cosmetic surgeon','3000 N Halsted St Ste 720, Chicago, IL 60657','38.2450581','-123.0060601','Chicago, IL','09:00:00','17:00:00','2020-08-30'),
(2,5,'Dr. Ming Li Tsang','Family Medicine','909 Hyde St #432, San Francisco, CA 94109','37.789371','-122.4194441','San Francisco, CA','08:00:00','17:30:00','2020-09-03'),
(3,9,'Dr. Ryan M Siewert','Family Medicine','1321 W Dakota Pkwy, Williston, ND 58801','48.1559559','-103.6530379','Williston, ND','09:30:00','17:30:00','2020-09-05'),
(4,7,'Dr. Brynna Connor','Family Medicine','2911 Medical Arts St Building #10, Austin, TX 78705','30.2880745','-97.7295075','Austin, TX','08:00:00','17:30:00','2020-09-05'),
(5,11,'Dr. Milton Waner','hemangiomas and vascular malformations','210 East 64th Street, 7th Floor, New York City, NY 10065','40.7640723','-73.9655038','New York City, NY','08:15:00','16:30:00','2020-09-06'),
(6,12,'Dr. David J. Benditzson',' Primary Care','111 N Wabash Ave STE 1412, Chicago, IL 60602','41.8834746','-87.6279434','Chicago, IL','09:30:00','16:30:00','2020-09-12'),
(7,13,'Dr. Shirish N. Shah',' Cardiology ','5600 W Addison St Ste 400, Chicago, IL 60634','41.9460911','-87.7693311','Chicago, IL','09:00:00','17:30:00','2020-09-12'),
(8,14,'Dr. Adrian Ma',' Cardiovascular ','5200 Jose Figueres Ave #215, San Jose, CA 95116','37.3615718','-121.8524164','San Jose, CA','08:00:00','15:30:00','2020-09-15'),
(9,15,'Dr. Russell O. Schub','Gastroenterology','8875 Centre Park Dr suite d, Columbia, MD 21045','39.2289939','-76.8156736','Columbia, MD','10:00:00','16:00:00','2020-09-20'),
(10,16,'Dr. March E. Seabrook','Gastroenterology','131 Summer Pl Dr, West Columbia, SC 29169','34.0042347','-81.1231826','West Columbia, SC','08:00:00','17:00:00','2020-09-22'),
(11,17,'Mark W. Galland','Orthopedics','11200 Gov Manly Way #309, Raleigh, NC 27614','35.9477509','-78.543784','Raleigh, NC','09:00:00','17:30:00','2020-09-27'),
(12,18,'Dr. Jon J. Warner','Orthopedics','55 Fruit St, Boston, MA 02114','42.362706','-71.0708467','Boston, MA','08:30:00','16:30:00','2020-09-28'),
(13,19,'Dr. Peter Steinberg','Urology','330 Brookline Ave, Boston, MA 02215','42.3398798','-71.106747','Boston, MA','08:30:00','16:30:00','2020-10-08'),
(14,20,'Dr. Robert Oates','Urology','725 Albany St #3b, Boston, MA 02118','42.3348727','-71.0743435','Boston, MA','09:30:00','18:30:00','2020-10-09'),
(15,21,'Dr. Edward Zoltan','Urology','175 Remsen St 12th floor, Brooklyn, NY 11201','40.6934999','-73.9935536','Brooklyn, NY','08:30:00','18:00:00','2020-10-11'),
(16,22,'Dr. Ken Moadel','Ophthalmology','110 E 40th St Floor 6, New York, NY 10016','40.7504117','-73.980187','New York, NY','08:30:00','17:00:00','2020-10-12'),
(17,23,'Dr. Jacqueline Wong','Ophthalmology','945 Hildebrand Ln NE, Bainbridge Island, WA 98110','47.6336187','-122.5199271','Bainbridge Island, WA','09:00:00','17:00:00','2020-10-15'),
(18,24,'Dr. John H. Wilkins','Ophthalmology','9155 SW Barnes Rd #430, Portland, OR 97225','45.510411','-122.772308','Portland, OR','09:00:00','14:00:00','2020-10-16');
