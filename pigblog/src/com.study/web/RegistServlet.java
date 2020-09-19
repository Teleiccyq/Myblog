package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (userService.checkUsername(username) == true){
            userService.registUser(new User(null,username,password,email));
            req.getRequestDispatcher("/pages/regist/regist_success.html").forward(req,resp);
        }else {
            System.out.println("用户名已存在");
            req.getRequestDispatcher("/pages/regist/regist.html").forward(req,resp);
        }

    }
}
