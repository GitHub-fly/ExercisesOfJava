package exercises.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xunmi
 * @ClassName Reflex
 * @Description ʹ�÷�����Ƶ������ĳ������
 * @Date 2020/1/19
 * @Version 1.0
 **/
public class Reflex {

    /**
     *     ͨ��������Ƶ���Student���е�setName()��������������Ϊ��������
     * ��ͨ���û��Ƶ���getName()������������ֵ�롰���������бȽ�
     */
    public static void reflex() {
        Class<?> reflex = null;
        try {
            reflex = Class.forName("exercises.IO.Student");
            assert reflex != null;
            // ȡ��setName()����
            Method setName = reflex.getMethod("setName", String.class);
            // ȡ��getName()����
            Method getName = reflex.getMethod("getName");
            // ���÷�����Ƶ������Ϸ���
            setName.invoke(reflex.getDeclaredConstructor().newInstance(), "����");
            getName.invoke(reflex.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflex();
    }
}
