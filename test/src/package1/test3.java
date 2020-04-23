package package1;

import java.util.concurrent.locks.ReentrantLock;

public class test3 {
    public static void main(String[] args) {
        count count = new count(0);
        customer customer1 = new customer(count);
        customer customer2 = new customer(count);
        customer1.setName("甲");
        customer2.setName("已");
        customer1.start();
        customer2.start();
    }
}
class count{
private double bance = 0;
private ReentrantLock lock = new ReentrantLock();
    public count(double bance) {
            this.bance = bance;
        }
    public void method(double atm){
        lock.lock();
        if (atm>0) {
            bance += atm;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功,余额为" + bance);
        }
        lock.unlock();
    }
}
class customer extends Thread{
  private count count;
    public customer(count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            count.method(1000);
        }
    }
}