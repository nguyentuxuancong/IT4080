package controller;

import entity.Category;
import entity.Product;
import entity.ProductDetail;
import session_bean.CategorySessionBean;
import session_bean.ProductSessionBean;
import session_bean.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
        urlPatterns = {"/product", "/category","/addProduct"})
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
        String userPath = request.getServletPath();
        if(userPath.equals("/addProduct")){
            Product product = new Product();
            ProductDetail productDetail = new ProductDetail();

            List<Product> products = (List<Product>) productSB.findAll();
            product.setProductId(products.get(products.size() - 1).getProductId() + 1);
            product.setName(request.getParameter("name"));
            product.setPrice(BigDecimal.valueOf(Double.valueOf(request.getParameter("price"))));
            product.setDescription(request.getParameter("description"));
            product.setLastUpdate(new Timestamp(new Date().getTime()));
            product.setCategory(categorySB.find(Integer.valueOf(request.getParameter("categoryId"))));
            product.setImage(request.getParameter("image"));
            product.setDescriptionDetail(request.getParameter("description_detail"));

            productDetail.setProductId(product.getProductId());
            productDetail.setInformation(request.getParameter("information"));
            productDetail.setImage1(request.getParameter("image1"));
            productDetail.setImage2(request.getParameter("image2"));
            productDetail.setImage3(request.getParameter("image3"));
            productDetail.setImage4(request.getParameter("image4"));
            productDetail.setImage5(request.getParameter("image5"));
            productDetail.setAccessories(request.getParameter("accessories"));
            productDetail.setGuaranty(request.getParameter("guaranty"));

            HttpSession session = request.getSession();
            session.setAttribute("selectedProduct", product);
            session.setAttribute("selectedProductDetail",productDetail);

            try{
                request.getRequestDispatcher("/previewProduct.jsp").forward(request, response);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}