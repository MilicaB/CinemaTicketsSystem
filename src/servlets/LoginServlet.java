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
import javax.servlet.http.HttpSession;

import com.google.common.hash.Hashing;

import model.UserDAO;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        try {
            boolean isExist = new UserDAO().validateUserCredentials(username, hashPassword);
            if (isExist == true) {
                // Create a session object if it is already not created.
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(-1);
                request.getSession().setAttribute("user", username);
                response.sendRedirect("./index.jsp");
            } else {
                request.setAttribute("errorMessage", "Incorrect username or password!");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("./ErrorServlet");
        }

    }

}
