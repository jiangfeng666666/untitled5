package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class test1 {
    @Test
    public void menthod(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\Users");
        System.out.println("file1 = " + file1);
        System.out.println("file1 = " + file2);
        File file3 = new File("D:\\Users","hello");
        System.out.println("file1 = " + file3);
        File file = new File(file3,"hi.txt");
        System.out.println("file1 = " + file);
    }
    @Test
    public void menthod2(){
        File file = new File("hello.txt");
        System.out.println("file = " + file);
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));

    }
    @Test
    public void method(){
        File file = new File("d:\\");
        String[] liset = file.list();
        for (String s : liset){
            System.out.println(s);
        }
    }
    @Test
    public void method3(){
        File file = new File("d:\\AMD");
        File [] files = file.listFiles();
        for (File s : files){
            System.out.println(s);
        }
    }
    @Test
    public void method4(){
        File file = new File("hello.txt");
        File file1 = new File("d:\\hi.txt");
        boolean b = file1.renameTo(file);
        System.out.println("b = " + b);
    }
    @Test
    public void method5(){
        File file = new File("hello.txt");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println();
        File file1 = new File("d:\\AMD");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }
    @Test
    public void method6() throws IOException {
        File file = new File("hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }else{
            file.delete();
            System.out.println("删除成功");
        }
        File file1  = new File("D:\\io\\io");
        file1.delete();

    }
    @Test
    public void method7(){
File file = new File("d:\\id\\id");
        boolean mkdir = file.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }

    }
    @Test
    public void method8() throws IOException {
        File file = new File("d:\\hello.txt");
        file.createNewFile();
        File file1 = new File(file.getParent(),"hi.txt");
        file1.createNewFile();
        file.delete();
        file1.delete();
    }

}

