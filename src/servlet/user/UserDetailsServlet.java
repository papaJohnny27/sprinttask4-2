package servlet.user;

import domain.Database;
import domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-details")
public class UserDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Integer userId = Integer.valueOf(req.getParameter("userId"));
    User user = Database.getByUserId(userId);

    req.setAttribute("userDetails",user);
    req.getRequestDispatcher("/user_details.jsp").forward(req,resp);
    }
}
