package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一个闭锁确保在所有线程开始执行任务前，所有的准备工作都已完成，一旦准备工作完成就调用startLatch.countDown()打开闭锁，所有线程开始执行
 * 第二个闭锁确保所有任务执行完成之后主线程才能继续进行，这样主线程等待所有任务线程执行完之后才能得到结果。
 * 在第二个闭锁当中，初始化一个N计数器，没执行完一次任务-1，所有任务结束后计数器归零，这样主线程闭锁overLatch拿到信号后继续往下执行。
 */
public class PerformanceTestTool {

    private static volatile int count = 0;

    public long timecost(final int times, final Runnable
            task) throws InterruptedException {
        if (times <= 0) throw new
                IllegalArgumentException();
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);

        for (int i = 0; i < times; i++) {

            System.out.println("准备工作"+i);
            new Thread(new Runnable() {

                public void run() {
                    try {
                        startLatch.await();
                        System.out.println("线程开始任务...");
//
                        task.run();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } finally {
                        overLatch.countDown();
                    }
                }
            }).start();
        }
//
        long start = System.nanoTime();
        System.out.println("准备工作完成");
        startLatch.countDown();
        overLatch.await();
        System.out.println("任务执行完毕");
        return System.nanoTime() - start;
    }

    public static void main(String[] args) throws InterruptedException {
        PerformanceTestTool pf=new PerformanceTestTool();
        Object o = new Object();
        long timecost = pf.timecost(100, () -> {
            System.out.println("执行任务");
        });
        System.out.println(timecost);


    }


}
