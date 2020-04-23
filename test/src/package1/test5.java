package package1;

public class test5 {
    public static void main(String[] args) {
    clerk clerk = new clerk();
    producter producter = new producter(clerk);
    custom custom = new custom(clerk);
    producter.start();
    custom.start();
    }
}
class clerk{
    private int sum = 0;
    public synchronized void product() throws InterruptedException {
        while(true) {
            if (sum < 20) {
                sum++;
                System.out.println("现在是生产商品" + sum + "  " + Thread.currentThread().getName());
                notify();
            }else{
                wait();
            }
        }
    }
    public synchronized void consume() throws InterruptedException {
        while (true) {
            if (sum > 0) {
                sum--;
                System.out.println("现在是消费商品" + sum + "  " + Thread.currentThread().getName());
                notify();
            }else{
                wait();
            }
        }
    }
}
class producter extends Thread{
    private clerk clerk ;

    public producter(clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            clerk.product();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class custom extends Thread{
    private clerk clerk;

    public custom(clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        try {
            clerk.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
