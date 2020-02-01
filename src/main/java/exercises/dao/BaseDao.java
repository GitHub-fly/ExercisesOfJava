package exercises.dao;


import exercises.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xunmi
 * @ClassName BaseDao
 * @Description 基础dao类
 * 完成基本增删改查功能封装
 * @Date 2020/2/1
 * @Version 1.0
 **/
public class BaseDao {

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    private static Connection conn = DbUtil.getConn();
    private static PreparedStatement pstmt = null;
    private static ResultSet res = null;

    /**
     * 执行数据库查的操作
     *
     * @param sql   数据库语句
     * @param param 动态查询参数
     * @return 结果集ResultSet
     */
    public static ResultSet executeQuery(String sql, Object[] param) {
        try {
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
        } catch (SQLException e) {
            logger.error("获取PreparedStatement对象出现异常");
        }
        try {
            res = pstmt.executeQuery();
        } catch (SQLException e) {
            logger.error("获取ResultSet对象出现异常");
        }
        return res;
    }

    /**
     * 执行增、删、改的操作
     *
     * @param sql   数据库语句
     * @param param 动态查询参数
     */
    public static void executeUpdate(String sql, Object[] param) {
        try {
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
        } catch (SQLException e) {
            logger.error("获取PreparedStatement对象出现异常");
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("执行execute方法出错");
        }
    }
}
