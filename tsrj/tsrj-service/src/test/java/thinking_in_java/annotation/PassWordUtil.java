package thinking_in_java.annotation;

public class PassWordUtil {
    @UserCase(id = 1, description = "this is one desc")
    public void oneMethod(String password){
        System.out.println("this is first method");
    }

    @UserCase(id = 2, description = "this is two desc")
    public void twoMethod(String password){
        System.out.println("this is second method");
    }

    @UserCase(id = 3, description = "this is three desc")
    public void threeMethod(String password){
        System.out.println("this is third method");
    }
}
