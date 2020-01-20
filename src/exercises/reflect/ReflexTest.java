package exercises.reflect;

import jdk.jshell.MethodSnippet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xunmi
 * @ClassName ReflexTest
 * @Description 使用Java反射获取类名，方法名，属性及构造方法
 * @Date 2020/1/20
 * @Version 1.0
 * java中修饰符编号：
 *      PUBLIC(public): 1       PRIVATE(private): 2     PROTECTED(protected): 4     STATIC(static): 8
 *      FINAL(final): 16        SYNCHRONIZED(synchronized): 64
 *      TRANSIENT(transient)(短暂类型，不会被序列化所看重): 128
 *      NATIVE(native)(修饰方法，被修饰方法的实现由非Java语言实现，该方法无方法体，类似于接口): 256
 *      INTERFACE(interface): 512   ABSTRACT(abstract): 1024
 *      STRICT(strict)(修饰类和方法，意思是FP-strict, 精确浮点。当一个class或interface用strictfp声明，内部所有的float和double
 *  表达式都会变成strictfp类型。注意：接口中的方法不能被声明为strictfp，普通类中的方法可以): 2048
 **/
public class ReflexTest {

    public static void testReflex() {
        try {
            Class clazz = Class.forName("exercises.IO.Student");
            System.out.println("-----获取类名-----");
            System.out.println("直接打印clazz对象：\t" + clazz.toString());
            System.out.println("通过调用getSimpleName()方法获取类名：\t" + clazz.getSimpleName());


            /**
             * getDeclaredConstructors() 和 getConstructors()的区别
             *      getDeclaredConstructors(Class<?>...parameterTypes):
             *          这个方法会返回指定参数类型的所有构造器，包括public的和非public的，当然也包括private的
             *      getDeclaredConstructors():
             *          这个无参数的方法的返回结果就没有参数类型的过滤了
             *
             *      getConstructor(Class<?>...parameterTypes):
             *          这个方法返回的是上面那个方法返回结果的子集，只返回指定参数类型访问权限是public的构造器
             *      getConstructors():
             *          这个方法的返回结果同样也没有参数类型的过滤
             *
             */
            System.out.println("\n-----获取类中声明的构造方法-----");
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor con : constructors) {
                System.out.print("方法名：" + con.getName());
                // 方法修饰符
                System.out.println(", 修饰符类型：" + con.getModifiers());
            }
            System.out.println("-----获取所有构造方法-----");
            Constructor[] constructorsAll = clazz.getConstructors();
            for (Constructor constructor : constructorsAll) {
                System.out.print("方法名：" + constructor.getName() + "--");
                System.out.println(", 修饰符类型：" + constructor.getModifiers());
            }


            System.out.println("\n-----获取类中定义的方法-----");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("方法名：" + method.getName());
                System.out.println(", 修饰符类型：" + method.getModifiers());
            }
            System.out.println("-----获取该类所有的方法-----");
            Method[] methodsAll = clazz.getMethods();
            for (Method method : methodsAll) {
                System.out.print("方法名：" + method.getName());
                System.out.println(", 修饰符类型：" + method.getModifiers());
            }


            System.out.println("\n-----获取所有的属性-----");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.print("属性名：" + field.getName());
                System.out.println(", 修饰符类型：" + field.getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testReflex();
    }
}
