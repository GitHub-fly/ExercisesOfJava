package exercises.reflect;

import exercises.util.DbUtil;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xunmi
 * @ClassName BaseDao
 * @Description ����ͷ��ͷ�װ��JDBC����������
 * @Date 2020/1/23
 * @Version 1.0
 **/
public class BaseDao<T> {

    private Class<?> clazz;

    public BaseDao() {
        clazz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * SQL ��ѯ����ѯ���ֱ�ӷ���ResultSet��
     * @param sql SQL���
     * @param params �������飬��û�в�����Ϊnull
     * @return �����
     */
    private ResultSet executeQuery(String sql, Object[] params) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            // �������
            Connection conn = DbUtil.getConn();
            // ����SQL
            pst = conn.prepareStatement(sql);
            // ������ֵ
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public List<T> resultSetToList(ResultSet rs) {
        List<T> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Object object = null;
                try {
                    object = clazz.getDeclaredConstructor().newInstance();
                    for (Method m : clazz.getMethods()) {
                        String methodName = m.getName();
                        // set����
                        if (methodName.startsWith("set")) {
                            // ��ȡ�ֶ���
                            String filedName = methodName.substring(3);
                            // ��ȡ���ݲ�ͨ�����丳ֵ
                            m.invoke(object, rs.getObject(filedName));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                list.add((T) object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<T> selectAll(String sql, Object[] params) {
        ResultSet resultSet = executeQuery(sql, params);
        return resultSetToList(resultSet);
    }
}
