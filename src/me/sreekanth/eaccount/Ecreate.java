package me.sreekanth.eaccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
public class Ecreate extends HttpServlet {
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
        out.println("<form method='POST' action='EcreateSubmit'> ");
        out.println("<Table>");
        out.println("<tr><td>Account Number: </td><td><input type='text' name='accountNumber' value=''></td></tr>");
        out.println("<tr><td>First Name: </td><td><input type='text' name='firstname' value=''></td></tr>");
        out.println("<tr><td>Last Name: </td><td><input type='text' name='lastname' value=''></td></tr>");
        out.println("<tr><td>Address: </td><td><input type='text' name='address' value=''></td></tr>");
        out.println("<tr><td>Zicode: </td><td><input type='text' name='zipcode' value=''></td></tr>");
        out.println("<tr><td>Opening Balance: </td><td><input type='text' name='balance' value=''></td></tr>");
        out.println("<tr><td>Verify details before submission</td><td><input type='submit' value='create'></td></tr>");
        out.println("<Table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}