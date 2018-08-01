package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
	public static void main(String[] args) {  
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(6);
        for(int i=0;i<10000;i++){  
            pool.submit(new MyThread());  
        }  
          
        pool.schedule(new MyThread(), 1000, TimeUnit.MILLISECONDS);
        pool.schedule(new MyThread(), 1000, TimeUnit.MILLISECONDS);  
        pool.shutdown();  
    }  
}
