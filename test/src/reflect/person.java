package reflect;

public class person {
    public String name = "" ;
    private int age = 1;
    public int id ;
    public person() {
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public String show(String string , int i){
        System.out.println("hello");
        return string;
    }
    public static void me(){
        System.out.println("你好");
    }
}
