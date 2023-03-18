/*
 * To be changed before running
 * line: 23 -> Enter the servername of your DB in place of "servername",
       Enter the port_number of your DB in place of "port_number",
       Enter User name and Password in place of "User_Name here" & "Password here" respectively
connection = DriverManager.getConnection("jdbc:mysql://servername:port_number/rfid_basedshoppingsystem?useSSL=false", "User_Name here", "Password here");
 *
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnectionToDatabase() {
		Connection connection = null;

		try {

			// load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("MySQL JDBC Driver Registered!");

			// get hold of the DriverManager
			connection = DriverManager.getConnection("jdbc:mysql://servername:port_number/rfid_basedshoppingsystem?useSSL=false", "User_Name here", "Password here");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			//e.printStackTrace();

		}

		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			//e.printStackTrace();

		}

		if (connection != null) {
			//System.out.println("Connection made to DB!");
		}
		return connection;
	}

}
