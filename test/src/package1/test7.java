package package1;

import java.util.concurrent.*;

public class test7 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) service;
        service.execute(new atest7());
        service.execute(new btest7());
        service.shutdown();

    }
}
class atest7 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"i = " + i);
        }
    }
}
class btest7 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"i = " + i);
        }
    }
}
class ctest7 implements Callable{

    @Override
    public Object call() throws Exception {
        return 1;
    }
}