package servlets;

import dao.ProductDAO;
import models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product.do"})
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 5;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.viewAllProducts((page - 1)*recordsPerPage,recordsPerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPage = (int) Math.ceil(noOfRecords * 1.0/recordsPerPage);
        request.setAttribute("productList",list);
        request.setAttribute("noOfPages",noOfPage);
        request.setAttribute("currentPage",page);
        RequestDispatcher view = request.getRequestDispatcher("viewProduct.jsp");
        view.forward(request,response);

    }
}
