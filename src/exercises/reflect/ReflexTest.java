package exercises.reflect;

import jdk.jshell.MethodSnippet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xunmi
 * @ClassName ReflexTest
 * @Description ʹ��Java�����ȡ�����������������Լ����췽��
 * @Date 2020/1/20
 * @Version 1.0
 * java�����η���ţ�
 *      PUBLIC(public): 1       PRIVATE(private): 2     PROTECTED(protected): 4     STATIC(static): 8
 *      FINAL(final): 16        SYNCHRONIZED(synchronized): 64
 *      TRANSIENT(transient)(�������ͣ����ᱻ���л�������): 128
 *      NATIVE(native)(���η����������η�����ʵ���ɷ�Java����ʵ�֣��÷����޷����壬�����ڽӿ�): 256
 *      INTERFACE(interface): 512   ABSTRACT(abstract): 1024
 *      STRICT(strict)(������ͷ�������˼��FP-strict, ��ȷ���㡣��һ��class��interface��strictfp�������ڲ����е�float��double
 *  ���ʽ������strictfp���͡�ע�⣺�ӿ��еķ������ܱ�����Ϊstrictfp����ͨ���еķ�������): 2048
 **/
public class ReflexTest {

    public static void testReflex() {
        try {
            Class clazz = Class.forName("exercises.IO.Student");
            System.out.println("-----��ȡ����-----");
            System.out.println("ֱ�Ӵ�ӡclazz����\t" + clazz.toString());
            System.out.println("ͨ������getSimpleName()������ȡ������\t" + clazz.getSimpleName());


            /**
             * getDeclaredConstructors() �� getConstructors()������
             *      getDeclaredConstructors(Class<?>...parameterTypes):
             *          ��������᷵��ָ���������͵����й�����������public�ĺͷ�public�ģ���ȻҲ����private��
             *      getDeclaredConstructors():
             *          ����޲����ķ����ķ��ؽ����û�в������͵Ĺ�����
             *
             *      getConstructor(Class<?>...parameterTypes):
             *          ����������ص��������Ǹ��������ؽ�����Ӽ���ֻ����ָ���������ͷ���Ȩ����public�Ĺ�����
             *      getConstructors():
             *          ��������ķ��ؽ��ͬ��Ҳû�в������͵Ĺ���
             *
             */
            System.out.println("\n-----��ȡ���������Ĺ��췽��-----");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor con : constructors) {
                System.out.print("��������" + con.getName());
                // �������η�
                System.out.println(", ���η����ͣ�" + con.getModifiers());
            }
            System.out.println("-----��ȡ���й��췽��-----");
            Constructor[] constructorsAll = clazz.getConstructors();
            for (Constructor constructor : constructorsAll) {
                System.out.print("��������" + constructor.getName() + "--");
                System.out.println(", ���η����ͣ�" + constructor.getModifiers());
            }


            System.out.println("\n-----��ȡ���ж���ķ���-----");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("��������" + method.getName());
                System.out.println(", ���η����ͣ�" + method.getModifiers());
            }
            System.out.println("-----��ȡ�������еķ���-----");
            Method[] methodsAll = clazz.getMethods();
            for (Method method : methodsAll) {
                System.out.print("��������" + method.getName());
                System.out.println(", ���η����ͣ�" + method.getModifiers());
            }


            System.out.println("\n-----��ȡ���е�����-----");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.print("��������" + field.getName());
                System.out.println(", ���η����ͣ�" + field.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testReflex();
    }
}
