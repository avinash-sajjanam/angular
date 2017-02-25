import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public Database()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public String getGreatEmployees() throws SQLException
	{
		Connection c = DriverManager.getConnection("jdbc:mysql://1.2.3.4/db", "user", "password");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT name FROM employee WHERE grade = 'A'");

		String employees = "";
		while (rs.next())
		{
			employees += rs.getString("name") + ",";
		}

		c.close();

		return employees;
	}

	public String getGoodEmployees() throws SQLException
	{
		Connection c = DriverManager.getConnection("jdbc:mysql://1.2.3.4/db", "user", "password");
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT name FROM employee WHERE grade = 'B'");

		String employees = "";
		while (rs.next())
		{
			employees += rs.getString("name") + ",";
		}

		c.close();

		return employees;
	}
}
