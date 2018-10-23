import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    interface IHello{
        void sayHello();
    }

    static class HelloImpl implements IHello{
        @Override
        public void sayHello() {
            System.out.println("say hello");
        }
    }
    //反射（proxy）实现
    static class DynamicProxy implements InvocationHandler {
        Object obj;
        Object bind(Object obj){
            this.obj =obj;
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("world");
            return method.invoke(obj, null);
        }
    }

    //MethodHandle实现
    void sayHelloMethodHandle(){
        try {
                MethodType methodType = MethodType.methodType(void.class);
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandle methodHandle = ((MethodHandles.Lookup) IMPL_LOOKUP.get(null)).findSpecial(HelloImpl.class, "sayHello", methodType, HelloImpl.class);
                System.out.println("world");
                methodHandle.invoke(new HelloImpl());
            } catch (Throwable e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args){
        //methodhandle 方式
        new DynamicProxyTest().sayHelloMethodHandle();
        //反射方式
        IHello hello = (IHello)new DynamicProxy().bind(new HelloImpl());
        hello.sayHello();
        System.getProperties().put("sun.misc.ProxyGenetator.saveGeneratedFiles", "true");
    }
}
