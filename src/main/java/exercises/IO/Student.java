package exercises.IO;

import java.io.*;

/**
 * @author xunmi
 * @ClassName Student
 * @Description TODO
 * @Date 2020/1/15
 * @Version 1.0
 **/
public class Student implements Serializable, Cloneable {

    private String name;
    private String gender;
    private int age;

    public String getName() {
        System.out.println("Student���е�getName()����������");
        return name;
    }

    public void setName(String name) {
        System.out.println("Student���е�name���Ա���ֵΪ��" + name);
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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
     * ���л�
     * @throws IOException
     */
    public static void serializeStudent() throws IOException {
        Student student = new Student();
        student.setName("��Ҫʵ�����л��ͷ����л�");
        student.setAge(16);
        student.setGender("��");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("E:/studentTest.txt")));
        oos.writeObject(student);
        oos.flush();
        oos.close();
    }

    /**
     * �����л�
     * @return ���ط����л���Ķ�����Ϣ
     * @throws Exception
     */
    public static Student deserializeStudent() throws IOException, ClassNotFoundException {
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
