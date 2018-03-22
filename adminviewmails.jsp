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

 <h1> Suspicious Mails </h1>
<section>
 <table align="center" cellpadding="0" border="0">
  <tr>
    <th> Sender </th>
    <th> Reciever </th>
    <th> Message </th>
  </tr>
  
<%  
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");
   
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery("select * from adminmails");

  while(rs.next())
  {
    %>
        <tr><td><%=rs.getString(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td></tr>
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

