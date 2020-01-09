package controller;

import entity.Category;
import entity.Product;
import entity.ProductDetail;
import session_bean.CategorySessionBean;
import session_bean.ProductSessionBean;
import session_bean.*;

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
        urlPatterns = {"/product", "/category"})
public class ControllerServlet extends HttpServlet {
    @EJB
    private CategorySessionBean categorySB;
    @EJB
    private ProductSessionBean productSB;
    @EJB
    private ProductDetailSessionBean productDetailSB;

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
        else if (userPath.equals("/product")){
            Product selectedProduct;
            ProductDetail selectedProductDetail;
            String productId = request.getQueryString();
            if (productId != null){
                selectedProduct =
                        productSB.find(Integer.parseInt(productId));
                selectedProductDetail =
                        productDetailSB.find(Integer.parseInt(productId));
                HttpSession session = request.getSession();
                session.setAttribute("selectedProduct", selectedProduct);
                session.setAttribute("selectedProductDetail",
                        selectedProductDetail);
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