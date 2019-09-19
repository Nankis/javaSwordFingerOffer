package baseJava;

public class IntergerTest {
    public static void main(String[] args) {
        //两个都是通过new的 永远都不相等 --->地址不同
        Integer n1 = new Integer(123); //和缓存[-128,127] 无关
        Integer n2 = new Integer(123);
        System.out.println(n1 == n2); //false

        //只要是与int比较的,那么不管是new的还是直接赋值的,永远都相等,因为解包装
        Integer a1 = new Integer(128);
        int a2 = 128;
        System.out.println(a1 == a2);//true  和缓存无关

        //如果Integer是直接赋值的,在缓存内就相等 (唯一与缓存有关的)
        Integer c1 = 128;
        Integer c2 = 128;
        System.out.println(c1 == c2); //true

        Integer d1 = 127;
        Integer d2 = new Integer(127);
        System.out.println(d1 == d2);//false
        System.out.println(d1.hashCode() == d2.hashCode());

    }
}
