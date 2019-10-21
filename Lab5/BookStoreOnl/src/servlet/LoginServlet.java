package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import model.*;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request,response);
        HttpSession session = request.getSession();
        Reader reader = (Reader)session.getAttribute("reader");
        if(reader!=null) {
            out.print("Hello " + reader);
            out.print("<br><font color=blue>You are already logged in!</font>");
        }
        else
            request.getRequestDispatcher("login.jsp").include(request,response);
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request,response);
        String usr = request.getParameter("usr");
        String pwd = request.getParameter("pwd");
        Reader reader = new Reader(usr,pwd);
        reader = ListReaders.getInstance().getReader(reader);
        HttpSession session = request.getSession();
        if(reader!=null){
            out.print("<font color=blue>You have successfully logged in!</font>");
            out.print("<br>Welcome " + reader);
            session.setAttribute("reader",reader);
        }else {
            out.print("<font color=red>Username or password is incorrect!</font>");
            request.getRequestDispatcher("login.jsp").include(request,response);
        }
        out.close();
    }
}
