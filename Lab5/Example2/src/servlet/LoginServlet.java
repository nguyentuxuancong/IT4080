package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("user");
        String password = request.getParameter("pwd");
        if (password.equals("admin123")) {
            out.print("You are successfully logged in!");
            out.print("<br>Welcome, " + name);
            out.print("<form action='ProfileServlet' method='GET'>");
            out.print("<input type='hidden' name='hUsername' value='" + name + "' />");
            out.print("<input type='submit' value='View Profile' />");
            out.print("</form>");
        } else {
            out.print("<font color=red>sorry, username or password error ! </font > ");
            request.getRequestDispatcher("login.html").include(request,
                    response);
        }
        out.close();
    }
}