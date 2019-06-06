package model;

import entity.Product;
import entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    public ArrayList<Product> getList() {
        ArrayList<Product> results = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommand = "insert into products (id, price, frame) values (?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String price = resultSet.getString("price");
                String frame = resultSet.getString("frame");
                Product product = new Product();
                product.setId(id);
                product.setPrice(price);
                product.setFrame(frame);
                results.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }

}