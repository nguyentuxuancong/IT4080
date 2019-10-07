package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import models.Product;
import sun.net.ConnectionResetException;

public class ProductDAO {
    private int noOfRecords;

    public ProductDAO() {
    }

    public List<Product> viewAllProducts(int offset, int noOfRecords) {
        String query = "select SQL_CALC_FOUND_ROWS * from productdb.product limit " + offset + "," + noOfRecords;
        List<Product> list = new ArrayList<Product>();
        Product product = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/productdb");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                product = new Product();
                product.setProductId(rs.getInt("Product_id"));
                product.setName(rs.getString("Name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getInt("price"));
                product.setCatogoryId(rs.getInt("category_id"));
                list.add(product);
            }
            rs.close();

            rs = statement.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }
}
