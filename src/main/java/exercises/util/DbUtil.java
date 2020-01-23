package exercises.util;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author xunmi
 * @ClassName DbUtil
 * @Description JDBC工具类
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class DbUtil {
    /**
     * 读取和处理资源文件的信息
     * properties --> n. 性能；道具，内容
     */
    static Properties pros;

    // 只需要加载一次，所以写成静态代码，执行本类时加载
    static {
        pros = new Properties();
        try {
            pros.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的连接
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            conn = DriverManager.getConnection(pros.getProperty("mysqlUrl"), pros.getProperty("mysqlUser"), pros.getProperty("mysqlPassword"));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pst) {
        try {
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(Connection conn) {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAutoCommit(Connection conn, boolean autoCommit) {
        if (conn != null) {
            try {
                conn.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (DbUtil.getConn() != null) {
            System.out.println("连接成功");
        }
    }
}
