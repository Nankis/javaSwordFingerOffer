package baseJava;

import java.io.IOException;

public class san7huyu {
    public static void main(String[] args) {
        try(MyResource1 r1 = new MyResource1();
            MyResource2 r2 = new MyResource2();) {
            System.out.println("T");
        } catch (Exception e) {
            System.out.println("IOE");
        } finally {
            System.out.println("F");
        }

    }

}

class MyResource1 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("1");
    }
}

class MyResource2 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        throw new IOException();
    }
}

