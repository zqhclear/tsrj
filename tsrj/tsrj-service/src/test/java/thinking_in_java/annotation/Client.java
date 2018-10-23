package thinking_in_java.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Integer> userCases = new ArrayList();
        Collections.addAll(userCases, 1, 2, 3, 4);
        taskUserCase(userCases, PassWordUtil.class);
    }

    public static void taskUserCase(List<Integer> userCases, Class<?> cl){
        for(Method method : cl.getDeclaredMethods()){
            UserCase uc = method.getAnnotation(UserCase.class);
            if(uc != null){
                System.out.println("加了注释,id:"+ uc.id() +",desc:"+uc.description());
                userCases.remove(new Integer(uc.id()));
            }
        }
        System.out.print("未加注释,id：");
        for(int i : userCases){
            System.out.print(i+" ");
        }
    }

}
