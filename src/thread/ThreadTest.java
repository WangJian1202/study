package thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    @Test
    public void test01() {

        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);

    }

    @Test
    public void test02() {

        //返回Java虚拟机试图使用的最大内存量。
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回Java虚拟机中的内存总量。
        Long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("MAX_MEMORY =" + maxMemory + "(字节)、" + (maxMemory / (double) 1024 / 1024) + "MB");
        System.out.println("TOTAL_ MEMORY = " + totalMemory + "(字节)" + (totalMemory / (double) 1024 / 1024) + "MB");

    }
    @Test
    public void test03(){

        //返回Java虚拟机试图使用的最大内存量。
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回Java虚拟机中的内存总量。
        Long totalMemory = Runtime. getRuntime().totalMemory();
        System.out.println("MAX_MEMORY ="+maxMemory +"(字节)、"+(maxMemory/(double)1024/1024) + "MB");
        System.out.println("TOTAL_ MEMORY = "+totalMemory +"(字节)"+(totalMemory/(double)1024/1024) + "MB");
        String str = "www.baidu.com";
        while(true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(99999999);
        }
    }


    @Test
    public void test04(){

    }




}
