package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 饿汉
 * 同步代码块
 */
public class Singleton_05 {

    private static Singleton_05 INSTANCE;

    private Singleton_05() {
    }

    public static Singleton_05 getINSTANCE() {
        if(INSTANCE==null){
           synchronized (Singleton_05.class){
               INSTANCE=new Singleton_05();
           }
        }
        return INSTANCE;
    }
}
