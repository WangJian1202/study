package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 懒汉(线程不安全)
 * 达到懒加载的效果
 */
public class Singleton_03 {
    private static Singleton_03 INSTANCE;

    private Singleton_03() {
    }

    public static Singleton_03 getINSTANCE(){
        if(INSTANCE==null){
            return new Singleton_03();
        }
        return INSTANCE;
    }
}
