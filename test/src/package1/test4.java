package package1;

public class test4 {
    public static void main(String[] args) {
        th th = new th();
       Thread thread1 = new Thread(th);
       Thread thread2 = new Thread(th);
       thread1.start();
       thread2.start();
    }
}
class th implements Runnable{
    int num = 100;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if (num > 0) {
                    num--;
                    System.out.println(Thread.currentThread().getName() + "数字为" + num);
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
