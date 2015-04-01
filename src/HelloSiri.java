import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloSiri extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World!</title>");
        out.println("</head>");
        out.println("<body>");
        int temp = 1500;
        out.println("<h1>Hello I am Sreekanth! Total is "+temp+"</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}