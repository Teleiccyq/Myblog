package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 执行Insert/Update/Delete 语句
     *
     * @param sql  执行的sql语句
     * @param args 参数
     * @return 如果返回-1，说明执行失败。返回其他说明执行成功
     */
    public int update(String sql, Object ... args) {
        Connection con = jdbcUtils.getConnection();

        try {
            return queryRunner.update(con, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(con);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return 返回null说明执行失败
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection con = jdbcUtils.getConnection();

        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(con);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection con = jdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(con);
        }
        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql  执行的sql语句
     * @param agrs sql的对应参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object ... agrs) {
        Connection con = jdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new ScalarHandler(), agrs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtils.Close(con);
        }
        return null;
    }
}
