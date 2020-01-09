package controller;

import entity.Category;
import entity.Product;
import session_bean.CategorySessionBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerServlet",
        urlPatterns = {"/ControllerServlet", "/category"})
public class ControllerServlet extends HttpServlet {
    @EJB
    private CategorySessionBean categorySB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        if (userPath.equals("/category")) {
            String categoryId = request.getQueryString();
            if (categoryId != null) {
                Category selectedCategory;
                List<Product> categoryProducts;
                selectedCategory = categorySB.find(Integer.parseInt(categoryId));
                HttpSession session = request.getSession();
                session.setAttribute("selectedCategory", selectedCategory);
                categoryProducts = (List<Product>) selectedCategory.getProducts();
                session.setAttribute("categoryProducts", categoryProducts);
            }
        }
        String url = userPath + ".jsp";
        try{
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
    }
}