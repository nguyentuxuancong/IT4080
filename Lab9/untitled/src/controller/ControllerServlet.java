package controller;
import session_bean.ProductSessionBean;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.sql.DataSource;

@WebServlet(name = "ControllerServlet", loadOnStartup = 1, urlPatterns = {"/ControllerServlet"})
public class ControllerServlet extends HttpServlet {
    @EJB
    private ProductSessionBean productSessionBean;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException{
        super.init(servletConfig);
        getServletContext().setAttribute("newProducts",
                productSessionBean.findRange(new int[]{0,5}));
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse res)throws SecurityException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse res) throws SecurityException, IOException{

    }

}
