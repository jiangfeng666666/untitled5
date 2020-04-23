package package1;

import java.util.concurrent.locks.ReentrantLock;

public class java3 {
    public static void main(String[] args) {
//        mythread mythread = new mythread();
//        mythread mythread2 = new mythread();
//        mythread mythread3= new mythread();
//        mythread.start();
//        mythread2.start();
//        mythread3.start();
        runabale runabale = new runabale();
        Thread thread = new Thread(runabale);
        Thread thread1 = new Thread(runabale);
        Thread thread2 = new Thread(runabale);
        thread.setName("线程1");
        thread1.setName("线程2");
        thread2.setName("线程3");
        thread.start();
        thread.setPriority(6);
        thread1.start();
        thread2.start();
    }
}
class runabale1 implements Runnable {
    int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println("票数为" + ticket + Thread.currentThread().getName() + "  " + Thread.currentThread().getPriority());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                lock.unlock();
                break;
            }
        }
    }
}