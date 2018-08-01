public class Main {

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        Thread.sleep(1000);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
}
