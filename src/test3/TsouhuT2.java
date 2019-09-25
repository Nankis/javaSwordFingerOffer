package test3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource {
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    int flag = 0;

    public void printNum() {
        lock.lock();
        try {
            while (flag != 0) {
                c1.await();
            }
            for (int i = 1; i <= 52; i++) {
                System.out.print(i);
                if (i % 2 == 0) {
                    flag = 1;
                    c1.await();
                    c2.signal();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printAZ() {
        lock.lock();
        try {
            while (flag != 1) {
                c2.await();
            }
            for (int i = 0; i <= 25; i++) { //65--90
                System.out.print((char) ('A' + i) + " ");
                flag = 0;
                c1.signal();
                c2.await();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class TsouhuT2 {
    public static void main(String[] args) {
        //1-52   A-Z
        Resource resource = new Resource();
        new Thread(() -> {
            resource.printNum();
        }).start();
        new Thread(() -> {
            resource.printAZ();
        }).start();
    }
}
