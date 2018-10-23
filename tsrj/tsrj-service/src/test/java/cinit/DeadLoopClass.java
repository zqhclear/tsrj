package cinit;

public class DeadLoopClass {
    static{
        if(true) {
            System.out.println(Thread.currentThread() + "init DeadLeapClass");
            while (true) {
            }
        }
    }

}
