package thread;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在执行...");
    }
}
