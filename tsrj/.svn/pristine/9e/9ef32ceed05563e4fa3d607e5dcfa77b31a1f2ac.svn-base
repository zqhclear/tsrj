import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA{
        public void println(String s){
            System.out.println(s);
        }
    }
    public static void main(String[] args) throws Throwable{
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        System.out.println(obj.getClass().getCanonicalName());
        //无论obj最后为那个实现类，都能够调用到println()方法
        getPrintlnMH(obj).invokeExact("i am method");
    }
    public static MethodHandle getPrintlnMH(Object obj) throws Throwable{
        //MethodType:代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和具体的参数（methodType()的的后续参数）
        MethodType methodType = MethodType.methodType(void.class, String.class);
        //lookup()方法来自于MethodHandles.lookup，这句的作用是在制定类中查找符合给定的方法的名称，方法类型，并且调动权限的方法权柄
        //因为这里调用的是一个虚方法，按照java的语言的规则，方法的第一个参数是隐式的，代表方法的接受者，也即使this指向的对象，这个参数
        //以前是放在参数列表中进行传递的，现在提供了bingTo()方法来完成这件事情
        return lookup().findVirtual(obj.getClass(), "println", methodType).bindTo(obj);
    }
}
