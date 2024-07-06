package com.personalatmservlet.dao;

import com.personalatmservlet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmservlet", "root", "D!lemma628");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }


    public void saveUser(User user) {
        final String query = "insert into user (firstname, lastname, email, phone, username, password, balance) " +
                "values(?, ?, ?, ?, ?, ?, ?);";

        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setDouble(7, user.getBalance());
            if(preparedStatement.executeUpdate() > 0)
                System.out.println("User successfully saved!");
            else System.out.println("Something went wrong!");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    public User getUserByUserName(String uname) {
        final String query = "select id, firstname, lastname, email, phone, username, password, balance from user where username=?;";

        User user = null;

        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,uname);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");
                user = new User(id, firstname, lastname, email, phone, username, password, balance);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers(){
        List<User> userList = new ArrayList<>();
        String query = "select * from user";

        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                double balance = rs.getDouble("balance");
                userList.add(new User(id, firstname, lastname, email, phone, username, password, balance));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void updateBalance(int id, double balance) {
        String query = "update user set balance=? where id=?";

        try(Connection connection = getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
