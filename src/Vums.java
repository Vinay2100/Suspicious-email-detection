import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Vums extends HttpServlet
{
 public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 { 
      try
   {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");

     HttpSession session=req.getSession(false);
     
     res.setContentType("text/html");
     PrintWriter out=res.getWriter();
      
      String user=(String)session.getAttribute("username");
      System.out.println(user);
      out.println(user);
      
      Statement st=con.createStatement();
      ResultSet rs=st.executeQuery("select * from mails");
      out.println("<html><body>");
      out.println("<table border=1>");
      out.println("<tr><th>From</th> <th>Message</th></tr>");

         while (rs.next()) {
                if(user.equals(rs.getString(2)))
    {
 String from = rs.getString(1);
                 String message= rs.getString(3);
             
                 out.println("<tr><td>" + from + "</td><td>" + message + "</td></tr>"); 
             }
     

   }
        out.println("</table></body></html>"); 
  }
catch(Exception e)
  {
     e.printStackTrace();
  }
}
}