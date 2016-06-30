package servlets;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.hash.Hashing;


import model.UserDAO;
import pojo.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if (username != null && username.length() > 2) {
				if (password.length() > 5) {
					try {
						String hashPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
						
						new UserDAO().addUser(new User(email, username, hashPassword));
						response.sendRedirect("./MoviesPage.jsp");
					} catch (SQLException e) {
						e.printStackTrace();
						response.sendRedirect("./ErrorServlet");

						request.setAttribute("errorDB", "This username is already taken!");
						RequestDispatcher rd = request.getRequestDispatcher("./signUpPage.jsp");
						rd.forward(request, response);

					}
				} else {
					request.setAttribute("shortPassword", "The password must be at least 6 symbols!");
					RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
					rd.forward(request, response);
				}

			} 
		else {
			request.setAttribute("errorMessage", "Incorrect username or password!");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}

	}

}