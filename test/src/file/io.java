package file;

import org.junit.Test;
import package1.person;

import java.io.*;

public class io {
    @Test
    public void method() throws IOException {
        File file = new File("hello.txt");
        FileReader reader = new FileReader(file);
        int read = reader.read();
        while(read!=-1){
            System.out.println("read = " + (char)read);
            read = reader.read();
        }
        reader.close();
    }
    @Test
    public void method2() throws IOException {
        File file = new File("hello.txt");
        FileReader reader = new FileReader(file);
        int read;
        while ((read = reader.read())!= -1){
            System.out.println("read = " + (char)read);
        }
        reader.close();
    }
    @Test
    public void method3() throws IOException {
        File file = new File("hello.txt");
        FileReader reader = new FileReader(file);
       char [] chars = new char[3];
        int read1 = reader.read(chars);
        while (read1!=-1){
            for (int i = 0 ; i <read1 ; i++){
                System.out.println("i = " + chars[i]);
            }
            read1 =  reader.read(chars);
        }
        reader.close();
    }
    @Test
    public void method4() throws IOException {
        File file = new File("hello.txt");
        FileReader reader = new FileReader(file);
        char [] chars = new char[4];
        int length ;
        while ((length=reader.read(chars))!= -1){
            for (int i = 0 ; i<length ; i++){
                System.out.println("i = " + chars[i]);
            }
        }
        reader.close();
    }
    @Test
    public void method5() throws IOException {
        File file = new File("hello.txt");
        FileReader reader = new FileReader(file);
        char [] chars = new char[4];
        int length ;
        while ((length=reader.read(chars))!= -1){
          String string = new String(chars,0,length);
            System.out.println("string = " + string);
        }
        reader.close();
    }
    @Test
    public void method6() throws IOException {
    File file = new File("hello.txt");
        FileWriter writer = new FileWriter( file,true);
        writer.write("123456");
        writer.close();


    }
    @Test
    public void method7() {
        File file = new File("hello.txt");
        File file1 = new File("hello3.txt");
        FileReader reader = null;
        FileWriter writer = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
             reader = new FileReader(file);
             writer = new FileWriter(file1);
             bufferedReader = new BufferedReader(reader);
             bufferedWriter = new BufferedWriter(writer);
             String string = "";
             while ((string = bufferedReader.readLine())!=null){
                 bufferedWriter.write(string);
                 bufferedWriter.newLine();
             }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void method8() throws IOException {
        File file = new File("test.jpg");
        File file1 = new File("test1.jpg");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);

        int length ;
        byte [] bytes = new byte[5];
        while ((length = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        inputStream.close();
        outputStream.close();

    }
    @Test
    public void method9() throws IOException {
        File file = new File("test.jpg");
        File file1 = new File("test2.jpg");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);

         BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int length ;
        byte [] bytes = new byte[5];
        while ((length = bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,length);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
    @Test
    public void method10() throws IOException {
        File file = new File("hello.txt");
        File file1 = new File("hello6.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file1);
        InputStreamReader reader = new InputStreamReader(inputStream,"utf-8");
        OutputStreamWriter writer = new OutputStreamWriter(outputStream,"gbk");
        int length ;

        char[] chars = new char[20];

        while ((length = reader.read(chars))!=-1){
            String string = new String(chars,0,length);
            writer.write(string);
            System.out.println("string = " + string);
        }
        reader.close();
        writer.close();
    }
    @Test
    public void method11() throws IOException {
        File file = new File("hello.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);
        PrintStream printStream = new PrintStream(fileOutputStream);
        System.setOut(printStream);
        for (int i = 0 ; i<50 ; i++){
            System.out.print((char)i);
        }
    }
    @Test
    public void method12() throws IOException {
        File file = new File("hello.txt");
        FileOutputStream outputStream = new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.write(123);
        dataOutputStream.writeUTF("kk");
        dataOutputStream.writeBoolean(true);
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int i =dataInputStream.read();
        String string = dataInputStream.readUTF();
        boolean b = dataInputStream.readBoolean();
        System.out.println("i = " + i);
        System.out.println(string);
        System.out.println(b);
    }
    @Test
    public void method13() throws IOException, ClassNotFoundException {
        File file1 = new File("he.dat");
        FileOutputStream outputStream = new FileOutputStream(file1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new String("123"));
        objectOutputStream.flush();
        objectOutputStream.writeObject(new person("小刘", 18));
        objectOutputStream.flush();
        objectOutputStream.close();
        FileInputStream inputStream = new FileInputStream(file1);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object= objectInputStream.readObject();
        String string = (String)object;
        System.out.println("string = " + string);
        Object object1 = objectInputStream.readObject();
        person person = (package1.person) object1;
        System.out.println("object1 = " + object1);
    }
    @Test
    public void method14() throws IOException {
    File file1 = new File("hello.txt");
    File file2 = new File("hell.txt");
    RandomAccessFile accessFile = new RandomAccessFile(file1, "rw");
    RandomAccessFile accessFile1 = new RandomAccessFile(file2,"rw");
    int length ;
    byte [] bytes = new byte[5];
    while ((length = accessFile.read(bytes))!=-1){
        accessFile1.write(bytes,0,length);
    }
    accessFile.close();
    accessFile1.close();
    }
    @Test
    public void method15() throws IOException {
        File file1 = new File("hello.txt");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file1, "rw");
        int length ;
        StringBuffer buffer = new StringBuffer((int) file1.length());
        byte [] bytes = new byte[10];
        randomAccessFile.seek(3);
        while ((length = randomAccessFile.read(bytes))!=-1){
            buffer.append(new String(bytes,0,length));
        }
        randomAccessFile.seek(3);
        randomAccessFile.write("xcv".getBytes());
        randomAccessFile.write(buffer.toString().getBytes());
    }
}
class atest1{
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader reader1 = new BufferedReader(reader);
        while (true){
            System.out.println("请输入");
            String string = reader1.readLine();
            if (string.equalsIgnoreCase("e")||string.equalsIgnoreCase("exit")){
                System.out.println("退出成功");
                return;
            }
            System.out.println(string.toUpperCase());
        }
    }
}
