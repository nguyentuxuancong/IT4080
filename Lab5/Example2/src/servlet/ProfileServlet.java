package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("hUsername");
        if (name != null && !name.equals("")) {
            out.print("<b>Welcome to Profile</b>");
            out.print("<br>Welcome, " + name);
        } else {
            out.print("<font color=red>Please login first</font>");
            request.getRequestDispatcher("login.html").include(request,
                    response);
        }
        out.close();
    }
}