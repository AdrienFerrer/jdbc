package labs.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila","root", "root" );
			Statement stmt=null;
			String query = "SELECT * FROM actor" ;
	        stmt =(Statement) con.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	        int columnsNumber = rsmd.getColumnCount();   
	        
	        
	        while (rs.next()) {       
	        for(int i = 1 ; i <= columnsNumber; i++){
	              System.out.print(rs.getString(i) + " "); //Print one element of a row
	        }
	          System.out.println();//Move to the next line to print the next row.           
	            }
	        while (rs.next()) {
	        	  String lastName = rs.getString("last_name");
	        	  System.out.println(lastName + "\n");
	        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
