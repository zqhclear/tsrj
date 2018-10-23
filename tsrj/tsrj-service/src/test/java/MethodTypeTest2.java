import java.lang.reflect.Method;

public class MethodTypeTest2 {
    class GrantFather{
        void sayThing(){
            System.out.println("i am grantFather");
        }
    }
    class Father extends GrantFather{
        void sayThing(){
            System.out.println("i am Father");
        }
    }
    class Son extends Father{
        void sayThing(){
            //1：创建grantfather对象
//            GrantFather f = new GrantFather();
//            f.sayThing();

            //2：反射-->无法实现？
            try{
                Class cl = GrantFather.class;
                Method method = cl.getDeclaredMethod("sayThing", null);
                if(method != null){
                    Object obj = method.invoke(new GrantFather(), null);
                }
            }catch (NoSuchMethodException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }


            //3：methodhandles,返回值为void，没有参数
            //有bug？
//            try {
//                MethodType methodType = MethodType.methodType(void.class);
//                //获取权限
////                Field IMPL_LOOKUP = lookup().getClass().getDeclaredField("IMPL_LOOKUP");
////                IMPL_LOOKUP.setAccessible(true);
////                MethodHandle methodHandle =((MethodHandles.Lookup) IMPL_LOOKUP.get(null)).findSpecial(GrantFather.class, "sayThing", methodType, GrantFather.class);
//                MethodHandle methodHandle = lookup().findSpecial(GrantFather.class, "sayThing", methodType, GrantFather.class);
//                methodHandle.invoke(this);
//            } catch (Throwable e) {
//                e.printStackTrace();
//            }
//            //正确例子
//            try{
//                MethodType methodType = MethodType.methodType(void.class);
//                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
//                IMPL_LOOKUP.setAccessible(true);
//                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
//                MethodHandle methodHandle = lkp.findSpecial(GrantFather.class, "sayThing", methodType, GrantFather.class);
//                methodHandle.invoke(this);
//            }catch(Throwable e){
//                e.printStackTrace();
//            }

        }
    }
    public static void main(String[] args){
        new MethodTypeTest2().new Son().sayThing();
    }
}
