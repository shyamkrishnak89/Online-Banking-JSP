<%@page import="onlineBank.LoginDao"%>  
<jsp:useBean id="obj" class="onlineBank.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  <%@ include file="ind.jsp" %>  
  <hr/>  
<%  
boolean status=LoginDao.validate(obj);  
if(status){  
out.println("You r successfully logged in");  
session.setAttribute("session","TRUE");  
}  
else  
{  
out.print("Sorry, email or password error");  
%>  
<jsp:include page="ind.jsp"></jsp:include>  
<%  
}  
%>  