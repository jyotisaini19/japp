// Import required java libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
// Extend HttpServlet class
public class service extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      boolean st =false;
      //Receiving Ajax/jQuery GET request data
      //Receive the name of the room 
      String room = request.getParameter("room");

      String season = null;

      try{

          //loading drivers for mysql
          Class.forName("com.mysql.jdbc.Driver");

          //Creating connection to database
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/japp", "root", "123456");

          //Preparing sql statement
          Statement stmt = conn.createStatement();
          String sql;
          sql = "SELECT status from house_automation where room = '"+room+"'";

          //Executing sql statement and storing result in ResultSet variable
          ResultSet rs = stmt.executeQuery(sql);

          //Converting sql query result into string
          while(rs.next()) {
              season = rs.getString("status");
          }

          /** Checking status of room in database
           * if the status is "FALSE", change it to "TRUE"
           * Returns/Prints result
           *"0" if the status turns to "TRUE"
           * "1" if the status turns to "FALSE"
           */
          if(season.equals("FALSE"))
          {
              //Preparing sql "UPDATE" statement to change status of room in database
              sql = "UPDATE house_automation SET status = 'TRUE' WHERE room = ? ";
              PreparedStatement preparedStmt = conn.prepareStatement(sql);
              preparedStmt.setString(1, room);

              //Executing UPDATE statement
              preparedStmt.executeUpdate();

              //Printing/Returning result
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();
              out.println(0);

              stmt.close();
              conn.close();

          }

          else {
              sql = "UPDATE house_automation SET status = 'FALSE' WHERE room = ? ";
              PreparedStatement preparedStmt = conn.prepareStatement(sql);
              preparedStmt.setString(1, room);
              preparedStmt.executeUpdate();
              response.setContentType("text/html");
              PrintWriter out = response.getWriter();
              out.println(1);
              stmt.close();
              conn.close();
          }


      }catch(Exception e)
      {
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          out.println(e);
      }
  }
}