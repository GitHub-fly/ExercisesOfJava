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
 * @Description ����dao��
 * ��ɻ�����ɾ�Ĳ鹦�ܷ�װ
 * @Date 2020/2/1
 * @Version 1.0
 **/
public class BaseDao {

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    private static Connection conn = DbUtil.getConn();
    private static PreparedStatement pstmt = null;
    private static ResultSet res = null;

    /**
     * ִ�����ݿ��Ĳ���
     *
     * @param sql   ���ݿ����
     * @param param ��̬��ѯ����
     * @return �����ResultSet
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
            logger.error("��ȡPreparedStatement��������쳣");
        }
        try {
            res = pstmt.executeQuery();
        } catch (SQLException e) {
            logger.error("��ȡResultSet��������쳣");
        }
        return res;
    }

    /**
     * ִ������ɾ���ĵĲ���
     *
     * @param sql   ���ݿ����
     * @param param ��̬��ѯ����
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
            logger.error("��ȡPreparedStatement��������쳣");
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("ִ��execute��������");
        }
    }
}
