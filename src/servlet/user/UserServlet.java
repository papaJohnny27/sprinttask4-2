package servlet.user;

import domain.Database;
import domain.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Integer userId = null;
        for (User user : Database.getAllUser()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                userId = user.getId();
                break;
            }
        }

        if (userId != null){
            resp.sendRedirect("/user-details?userId=" + userId);
            return;
        }

        resp.sendRedirect("/login?errorFlag=true");
    }
}
