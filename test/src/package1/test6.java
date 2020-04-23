package package1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class test6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        atest atest = new atest();
        FutureTask futureTask = new FutureTask(atest);
        new Thread(futureTask).start();
        Object object = futureTask.get();
        System.out.println("object = " + object);
    }
}
class atest implements Callable{
    int sum = 0 ;
    @Override
    public Object call() throws Exception {
        for (int i = 0; i <=100 ; i++) {

                sum+=i;

        }
        return sum;
    }
}
