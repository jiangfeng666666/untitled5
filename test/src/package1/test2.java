package package1;

public class test2 {
    public static void main(String[] args) {

    }
}
class bank{
    private static bank bank = null;
    private bank(){

    }
    public static bank getinstean(){
        if (bank == null) {
            synchronized (bank.class) {
                if (bank == null) {
                    bank = new bank();
                }
            }
        }
        return bank;
    }
}


