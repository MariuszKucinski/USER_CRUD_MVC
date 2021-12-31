package controller;

import dao.UserDao;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id")!=null) {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            request.getRequestDispatcher("/users/delete.jsp").forward(request,response);
        }else{
            response.getWriter().append(printUserId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getParameter("delete").equals("yes")){
                UserDao userDao = new UserDao();
                HttpSession session = request.getSession();
                userDao.deleteUser(Integer.valueOf(String.valueOf(session.getAttribute("id"))));
            }
            response.sendRedirect("/user/list");
    }

    private String printUserId() {
        return "<form action=\"/user/delete\" method=\"get\" class=\"m-auto\" style=\"max-width:600px\">\n" +
                "\t\t<h3 class=\"my-4\">User Delete Form</h3>\n" +
                "\t\t<hr class=\"my-4\" />\n" +
                "\t\t<div class=\"form-group mb-3 row\"><label for=\"user-id2\" class=\"col-md-5 col-form-label\">User Id</label>\n" +
                "\t\t\t<div class=\"col-md-7\"><input type=\"number\" class=\"form-control form-control-lg\" id=\"user-id2\" name=\"id\" required></div>\n" +
                "\t\t</div>\n" +
                "\t\t<hr class=\"bg-transparent border-0 py-1\" />\n" +
                "\t\t<hr class=\"my-4\" />\n" +
                "\t\t<div class=\"form-group mb-3 row\"><label for=\"edit-chosen-user5\" class=\"col-md-5 col-form-label\"></label>\n" +
                "\t\t\t<div class=\"col-md-7\"><button class=\"btn btn-primary btn-lg\" type=\"submit\">Delete Chosen User</button></div>\n" +
                "\t\t</div>\n" +
                "\t</form>";
    }
}
