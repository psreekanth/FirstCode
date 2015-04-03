package me.sreekanth.test;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ebanking extends HttpServlet {
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
        	List<Eaccounts> accounts = showAccounts();
        	out.println("<Table>");
        	for(Eaccounts account:accounts)
        	{
        		out.println("<tr><td><b>Account No:</b></td><td width='200'>"+account.getAccountnumber()+
        				"</td><td><b>Name:</b></td><td width='300'>"+account.getFirstname()+
        				" "+account.getLastname()+
        				"</td><td><b>Balance</b></td><td width='100'>"+account.getBalance()+"</td>"
        						+ "<td><a href='EaccountDelete?id="+account.getId()+"'>Delete</a></td>"
        						+ "<td><a href='Edeposit?id="+account.getId()+"'>Deposit</a></td>"
        						+ "<td><a href='Ewithdraw?id="+account.getId()+"'>Withdraw</a></td>"
        						+ "</tr>");
        	}
        	out.println("</Table>");
        	out.println("</br></br><form method='POST' action='Ecreate'>");
        	out.println("<input type='submit' value='Create new account'>");
        	out.println("</form>");
        	out.println("<br><br>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("Unable to get accounts");
		}
        out.println("</body>");
        out.println("</html>");
    }
	public List<Eaccounts> showAccounts() throws Exception
	{
	      // create a mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://localhost:3306/account";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "Pizza");
	      String query = "SELECT * FROM accounts";
	      Statement st = conn.createStatement();
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      List<Eaccounts> accounts = new ArrayList<Eaccounts>();
	      while (rs.next())
	      {
	    	int id = rs.getInt("id");
	        long account = rs.getLong("accountNumber");
	        String firstname = rs.getString("firstname");
	        String lastname = rs.getString("lastname");
	        int balance = rs.getInt("balance");
	        Eaccounts bank = new Eaccounts(id,account,firstname,lastname,balance);
	        accounts.add(bank);
	      }    
	      st.close();      
	      return accounts;
	      // iterate through the java resultset  
	}
}