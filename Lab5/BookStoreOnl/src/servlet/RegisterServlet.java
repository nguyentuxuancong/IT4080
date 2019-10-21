package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.*;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request,response);
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        String fullName = request.getParameter("fullName");
        if(usr == null || pwd == null || fullName == null){
            out.println("<font color=red>Something wrong!</font>");
            request.getRequestDispatcher("Register.jsp").include(request,response);
        }else{
            Reader reader = new Reader(usr,pwd,fullName);
            ListReaders.getInstance().addReader(reader);
            out.print("<font color=blue>You have successfully registered!</font>");
            out.print("<br>Welcome " + reader);
            HttpSession session =request.getSession();
            session.setAttribute("reader",reader);
        }
        out.close();
    }
}
