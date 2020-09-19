package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "123123", "123123", "123123@qq.com"));
    }

    @Test
    public void login() {
        if (userService.login(new User(null, "test01", "test01", null)) == null) {
            System.out.println("登录失败，用户名或错误");
        } else {
            System.out.println("登录成功，登录用户为：");
            System.out.println(userService.login(new User(null, "test01", "test01", null)));
        }
    }

    @Test
    public void checkUsername() {
        if (userService.checkUsername("123")) {
            System.out.println("用户名可用");
            System.out.println(userService.checkUsername("123"));
        } else {
            System.out.println("用户名已存在!!!");
            System.out.println(userService.checkUsername("123"));
        }
    }
}