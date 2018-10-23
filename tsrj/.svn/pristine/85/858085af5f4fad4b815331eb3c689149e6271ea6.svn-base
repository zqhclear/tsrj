public class MethodOverLoadTest {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}
    public void sayHello(Human human){
        System.out.println("helle guy");
    }
    public void sayHello(Man man){
        System.out.println("hello man");
    }
    public void sayHello(Woman woman){
        System.out.println("hello woman");
    }
    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        MethodOverLoadTest  methodOverLoadTest = new MethodOverLoadTest();
        methodOverLoadTest.sayHello(man);
        methodOverLoadTest.sayHello(woman);
    }
}
