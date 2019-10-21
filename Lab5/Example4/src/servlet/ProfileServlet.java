package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        HttpSession session = request.getSession();
        if (session.getAttribute("name") != null) {
            String name = (String)session.getAttribute("name");
            if (name != null) {
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + name);
            }
        } else {
            out.print("<font color=red>Please login first</font>");
            request.getRequestDispatcher("login.html").include(request,response);
        }
        out.close();
    }
}