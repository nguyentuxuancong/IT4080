package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Student;

public class StudentDAO {

    private int noOfRecords;
    public List<Student> viewAllStudents(int offset, int noOfRecords) {
        String query = "select SQL_CALC_FOUND_ROWS * from classmanagement.student limit " + offset + "," + noOfRecords;
        List<Student> list = new ArrayList<Student>();
        Student student = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/productdb");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getInt("StudentId"));
                student.setFirstName(rs.getString("FirstName"));
                student.setLastName(rs.getString("LastName"));
                student.setAddress(rs.getString("Address"));
                student.setTelephone(rs.getString("Telephone"));
                student.setEmail(rs.getString("Email"));
                student.setPassword(rs.getString("Pass"));
                list.add(student);
            }
            rs.close();

            rs = statement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next())
                this.noOfRecords = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int getNoOfRecords() {
        return noOfRecords;
    }

}
