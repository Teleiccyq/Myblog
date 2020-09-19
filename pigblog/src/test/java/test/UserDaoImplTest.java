package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.jupiter.api.Test;
import pojo.User;


public class UserDaoImplTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void searchUserByUsername() {
        if (userDao.searchUserByUsername("123")==null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在！！！");
        }
    }

    @Test
    public void searchUserByNameandPas() {
        if (userDao.searchUserByNameandPas("admin", "admin") == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null, "123123", "123123", "123123@qq.com")));
    }
}