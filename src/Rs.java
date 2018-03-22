import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Rs extends HttpServlet
{
   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    try
   {
     Class.forName("oracle.jdbc.driver.OracleDriver");
    
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");

     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
    
     String uname=req.getParameter("n");
     String pass=req.getParameter("p");
     String email=req.getParameter("e");
     String phone=req.getParameter("ph");
  
  
     PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
     ps.setString(1,uname);
     ps.setString(2,pass);
     ps.setString(3,email);
     ps.setString(4,phone);
    
 
     int i=ps.executeUpdate();
     if(i>0)
     {
       pw.println("registered");
     } 

    }
   catch(Exception e)
     {
     	  e.printStackTrace();
     
     }
     	   
     }

  }

  
   