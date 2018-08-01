package concurrency;




public class ThreadCreationCmp {


    public static void main(String[] args) {
        Thread t;
        CountingTask ct =new CountingTask();
        final int numberOfProceesors =Runtime.getRuntime().availableProcessors();
        for (int i = 0; i <2*numberOfProceesors ; i++) {
            t=new Thread(ct);
            t.start();
        }

        for (int i = 0; i <2*numberOfProceesors ; i++) {
            t=new CountingThread();
            t.start();
        }
    }
//========================================================================
    static  class Counter{
        private int count=0;
        public void increament(){
            count++;
        }
        public int value(){
            return count;
        }
    }

//============================================================================
        static class CountingTask implements Runnable{
            private Counter counter=new Counter();
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    dosomething();
                    counter.increament();
                }
                System.out.println("CountingTask:"+counter.value());
            }

            private void dosomething() {
                //使当前线程休眠随机时间
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        static class CountingThread extends  Thread {

            private Counter counter = new Counter();

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    dosomething();
                    counter.increament();
                }
                System.out.println("CountingThread:" + counter.value());

            }

            private void dosomething() {
                //使当前线程休眠随机时间
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }

}
