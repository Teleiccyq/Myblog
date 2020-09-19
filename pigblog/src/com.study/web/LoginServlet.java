package web;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User  userLogin = userService.login(new User(null,username,password,null));
        if (userLogin == null){
            System.out.println("用户名或密码错误");
            req.getRequestDispatcher("/pages/login/login.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/regist/regist_success.html").forward(req,resp);
        }
    }
}
