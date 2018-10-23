package thread;

import java.util.concurrent.Callable;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/10
 */
public class ThreadByCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("this is thread for callable");
        return "return message";
    }
}
