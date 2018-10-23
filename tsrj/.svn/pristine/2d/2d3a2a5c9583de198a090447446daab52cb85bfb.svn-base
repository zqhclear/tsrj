package thread;

/**
 * @Author: qh-zhong
 * @Date: 2018/5/11
 */
public class JoinMethodForThreadTest {

    public static void main(String[] args) throws Exception{
        JoinMethodForThreadTest test = new JoinMethodForThreadTest();
        Sleeper sleeperOne = test.new Sleeper("sleepOne", 1000);
        Sleeper sleeperTwo = test.new Sleeper("sleepTwo", 1000);

        Joiner joinerOne = test.new Joiner("joinerOne", sleeperOne);
        Joiner joinerTwo = test.new Joiner("joinerTwo", sleeperTwo);
        //通知线程现在可以中断了
        sleeperTwo.interrupt();

    }



    class Sleeper extends Thread{
        private int duration;
        public Sleeper(String threadName, int sleepTime){
            super(threadName);
            this.duration = sleepTime;
            start();
        }

        public void run(){
            try{
                sleep(duration);
            }catch (InterruptedException e){
                System.out.println(getName() + " was interrupted. interrupted():" + isInterrupted());
            }
            System.out.println(getName() + " was awakened");
        }
    }

    class Joiner extends Thread{
        private Sleeper sleeper;
        public Joiner(String threadName, Sleeper sleeper){
            super(threadName);
            this.sleeper = sleeper;
            start();
        }
        public void run(){
            try{
                sleeper.join();
            }catch (InterruptedException e){
                System.out.println(getName() + " interruptedException");
            }
            System.out.println(getName() + "join completed");
        }

    }
}
