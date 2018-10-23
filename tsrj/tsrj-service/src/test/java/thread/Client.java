package thread;

import org.tsrj.common.page.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/10
 * 必须要调用start()方法才算是创了了另外一个线程，因为需要创建线程是需要和系统打交道
 * start方法中有native方法，通知系统创建一个线程供自己使用。
 * 如果直接调用run方法的话，是无法创建一个线程使用的，只是相当于一个普通的方法，还是需要等到run方法中的逻辑都
 * 执行完成之后才能往下执行，没有多线程的意义
 */
public class Client {

    public static void main(String[] args){
        ThreadByRunnable runnable = new ThreadByRunnable();
        Thread threadByRunnable = new Thread(runnable);
        threadByRunnable.start();
        System.out.println("r:" + threadByRunnable.getPriority());

        ThreadByCallable threadByCallable = new ThreadByCallable();
        try{
            String returnMsg = threadByCallable.call();
            System.out.println(returnMsg);
        }catch(Exception e){
            e.printStackTrace();
        }

        Thread thread = new ThreadByThread();
        System.out.println(thread.getPriority());
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类 implements runnable");
            }
        }).start();

        new Thread() {
            public void run() {
                System.out.println("内部类 extends Thread");
            }

        }.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            futureList.add(executorService.submit(new ThreadByCallable()));
        }
        for(Future future : futureList){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }



    }
}
