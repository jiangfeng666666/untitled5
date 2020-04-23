package package1;

public class test8 {
    public static void main(String[] args) {
        test8 test8 = new test8();
        try {
            test8.method();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void method() throws Exception {
        int i = 0 ;
        int i2 = 10 ;
        throw new Exception("我的异常");
    }
}
