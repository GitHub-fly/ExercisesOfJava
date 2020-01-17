package exercises;

import java.io.*;

/**
 * @author xunmi
 * @ClassName Student
 * @Description TODO
 * @Date 2020/1/15
 * @Version 1.0
 **/
public class Student implements Serializable {

    private String name;
    private String gender;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 序列化
     * @throws IOException
     */
    private static void serializeStudent() throws IOException {
        Student student = new Student();
        student.setName("JSON");
        student.setAge(16);
        student.setGender("男");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("E:/studentTest.txt")));
        oos.writeObject(student);
        oos.flush();
        oos.close();
    }

    /**
     * 反序列化
     * @return 返回反序列化后的对象信息
     * @throws Exception
     */
    private static Student deserializeStudent() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("E:/studentTest.txt")));
        Student student = (Student) ois.readObject();
        return student;
    }

    public static void main(String[] args) throws Exception {
        serializeStudent();
        Student student = deserializeStudent();
        System.out.println(student);
    }
}