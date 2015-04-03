package me.sreekanth.eaccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EaccountDelete extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ebanking</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Account details:</h1>");
        try {     
        	String idvalue = request.getParameter("id");
        	int id = Integer.valueOf(idvalue);
        	deleteAccounts(id);
        	out.println("Account deleted");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unable to get accounts");
		}
        out.println("</body>");
        out.println("</html>");
    	
    }	
	public void deleteAccounts(int id) throws Exception
	{
	      // create a mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/account";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "Pizza");
	      
	      
	      String query = "DELETE FROM accounts WHERE id = ?";
	      Statement st = conn.createStatement();
	      // execute the query, and get a java resultset
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt(1, id);
	      preparedStmt.execute();
	      conn.close();      

	      // iterate through the java resultset  
	}
}
