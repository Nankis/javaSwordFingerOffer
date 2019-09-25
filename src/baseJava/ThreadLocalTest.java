package baseJava;

//统计每个线程执行的次数

class TLDemo {
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNext() {
        Integer val = count.get();
        val++;
        count.set(val);
        return val;
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        TLDemo tl = new TLDemo();
        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName()+" " + tl.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() +" "+ tl.getNext());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() +" "+ tl.getNext());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
