package controller;

import bll.CategoryBLL;
import bll.ProductBLL;

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
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);

        ProductBLL productBLL = new ProductBLL();
        getServletContext().setAttribute("newProducts", productBLL.getNewProducts(5));

        CategoryBLL categoryBLL = new CategoryBLL();
        getServletContext().setAttribute("newCategories",categoryBLL.getNewCategories(5));
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