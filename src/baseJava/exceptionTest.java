package baseJava;

public class exceptionTest {
    public static void main(String[] args) {
        System.out.println(test());


    }

    public static int test() {
        int n = 0;
        try {
            if (true) {
                throw new Exception();
            }
            System.out.println("a");
            n = 1;
            return n;
        } catch (Exception e) {
            n = 2;
            System.out.println("b");
        } finally {
            n = 3;
            System.out.println("c");
        }
        System.out.println("d");
        return n;
    }
}


