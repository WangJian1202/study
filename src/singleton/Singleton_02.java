package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 饿汉式:静态代码块
 *
 */
public class Singleton_02 {

    private static Singleton_02 INSTANCE;

    static{
        INSTANCE =new Singleton_02();
    }

    private Singleton_02() {
    }

    public  Singleton_02 getINSTANCE() {
        return INSTANCE;
    }
}
