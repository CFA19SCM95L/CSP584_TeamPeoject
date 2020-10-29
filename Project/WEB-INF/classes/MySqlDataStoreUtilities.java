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