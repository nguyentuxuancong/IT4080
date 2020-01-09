package bll;

import entity.Category;
import entity.Product;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryBLL {
    public List<Category> getNewCategories(int number) {
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/eMarket");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "select * from emarket.category";
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryID(rs.getInt("category_id"));
                c.setName(rs.getString("name"));
                c.setImage(rs.getString("image"));
                categories.add(c);
            }
            return categories;
        } catch (SQLException ex) {
        }catch (Exception e){
            Logger.getLogger(ProductBLL.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
}
