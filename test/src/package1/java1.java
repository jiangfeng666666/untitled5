package package1;
public class java1 {
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
        thread1.start();
        thread2.start();
    }
}
class mythread extends  Thread{
    static int ticket = 100 ;
    @Override
    public void run() {
        while (ticket>=0) {
            System.out.println("票数为：" + ticket + Thread.currentThread().getName());
            ticket--;
        }
    }
}
class runabale implements Runnable{
    int ticket = 100 ;
    @Override
    public void run() {
        while (ticket > 0) {
            method1();
        }
    }
    public synchronized void method1(){
        if (ticket>0) {
            System.out.println("票数为" + ticket + Thread.currentThread().getName()+"  "+Thread.currentThread().getPriority());
            ticket--;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
             }
        }
      }
    }

