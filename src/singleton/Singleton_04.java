package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 饿汉（同步方法）
 * 线程安全
 */
public class Singleton_04 {

    private static Singleton_04 INSTANCE;

    private  Singleton_04() {
    }

    public static synchronized Singleton_04 getINSTANCE() {
        if(INSTANCE==null){
            return new Singleton_04();
        }
        return INSTANCE;
    }
}
