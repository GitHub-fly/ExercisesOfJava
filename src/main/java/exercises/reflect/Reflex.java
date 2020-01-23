package exercises.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xunmi
 * @ClassName Reflex
 * @Description 使用反射机制调用类的某个方法
 * @Date 2020/1/19
 * @Version 1.0
 **/
public class Reflex {

    /**
     *     通过反射机制调用Student类中的setName()方法，参数传递为“张三”
     * 再通过该机制调用getName()方法，将返回值与“张三”进行比较
     */
    public static void reflex() {
        Class<?> reflex = null;
        try {
            reflex = Class.forName("exercises.IO.Student");
            assert reflex != null;
            // 取得setName()方法
            Method setName = reflex.getMethod("setName", String.class);
            // 取得getName()方法
            Method getName = reflex.getMethod("getName");
            // 利用反射机制调用以上方法
            setName.invoke(reflex.getDeclaredConstructor().newInstance(), "张三");
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
