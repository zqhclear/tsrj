package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/11
 */
public class ThreadUncaughExceptionHandlerTest {


    class ExceptionThread implements Runnable{
        @Override
        public void run() {
            System.out.println("threadExceptionHandler:" + Thread.currentThread().getUncaughtExceptionHandler()
                    + "ExceptionThread run do");
            throw new RuntimeException();
        }
    }

    class MyCaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("threadName" + t.getName() + "was Exception:" + e);
        }
    }

    class HandlerThreadFactory implements ThreadFactory{
        @Override
        public Thread newThread(Runnable r) {
            System.out.println("threadFactory is construct");
            Thread thread = new Thread(r);
            System.out.println("threadName:"+thread.getName());
            thread.setUncaughtExceptionHandler(new MyCaughtExceptionHandler());
            return thread;
        }
    }

    public static void main(String[] args){
        ThreadUncaughExceptionHandlerTest test = new ThreadUncaughExceptionHandlerTest();
        ExecutorService executorService = Executors.newCachedThreadPool(test.new HandlerThreadFactory());
        executorService.execute(test.new ExceptionThread());

        Executors.newScheduledThreadPool()

    }


}
