package exercises.IO;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xunmi
 * @ClassName NewObject
 * @Description ���������ַ�������Student��Ķ���
 * @Date 2020/1/18
 * @Version 1.0
 **/
public class NewObject {

    /**
     * 1. ͨ��ʹ��new�ؼ��ִ���Student���ʵ��
     * @return Student�����
     */
    public static Student getObjectByNew() {
        Student student = new Student();
        student.setName("��ͨ��new�ؼ��ִ�������");
        return student;
    }

    /**
     * 2. ʹ��Class���newInstance���������newInstance���������޲εĹ�������������
     * �÷����ѱ����ã����ܻ��׳�ʵ�����쳣(InstantiationException)�ͷǷ�ʹ���쳣(IllegalAccessException)
     * @return ����Student��ʵ��
     */
    public static Student getObjectByClass() {
        Student student = null;
        try {
            student = Student.class.newInstance();
            student.setName("��ͨ��Class���newInstance������������");
            return student;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 3. ͨ������clone�ķ�������Student���ʵ��
     * ���ܻ��׳���֧�ֿ�¡�쳣(CloneNotSupportedException)
     * Ҫ�� ��ʵ��������ʵ��Cloneable�ӿ�
     * @return Student���ʵ��
     */
    public static Student getObjectByClone() {
        Student student = new Student();
        student.setName("��ͨ��clone������������");
        try {
            return (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 4. ͨ��Constructor�������newInstance������������
     * ���ܻ��׳�������ƥ���쳣(NoSuchMethodException)
     *          ʵ�����쳣(InstantiationException)
     *          �Ƿ�ʹ���쳣(IllegalAccessException)
     *          ��ȡĿ���ļ��쳣(InvocationTargetException)
     * @return Student���ʵ��
     */
    public static Student getObjectByConstructor() {
        Constructor<Student> constructor = null;
        Student student = null;
        try {
            constructor = Student.class.getConstructor();
            student = constructor.newInstance();
            student.setName("��ͨ��Constructor�����newInstance������������");
            return student;
        } catch (NoSuchMethodException e) {
            System.out.println("getConstructor()�������ִ���");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("newInstance()�������ִ���");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("newInstance()�������ִ���");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("newInstance()�������ִ���");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 5. ͨ�������л���ȡStudent���ʵ��
     * ����ǰ������д�������л��ͷ����л�����
     * @return Student���ʵ��
     */
    public static Student getObjectByDeserialization() {
        try {
            Student.serializeStudent();
            return Student.deserializeStudent();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Student s1 = getObjectByNew();
        System.out.println(s1.getName());

        Student s2 = getObjectByClass();
        System.out.println(s2.getName());

        Student s3 = getObjectByClone();
        System.out.println(s3.getName());

        Student s4 = getObjectByConstructor();
        System.out.println(s4.getName());

        Student s5 = getObjectByDeserialization();
        System.out.println(s5.getName());
    }
}
