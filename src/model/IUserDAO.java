package model;

import java.sql.SQLException;
import java.util.List;

import pojo.User;

public interface IUserDAO {

	void addUser(User user) throws SQLException;

	void addStaff(User user) throws SQLException;

	boolean validateUserCredentials(String userName, String password) throws SQLException;

	List<User> findAllUsers() throws SQLException;

	User findUserByName(String userName) throws SQLException;

}