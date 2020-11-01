// import java.sql.*;
// import java.util.*;
                	
// public class MySqlDataStoreUtilities {
// 	static Connection conn = null;

// 	public static void getConnection()
// 	{

// 		try
// 		{
// 		Class.forName("com.mysql.jdbc.Driver").newInstance();
// 		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bestDealDatabase?autoReconnect=true&useSSL=false","root","root");
// 		}
// 		catch(Exception e)
// 		{
// 			System.out.println(e.getMessage());
// 		}
// 	}


// 	public static void createTable()
// 	{
// 		try
// 		{	

// 			getConnection();
// 			conn.prepareStatement("create table Registration(username varchar(40),password varchar(40), usertype varchar(40), rebate int ,Primary key(username));").execute();
// 			conn.prepareStatement("Create table Store(storeId varchar(20),street varchar(100),city varchar(40),state varchar(20),zip varchar(60),Primary key(storeId));").execute();
// 			conn.prepareStatement("Create table Customer(username varchar(20), name varchar(20),street varchar(100),city varchar(40),state varchar(20),zip varchar(60) ,Primary key(username), FOREIGN KEY (username) REFERENCES Registration(username) );").execute();
// 			conn.prepareStatement("Create table Product (ProductType varchar(20),Id varchar(50),productName varchar(50),productPrice double,productManufacturer varchar(40),productCondition varchar(40), productDiscount double,productRebate int, inventory int,Primary key(Id));").execute();
// 			conn.prepareStatement("Create table transcation(userId varchar(40),cardNumber varchar(60), orderId int,purchaseDate varchar(60),shipDate varchar(40),productId varchar(50),quantity int,shipCost double,discount double,totalSales double,storeId varchar(40),Primary key(orderId),   FOREIGN KEY (storeId) REFERENCES Store(storeId) ON DELETE SET NULL ON UPDATE CASCADE, FOREIGN KEY (userId) REFERENCES Registration(username) ON DELETE SET NULL ON UPDATE CASCADE,FOREIGN KEY (productId) REFERENCES Product(Id) ON DELETE SET NULL ON UPDATE CASCADE);").execute();

// 		}
// 		catch(Exception e)
// 		{
// 			System.out.println(e);
// 		}	
// 	}




// 	public static void insertStore()
// 	{
// 		try
// 		{	

// 			getConnection();
// 			conn.prepareStatement("insert into store values('1', '23501 Cinco Ranch Blvd', 'Katy', 'TX', '77494');").execute();
// 			conn.prepareStatement("insert into store values('2', '1801 Durham Dr #2', 'Houston', 'TX', '77007');").execute();
// 			conn.prepareStatement("insert into store values('3', '5693 S Jones Blvd #106', 'Las Vegas', 'NV', '89118');").execute();
// 			conn.prepareStatement("insert into store values('4', '47199 Clear Ridge Rd', 'Big Sur', 'CA', '93920');").execute();
// 			conn.prepareStatement("insert into store values('5', '1829 St Helena Hwy', 'Rutherford', 'CA', '94573');").execute();
// 			conn.prepareStatement("insert into store values('6', '750 Howard St', 'San Francisco', 'CA', '94103');").execute();
// 			conn.prepareStatement("insert into store values('7', '5801 S Ellis Ave', 'Chicago', 'IL', '60637');").execute();
// 			conn.prepareStatement("insert into store values('8', '1 Park St', 'Boston', 'MA', '02108');").execute();
// 			conn.prepareStatement("insert into store values('9', '201 Park Ave S', 'New York', 'NY', '10003');").execute();
// 			conn.prepareStatement("insert into store values('10', '420 Grand St', 'Jersey City', 'NJ', '07302');").execute();
// 			conn.prepareStatement("insert into store values('deliver', 'deliver', 'deliver', 'deliver', 'deliver');").execute();

// 		}
// 		catch(Exception e)
// 		{
// 		}	
// 	}


// }	

import java.sql.*;
import java.util.*;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Statement;
                	
public class MySqlDataStoreUtilities
{
static Connection conn = null;
static String message;
public static String getConnection()
{

	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_database","root","yzhu90");
	message="Successfull";
	return message;
	}
	catch(SQLException e)
	{
		message="unsuccessful";
		     return message;
	}
	catch(Exception e)
	{
		message=e.getMessage();
		return message;
	}
}

/**************************************************GET Appointment Message******************************************************/
public static  List<Appointment> getAppointmentInfo(int providerId){
	List<Appointment> list = new ArrayList<Appointment>();
	try{
		getConnection();
		String getAppointments = "select * from  Appointment where providerId=?";
		PreparedStatement pst = conn.prepareStatement(getAppointments);
		pst.setInt(1,providerId);
		ResultSet rs = pst.executeQuery();

		while(rs.next())
		{	Appointment appointment = new Appointment(rs.getInt("providerId"),
				rs.getInt("customerId"),
				rs.getDate("appointmentDate").toLocalDate(),
				rs.getTime("appointmentTime").toLocalTime());

			list.add(appointment);

		}
	}
	catch(Exception e)
	{
	}
	return list;
}

/**************************************************GET User Info******************************************************/
/*create table Registration
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
);*/
public static HashMap<String,User> selectUser()
	{
		HashMap<String,User> hm=new HashMap<String,User>();
		try
		{
			getConnection();
			Statement stmt=conn.createStatement();
			String selectCustomerQuery="select * from  Registration";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
			{	User user = new User(rs.getInt("userId"),rs.getString("username"),
									rs.getString("email"),rs.getString("password"),
									rs.getString("usertype"),rs.getString("locationLat"),
									rs.getString("locationLong"),rs.getString("address"));
				hm.put(rs.getString("username"), user);
			}
		}
		catch(Exception e)
		{
		}
		return hm;
	}


/**************************************************GET Doctor Details******************************************************/
/*Create table Doctordetails
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
);*/


public static HashMap<Integer,DoctorDetail> getDoctorDetails()
{	
	HashMap<Integer,DoctorDetail> hm=new HashMap<Integer,DoctorDetail>();
	try 
	{
		getConnection();
		String getDoctorDetails="select * from Doctordetails";
		PreparedStatement pst = conn.prepareStatement(getDoctorDetails);
		ResultSet rs = pst.executeQuery();


/*public DoctorDetail(int id, int doctorId,
                String realName, String department,
                String password, String usertype,
                String lat, String longt,
                String address, String location,
                String openTime, String closeTime,
                LocalDate postTime) */
		while(rs.next())
		{	DoctorDetail doctorDetail = 
				new DoctorDetail(rs.getInt("postId"),
				rs.getInt("doctorId"),
				rs.getString("realName"),
				rs.getString("department"),
				rs.getString("password"),rs.getString("usertype"),	
				rs.getString("locationLat"),rs.getString("locationLong"),
				rs.getString("address"),rs.getString("location"),rs.getString("openTime"),
				rs.getString("closeTime"),rs.getDate("postTime").toLocalDate());

			hm.put(rs.getInt("postId"), doctorDetail);
		}
	}
	catch(Exception e)
	{
	}
	return hm;
}		
}
