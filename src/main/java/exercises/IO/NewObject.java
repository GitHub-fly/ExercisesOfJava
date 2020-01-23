package exercises.IO;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xunmi
 * @ClassName NewObject
 * @Description 至少用四种方法创建Student类的对象
 * @Date 2020/1/18
 * @Version 1.0
 **/
public class NewObject {

    /**
     * 1. 通过使用new关键字创建Student类的实例
     * @return Student类对象
     */
    public static Student getObjectByNew() {
        Student student = new Student();
        student.setName("我通过new关键字创建对象");
        return student;
    }

    /**
     * 2. 使用Class类的newInstance方法，这个newInstance方法调用无参的构造器创建对象
     * 该方法已被弃用，可能会抛出实例化异常(InstantiationException)和非法使用异常(IllegalAccessException)
     * @return 返回Student类实例
     */
    public static Student getObjectByClass() {
        Student student = null;
        try {
            student = Student.class.newInstance();
            student.setName("我通过Class类的newInstance方法创建对象");
            return student;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 3. 通过对象clone的方法创建Student类的实例
     * 可能会抛出不支持克隆异常(CloneNotSupportedException)
     * 要求： 被实例化的类实现Cloneable接口
     * @return Student类的实例
     */
    public static Student getObjectByClone() {
        Student student = new Student();
        student.setName("我通过clone方法创建对象");
        try {
            return (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 4. 通过Constructor类里面的newInstance方法创建对象
     * 可能会抛出方法不匹配异常(NoSuchMethodException)
     *          实例化异常(InstantiationException)
     *          非法使用异常(IllegalAccessException)
     *          读取目标文件异常(InvocationTargetException)
     * @return Student类的实例
     */
    public static Student getObjectByConstructor() {
        Constructor<Student> constructor = null;
        Student student = null;
        try {
            constructor = Student.class.getConstructor();
            student = constructor.newInstance();
            student.setName("我通过Constructor类里的newInstance方法创建对象");
            return student;
        } catch (NoSuchMethodException e) {
            System.out.println("getConstructor()方法出现错误");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("newInstance()方法出现错误");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("newInstance()方法出现错误");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("newInstance()方法出现错误");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 5. 通过反序列化获取Student类的实例
     * 调用前面我们写过的序列化和反序列化方法
     * @return Student类的实例
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
