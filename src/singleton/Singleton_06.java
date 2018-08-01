package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 双重检查
 */
public class Singleton_06 {

    private static Singleton_06 INSTANCE;

    private Singleton_06() {
    }

    public static Singleton_06 getINSTANCE() {
        if(INSTANCE==null){
            synchronized (Singleton_06.class){
                if(INSTANCE==null){
                INSTANCE=new Singleton_06();
                }
            }
        }
        return INSTANCE;
    }
}
