package model;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.User;

public class UserDAO {

    public void addUser(User user) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO user(username,password,email) VALUES(?,?,?,true);");

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
    }

    public void addStaff(User user) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO user(username,password,email) VALUES(?,?,?,false);");

        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.executeUpdate();
    }

    public boolean validateUserCredentials(String userName, String password) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE userName=? AND password=?");
        ps.setString(1, userName);
        ps.setString(2, password);
        ResultSet executeQuery = ps.executeQuery();
        return executeQuery.getString(1) != null;
    }

    public List<User> findAllUsers() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM User");
        List<User> users = new LinkedList<>();
        ResultSet executeQuery = ps.executeQuery();
        while (executeQuery.next()) {
            User user = new User();
            user.setUsername(executeQuery.getString("userName"));
            user.setPassword(executeQuery.getString("password"));
            user.setEmail(executeQuery.getString("email"));
            user.setCustomer(executeQuery.getBoolean("is_customer"));
            users.add(user);
        }
        return users;
    }

    public User findUserByName(String userName) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM User WHERE userName = ?");
        ps.setString(1, userName);
        ResultSet executeQuery = ps.executeQuery();
        User user = new User();
        if (executeQuery != null) {
            user.setUsername(executeQuery.getString("userName"));
            user.setPassword(executeQuery.getString("password"));
            user.setEmail(executeQuery.getString("email"));
            user.setCustomer(executeQuery.getBoolean("is_customer"));
        }
        return user;
    }

}
