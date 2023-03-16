package onlineBank;

import java.sql.*;  
public class LoginDao {  
  
public static boolean validate(LoginBean bean){  
boolean status=false;  
try{  
Connection con=GetCon.getCon();  
String userName = bean.getUsername();
String passWord = bean.getPass();
System.out.println(userName);
System.out.println(passWord);
              
PreparedStatement ps=con.prepareStatement(  
    "select * from NEWACCOUNT where username=? and password=?");  
  
ps.setString(1,userName);  
ps.setString(2, passWord);  
              
ResultSet rs=ps.executeQuery();  
status=rs.next();  
              
}catch(Exception e){}  
  
return status;  
  
}  
}  