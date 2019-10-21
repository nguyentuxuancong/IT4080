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
            String url = response.encodeRedirectURL("viewProfile.jsp?name=" + name);
            response.sendRedirect(url);
        } else {
            out.print("<font color=red>sorry, username or password error!</font>");
            request.getRequestDispatcher("login.html").include(request,
                    response);
        }
        out.close();
    }
}