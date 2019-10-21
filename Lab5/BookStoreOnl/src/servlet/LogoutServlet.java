package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request,response);
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("reader") != null) {
            System.out.println("User=" + session.getAttribute("name"));
            session.invalidate();
            out.print("<font color=blue>You are successfully logged out!</font>");
        } else {
            out.println("<font color=red>You are not logged in.</font>");
        }
        out.close();
    }
}
