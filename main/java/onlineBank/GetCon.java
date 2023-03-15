package onlineBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCon {
	private GetCon(){}

	public static Connection con;
	static{
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			System.out.println("Exception in GetCon");
		}
		
	}
	public static Connection getCon(){
		return con;
	}



	public static int getPrimaryKey(){
		int nextvalue=0;
		Connection con=GetCon.getCon();
		PreparedStatement ps2;
		try {
		
		ps2=con.prepareStatement("select kinshuknewaccount.nextval from dual");
		
		ResultSet rs=ps2.executeQuery();
		rs.next();
		nextvalue=rs.getInt(1);

		
		
	} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return nextvalue;

	}
}
