import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.servlet.*;
import javax.servlet.http.*;
public class EcreateSubmit extends HttpServlet {
	
	public static void doCreate(long accountNumber, String fname, String lname, String address, int zipcode, int balance) throws Exception
	{

	      // create a mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/account";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "Pizza");
	     
	      // create a sql date object so we can use it in our INSERT statement
	      //Calendar calendar = Calendar.getInstance();
	      //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	 
	      // the mysql insert statement
	      String query = " insert into accounts (id,accountNumber,firstname,lastname,address,zipcode,balance)"
	        + " values (?, ?, ?, ?, ?, ?, ?)";
	 
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt	 (1, 0);
	      preparedStmt.setLong	 (2, accountNumber);
	      preparedStmt.setString (3, fname);
	      preparedStmt.setString (4, lname);
	      preparedStmt.setString (5, address);
	      preparedStmt.setInt    (6, zipcode);
	      preparedStmt.setInt    (7, balance);
	      // execute the preparedstatement
	      preparedStmt.execute();
	      conn.close();    
	
	}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ebanking</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Will Create Account</h1>");
        try {
        	String accountValue = request.getParameter("accountNumber");
        	String fname = request.getParameter("firstname");
        	String lname = request.getParameter("lastname");
        	String address = request.getParameter("address");
        	String zipcodeValue = request.getParameter("zipcode");
        	String balanceValue = request.getParameter("balance");
        	
        	long account = Long.valueOf(accountValue);
        	int zipcode = Integer.valueOf(zipcodeValue);
        	int balance = Integer.valueOf(balanceValue);
        	
			doCreate(account,fname,lname,address,zipcode,balance);
			out.println("Account created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unable to create account");
		}
        out.println("</body>");
        out.println("</html>");
    }
}