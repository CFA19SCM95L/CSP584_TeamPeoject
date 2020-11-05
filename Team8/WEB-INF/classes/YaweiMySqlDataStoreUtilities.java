
import java.sql.*;
import java.util.*;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Statement;
                	
public class YaweiMySqlDataStoreUtilities
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
			{	/*public User(int id,String userName, String password,String email, 
	String usertype,String address, String lat, String longt, 
	String location)*/
		
				User user = new User(rs.getInt("userId"),rs.getString("username"),
									rs.getString("password"),rs.getString("email"),
									rs.getString("usertype"),rs.getString("address"),
									rs.getString("locationLat"),
									rs.getString("locationLong"),rs.getString("location"));
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
		//Statement stmt=conn.createStatement();
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

/**************************************************GET 10 Doctors******************************************************/
public static ArrayList<DoctorDetail> getTenDoctor()
{	
	ArrayList<DoctorDetail> list=new ArrayList<DoctorDetail>();
	try 
	{
		getConnection();
		Statement stmt=conn.createStatement();
		String getTenDoctorDetails="SELECT * FROM doctordetails order by realName ASC limit 10";
		PreparedStatement pst = conn.prepareStatement(getTenDoctorDetails);
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

			list.add(doctorDetail);
		}
	}
	catch(Exception e)
	{
	}
	System.out.println(list.toString());
	return list;
}	
}
