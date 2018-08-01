package singleton;

/**
 * @author WangJian on 2018/7/11.
 * @version 1.0
 * 静态内部类(占位符)
 */
public class Singleton_07 {

    private Singleton_07() {
    }

    private static class SingleInstance{
        private static final Singleton_07 INSTANCE = new Singleton_07();
    }

    public static Singleton_07 getINSTANCE(){
        return SingleInstance.INSTANCE;
    }
}
