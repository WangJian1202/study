package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(5);// 创建一个固定大小为5的线程池
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyThread());
        }
        pool.shutdown();
    }
}
