<html>
<head>
<link href="ext1.css" rel="stylesheet" type="text/css" media="all" />
  </head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>

   <h1> Users </h1>
<section>
 <table align="center" cellpadding="0" border="0">
  <tr>
    <th>Username</th>
    <th>Password </th>
    <th>Email </th>
    <th>Phonenumber </th>
  </tr>
<%  
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");
    
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery("select * from student");
  while(rs.next())
  {
    %>
        <tr>
            <td><%=rs.getString(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
            <td><%=rs.getString(4) %></td>
           
       </tr>
    <%
  }
%>

 </table>
</section>
<%
 rs.close();
 st.close();
 con.close();
}
 catch(Exception e)
 {
  e.printStackTrace();
 }
%>
</body>
</html>
