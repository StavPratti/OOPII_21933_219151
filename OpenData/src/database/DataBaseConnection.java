package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import totravel.City;

public class DataBaseConnection {
	static Connection db_con_obj = null; //A connection (session) with a specific database. SQL statements are executed and results are returned within the context 
	//of a connection. A Connection object's database is able to provide information describing its tables, its supported SQL grammar, its stored procedures, 
	//the capabilities of this connection, and so on. This information is obtained with the getMetaData method.
	static PreparedStatement db_prep_obj = null;//An object that represents a precompiled SQL statement.
	//A SQL statement is precompiled and stored in a PreparedStatement object. This object can then be used to efficiently execute this statement multiple times.
	

	public static void makeConnection() {
		 
		try {//We check that the DB Driver is available in our project.		
			Class.forName("oracle.jdbc.driver.OracleDriver"); //This code line is to check that JDBC driver is available. Or else it will throw an exception. Check it with 2. 
			System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!"); 
		} catch (ClassNotFoundException e) {
			System.out.println("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
			e.printStackTrace();
			return;
		}
 
		try {
			// DriverManager: The basic service for managing a set of JDBC drivers.	 //We connect to a DBMS.
			db_con_obj = DriverManager.getConnection("jdbc:oracle:thin:@oracle12c.hua.gr:1521:orcl","IT219151","IT219151");// Returns a connection to the URL.
			//Attempts to establish a connection to the given database URL. The DriverManager attempts to select an appropriate driver from the set of registered JDBC drivers.
			if (db_con_obj != null) { 
				System.out.println("Connection Successful! Enjoy. Now it's time to CRUD data. ");
				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println("MySQL Connection Failed!");
			e.printStackTrace();
			return;
		}
 
	}
	
	public static Map<String, City>  ReadData(Map<String, City> mapOfCities) throws SQLException {
	db_prep_obj = db_con_obj.prepareStatement("select * from CITIES");
	ResultSet  rs = db_prep_obj.executeQuery();
	 
    while (rs.next()){
        String cityName = rs.getString("cityname");
        String country=rs.getString("country");
        double lat = rs.getDouble("lat");
        double lon = rs.getDouble("lon");
        int sea=rs.getInt("sea");
        int walls = rs.getInt("walls");
        int ancient = rs.getInt("ancient");
        int mountain = rs.getInt("mountain");
        int cafe=rs.getInt("cafe");
        int museum = rs.getInt("museum");
        int squeare = rs.getInt("squeare");
        int restaurant = rs.getInt("restaurant");
        int views = rs.getInt("views");
        int forest = rs.getInt("forest");
       
       // System.out.println( +lat+" "+lon );
        
       City city=new City(cityName,country);
       city.setGeodestic_vector(new double[] {lat,lon});
       city.setTerms_vector(new int[] {sea,walls,ancient,mountain,cafe,museum,squeare,restaurant,views,forest});
       mapOfCities.put(cityName, city);
        
    }
	return mapOfCities;
   
}
	public static void addDataToTableCities(String cityName, String country, double lat, double lon,int sea,int walls,int ancient,int mountain, int cafe, int museum, int squeare,int restaurant,int views ,int forest) {
		 
		try {
			String insertQueryStatement = "INSERT  INTO  cities  VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//static Connection db_con_obj = null;
			//static PreparedStatement db_prep_obj = null;
			
			db_prep_obj = db_con_obj.prepareStatement(insertQueryStatement);
			db_prep_obj.setString(1, cityName);//.setString
			db_prep_obj.setString(2, country);
			db_prep_obj.setDouble(3, lat);
			db_prep_obj.setDouble(4, lon);
			db_prep_obj.setInt(5, sea);
			db_prep_obj.setInt(6, walls);
			db_prep_obj.setInt(7, ancient);
			db_prep_obj.setInt(8, mountain);
			db_prep_obj.setObject(9, cafe);
			db_prep_obj.setObject(10, museum);
			db_prep_obj.setObject(11, squeare);
			db_prep_obj.setObject(12, restaurant);
			db_prep_obj.setObject(13, views);
			db_prep_obj.setObject(14, forest);
			
			// execute insert SQL statement Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement
			int numRowChanged = db_prep_obj.executeUpdate(); //either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
			//System.out.println("Rows "+numRowChanged+" changed.");
			
		} catch (
 
		SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
