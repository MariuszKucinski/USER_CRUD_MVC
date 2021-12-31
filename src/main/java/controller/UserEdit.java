package controller;

import dao.UserDao;
import entity.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            session.setAttribute("userId", id);
            UserDao userDao = new UserDao();
            User tmp = userDao.readUser(id);
            request.setAttribute("user",tmp);
            request.getRequestDispatcher("/users/edit.jsp").forward(request, response);
        }else{
            response.getWriter().append(printUserId());
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("name")!=null) {
            String userName = request.getParameter("name");
            if(request.getParameter("email")!=null&&request.getParameter("email").matches("[a-zA-Z0-9-_]+(\\.?[a-zA-Z0-9-_])*@[a-zA-z0-9-_]+\\.[a-zA-Z]{2,8}")){
                String userEmail = request.getParameter("email");
                if(request.getParameter("password")!=null&&request.getParameter("password").matches("[\\S]{8,}")){
                    String userPassword = request.getParameter("password");
                    HttpSession session = request.getSession();
                    int id = Integer.valueOf(String.valueOf(session.getAttribute("userId")));
                    User tmp = new User(id,userName,userEmail, BCrypt.hashpw(userPassword, BCrypt.gensalt()));
                    UserDao userDao = new UserDao();
                    userDao.updateUser(tmp);
                    response.sendRedirect("/user/list");
                }
            }
        }else{
            response.getWriter().append("User name, user email or user password was given incorrectly");
        }


    }

    private String printUserId() {
        return "<form action=\"/user/edit\" method=\"get\" class=\"m-auto\" style=\"max-width:600px\">\n" +
                "\t\t<h3 class=\"my-4\">User Edit Form</h3>\n" +
                "\t\t<hr class=\"my-4\" />\n" +
                "\t\t<div class=\"form-group mb-3 row\"><label for=\"user-id2\" class=\"col-md-5 col-form-label\">User Id</label>\n" +
                "\t\t\t<div class=\"col-md-7\"><input type=\"number\" class=\"form-control form-control-lg\" id=\"user-id2\" name=\"id\" required></div>\n" +
                "\t\t</div>\n" +
                "\t\t<hr class=\"bg-transparent border-0 py-1\" />\n" +
                "\t\t<hr class=\"my-4\" />\n" +
                "\t\t<div class=\"form-group mb-3 row\"><label for=\"edit-chosen-user5\" class=\"col-md-5 col-form-label\"></label>\n" +
                "\t\t\t<div class=\"col-md-7\"><button class=\"btn btn-primary btn-lg\" type=\"submit\">Edit Chosen User</button></div>\n" +
                "\t\t</div>\n" +
                "\t</form>";
    }
}
