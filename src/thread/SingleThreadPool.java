package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
	public static void main(String[] args) {
        //创建一个单线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            pool.submit(new MyThread());
        }
        pool.shutdown();
    }
    }
