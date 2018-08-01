package concurrency;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo  {

        private static  List list1=new ArrayList();
        private static  List list=new ArrayList();
        private static int count;



        public static void main(String[]args) {
            for(int i=0;i<200;i++){
                list1.add(i);
            }
            Demo demo = new Demo();
            Object lock = new Object();
            //消费线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        while (list1.size() != 0) {
                            count++;
                            System.out.println("couont:"+count);
                            try {
                                lock.wait();
                                Iterator iterator = list.iterator();
                                while (iterator.hasNext()) {
                                    Object o=iterator.next();
                                    System.out.println("写入这个元素" + o);
                                    iterator.remove();
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            lock.notify();
                        }
                        System.out.println("线程二结束");
                    }
                }
            }).start();

            //生产线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lock) {
                        System.out.println("线程一执行");
                        while (list1.size() != 0) {
                            try {
                                Iterator iterator = list1.iterator();
                                while (iterator.hasNext()) {
                                    Object o=iterator.next();
                                    iterator.remove();
                                    list.add(o);
                                    if (list.size() == 20) {
                                        lock.notify();
                                        lock.wait();
                                        System.out.println("线程一等待，线程二执行");
                                    }
                                }

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                        System.out.println("线程一结束");
                    }
                }
            }).start();
        }
}
