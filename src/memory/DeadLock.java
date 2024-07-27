package memory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: This class provides the tryLock method which attempts to acquire the lock within
 * the specified time. If the lock is not available within that time, it returns false, thus
 * avoiding deadlocks. 
 * 
 * tryLock: Using tryLock with a timeout allows threads to attempt to acquire
 * locks and back off if they can't get the lock, preventing deadlocks. 
 * 
 * Exception Handling:
 * Interrupted exceptions are caught and handled, ensuring the threads can be properly interrupted
 * if necessary.
 */
public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public void task1() {
        synchronized (lock1) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println("Task 1 acquired both locks");
            }
        }
    }

    public void task2() {
        synchronized (lock2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock1) {
                System.out.println("Task 2 acquired both locks");
            }
        }
    }

    public void taskA() {
        try {
            try {
                if (lockA.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        if (lockB.tryLock()) {
                            System.out.println("Task A acquired both locks");
                        }
                    } finally {
                        lockB.unlock();
                    }
                }

            } finally {
                lockA.unlock();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void taskB() {
        try {
            try {
                if (lockB.tryLock(100, TimeUnit.MILLISECONDS)) {
                    try {
                        if (lockA.tryLock()) {
                            System.out.println("Task B acquired both locks");
                        }
                    } finally {
                        lockA.unlock();
                    }
                }
            } finally {
                lockB.unlock();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        // Thread thread1 = new Thread(deadLock::task1);
        // Thread thread2 = new Thread(deadLock::task2);
        // thread1.start();
        // thread2.start();
        Thread threadA = new Thread(deadLock::taskA);
        Thread threadB = new Thread(deadLock::taskB);
        threadA.start();
        threadB.start();
    }
}
