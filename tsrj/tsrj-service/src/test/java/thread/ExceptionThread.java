package thread;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/11
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        System.out.println("threadExceptionHandler:" + Thread.currentThread().getUncaughtExceptionHandler()
                + "ExceptionThread run do");
        throw new RuntimeException();
    }
}
