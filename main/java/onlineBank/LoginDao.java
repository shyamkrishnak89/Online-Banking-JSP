package onlineBank;
import java.sql.*;

public class LoginDao {
	public static boolean validate(LoginBean bean){  
		boolean status=false;  
		try{  
		Connection con=GetCon.getCon();  
		String userName = bean.getUsername();
		int accountNum = bean.getAccountNo();
		String passWord = bean.getPass();
		System.out.println("From Dao"+userName);
		System.out.println("From Dao"+passWord);
		              
		PreparedStatement ps=con.prepareStatement(  
		    "select * from NEWACCOUNT where accountno=? and password=?");  
		  
		ps.setInt(1,accountNum);  
		ps.setString(2, passWord);  
		              
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		              
		}catch(Exception e){}  
		  
		return status;  
		  
		}  

}
