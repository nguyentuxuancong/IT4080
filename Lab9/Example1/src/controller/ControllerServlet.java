package controller;

import session_bean.ProductSessionBean;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {"/ControllerServlet"})

public class ControllerServlet extends HttpServlet {
    @EJB
    private ProductSessionBean productSessionBean;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
// store new product list in servlet context
        getServletContext().setAttribute("newProducts",
                productSessionBean.findRange(new int[]{0,5}));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}