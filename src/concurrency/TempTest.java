package concurrency;

public class TempTest {

    private void test1(A a) {

        System.out.println("0:"+a);
        a.age = 20;
        A a1=new A();
        a1.age=30;
        a=a1;
        System.out.println("1:"+a);
        System.out.println("test1方法中的age=" + a.age);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        A a = new A();
        System.out.println("main:0"+a);
        a.age = 10;
        t.test1(a);
        System.out.println("main:1"+a);
        System.out.println("main方法中的age =" + a.age);
    }
}

class A {
    public int age = 0;
} 
