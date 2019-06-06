package model;

import entity.Student;

import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;

public class StudentModel {
    public boolean save(Student student){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student-manager?user=root&password=");
            Statement statement = connection.createStatement();
            String sqlCommal = "insert into students (username, password, email, fullname, address)" +
                    "values ('" + student.getUsername() +"', '" +student.getPassword() +"', '" +student.getEmail() +"', '" +student.getFullname() +"', '" +student.getAddress() +"')";
            statement.execute(sqlCommal);
            System.out.println("Oki");
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    public boolean save2(Student student){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommal = "insert into students (username, password, email, fullname, role, address) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommal);
            preparedStatement.setString(1, student.getUsername());
            preparedStatement.setString(2, md5(student.getPassword()));
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getFullname());
            preparedStatement.setString(5, student.getRole());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.execute();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static String md5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return  sb.toString();
        } catch (Exception ex) {
            return "";
        }
    }

    public ArrayList<Student> getList() {
        ArrayList<Student> results = new ArrayList<>();
        try {
            String sqlCommand = "select * from students";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                String address = resultSet.getString("address");
                Student student = new Student();
                student.setUsername(username);
                student.setPassword(password);
                student.setFullname(fullName);
                student.setEmail(email);
                student.setRole(role);
                student.setAddress(address);
                results.add(student);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return results;
    }

    public Student findByUsernameAndStatus(String username, Student.Status status){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sqlCommad = "select * from students where username = ? and status = ?";
            PreparedStatement pePreparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommad);
            pePreparedStatement.setString(1, username);
            pePreparedStatement.setInt(2, status.getValue());
            ResultSet resultSet = pePreparedStatement.executeQuery();
            if (resultSet.next()){
                String rsUsername = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsEmail = resultSet.getString(3);
                String rsFullName = resultSet.getString(4);
                String rsRole = resultSet.getString(5);
                String rsAddress = resultSet.getString(6);
                int rsStatus = resultSet.getInt(7);
                Student student = new Student();
                student.setUsername(rsUsername);
                student.setPassword(rsPassword);
                student.setEmail(rsEmail);
                student.setFullname(rsFullName);
                student.setRole(rsRole);
                student.setAddress(rsAddress);
                student.setStatus(Student.Status.findByValue(rsStatus));
                return student;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}