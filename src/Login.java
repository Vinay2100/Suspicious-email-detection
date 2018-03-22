import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet
{
   public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    try
   {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","VINAY","system");

     res.setContentType("text/html");
     PrintWriter pw=res.getWriter();
    
     String email=req.getParameter("email");
     String pass=req.getParameter("pass");
 
     HttpSession session=req.getSession(true);
     session.setAttribute("username",email);
     
    Statement st=con.createStatement(); 
    ResultSet rs=st.executeQuery("select * from student");
    while(rs.next())
   {
       System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
            if(email.equals(rs.getString(3))&&pass.equals(rs.getString(2)))
               {
                  System.out.println("user login");
                   RequestDispatcher dis=req.getRequestDispatcher("user.jsp");
                    dis.forward(req,res);   
                }
           else
             {
               pw.println("login failed");
             }
   }
   
          if(email.equals("admin@gmail.com")&&pass.equals("admin"))
            { 
                 System.out.println("admin loggin");
                 RequestDispatcher dis=req.getRequestDispatcher("admin.jsp");
                 dis.forward(req,res);
            }
   
          


    }
   catch(Exception e)
     {
     	  e.printStackTrace();
     
     }
  }
}   	   