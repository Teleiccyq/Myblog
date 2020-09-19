package dao;

import pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return 如果返回null说明没有该用户
     */
    public User searchUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return 如果返回null说明没有该用户
     */
    public User searchUserByNameandPas(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(User user);
}
