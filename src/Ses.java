import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Ses extends HttpServlet
{
 public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 { 
      try
   {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");

     HttpSession session=req.getSession(false);
     
     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
      
      String sender=(String)session.getAttribute("username");
      String toaddress=req.getParameter("to");
      String input=req.getParameter("message");
    
      input=input.toLowerCase();
      int index=input.indexOf("bomb");  int inde=input.indexOf("rdx");  int ind=input.indexOf("gun");  int ine=input.indexOf("blast");
     
    if(index == -1 && inde == -1 && ind == -1 && ine == -1)
       {
          System.out.println("store in user");
          PreparedStatement ps=con.prepareStatement("insert into mails values(?,?,?)");
          ps.setString(1,sender);
          ps.setString(2,toaddress);
          ps.setString(3,input);
          int k=ps.executeUpdate();
          if(k>0)
           {
             pw.println("mail sent success");
           }
          else
           {
             pw.println("mail sending failed");
           }
         }
   else
      { 
         System.out.println("store in admin");
     
          PreparedStatement ps=con.prepareStatement("insert into adminmails values(?,?,?)");
          ps.setString(1,sender);
          ps.setString(2,toaddress);
          ps.setString(3,input);
          int k=ps.executeUpdate();
          if(k>0)
           {
             pw.println("mail sent success");
           }
         
       }
   }
catch(Exception e)
  {
     e.printStackTrace();
  }
}
}