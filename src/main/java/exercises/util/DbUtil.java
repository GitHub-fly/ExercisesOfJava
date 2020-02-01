package exercises.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author xunmi
 * @ClassName DbUtil
 * @Description JDBC������
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class DbUtil {

    private static Logger logger = LoggerFactory.getLogger(DbUtil.class);

    /**
     * ��ȡ�ʹ�����Դ�ļ�����Ϣ
     * properties --> n. ���ܣ����ߣ�����
     */
    static Properties pros;

    // ֻ��Ҫ����һ�Σ�����д�ɾ�̬���룬ִ�б���ʱ����
    static {
        pros = new Properties();
        try {
            pros.load(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties")));
            Class.forName(pros.getProperty("mysqlDriver"));
        } catch (ClassNotFoundException e) {
            logger.error("���ݿ�����δ�ҵ�");
        } catch (IOException e) {
            logger.error("���ݿ������ļ���д����");
        }
    }

    /**
     * ��ȡ���ݿ������
     *
     * @return  �������Ӷ���Connection
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                    pros.getProperty("mysqlUrl"),
                    pros.getProperty("mysqlUser"),
                    pros.getProperty("mysqlPassword"));
            assert conn != null;
            logger.info(conn.toString());
        } catch (SQLException e) {
            logger.error("���ݿ�����ʧ��");
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

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection);
        close(statement);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection);
        close(statement);
        close(resultSet);
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
            System.out.println("���ӳɹ�");
        }
    }
}
