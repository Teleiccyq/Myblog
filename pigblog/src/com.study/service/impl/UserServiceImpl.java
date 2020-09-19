package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.searchUserByNameandPas(user.getUsername(),user.getPassword());
    }

    /**
     * 检查用户名是否可用
     * @param username
     * @return      true表示用户名可用，false表示用户名已存在
     */
    @Override
    public boolean checkUsername(String username) {
        if (userDao.searchUserByUsername(username) == null){
            return true;
        }
        return false;
    }
}
