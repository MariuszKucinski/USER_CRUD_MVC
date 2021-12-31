package controller;

import dao.UserDao;
import entity.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/users/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("name")!=null) {
            String userName = request.getParameter("name");
            if(request.getParameter("email")!=null&&request.getParameter("email").matches("[a-zA-Z0-9-_]+(\\.?[a-zA-Z0-9-_])*@[a-zA-z0-9-_]+\\.[a-zA-Z]{2,8}")){
                String userEmail = request.getParameter("email");
                if(request.getParameter("password")!=null&&request.getParameter("password").matches("[\\S]{8,}")){
                    String userPassword = request.getParameter("password");
                    User tmp = new User(userName,userEmail, BCrypt.hashpw(userPassword, BCrypt.gensalt()));
                    UserDao userDao = new UserDao();
                    userDao.createUser(tmp);
                    response.sendRedirect("/user/list");
                }
            }
        }else{
            response.getWriter().append("User name, user email or user password was given incorrectly");
        }
    }
}
