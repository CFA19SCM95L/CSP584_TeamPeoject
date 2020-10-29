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
OpenTime varchar(20), 
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
(12,'David','david','david@gmail.com','doctor',' 111 N Wabash Ave STE 1412, Chicago, IL 60602','41.8834746','-87.6279434','Chicago, IL');



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
(6,12,'Dr. David J. Benditzson',' Primary Care','111 N Wabash Ave STE 1412, Chicago, IL 60602','41.8834746','-87.6279434','Chicago, IL','09:30:00','16:30:00','2020-09-12');
