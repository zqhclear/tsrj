import java.io.Serializable;

public class MethodOverLoadTestTwo {
    public static void sayHello(Object o){
        System.out.println("this is Object");
    }
    public static void sayHello(int... i){
        System.out.println("this is int");
    }
    public static void sayHello(long l){
        System.out.println("this is long");
    }
    public static void sayHello(Character character){
        System.out.println("this is Character");
    }
//    public static void sayHello(char ch){
//        System.out.println("this is char");
//    }
    public static void sayHello(char... chars){
        System.out.println("this is char[]");
    }
    public static void sayHello(Serializable serializable){
        System.out.println("this is Serializable");
    }

    public static void main(String[] args){
        sayHello('a');
    }

}
