package intent;

import org.junit.Test;

import java.io.*;
import java.net.*;

public class intent1 {
    @Test
    public void method() throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(address,8899);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，123".getBytes());
        outputStream.close();
        socket.close();
    }
    @Test
    public void method2() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[5];
        int length ;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((length = inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,length);
        }
        System.out.println("outputStream = " + outputStream.toString());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
    @Test
    public void method3() throws IOException {
        InetAddress address = InetAddress.getByName("127.0.0.1");
        Socket socke = new Socket(address,8899);
        OutputStream stream = socke.getOutputStream();
        stream.write("小小阿斯蒂芬斯蒂芬多".getBytes());
        socke.shutdownOutput();
        InputStream stream1 = socke.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream1);
        char[] chars = new char[5];
        int length ;
        while ((length = reader.read(chars))!=-1){
            String string = new String(chars,0,length);
            System.out.println("string = " + string);
        }

        stream.close();
        socke.close();
        reader.close();
    }
    @Test
    public void method4() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream stream = socket.getInputStream();
        int length ;
        char [] chars = new char[5];
        InputStreamReader reader = new InputStreamReader(stream);
        while ((length = reader.read(chars))!=-1){
            String string = new String(chars,0 ,length);
            System.out.println("string = " + string);
        }
        OutputStream stream1= socket.getOutputStream();
        stream1.write("花港饭店嘎达科技发货".getBytes());
        stream1.close();
        reader.close();
        stream.close();
        socket.close();
        serverSocket.close();
    }
    @Test
    public void method5() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String string = "我是小小鸟";
        byte [] bytes = string.getBytes();
        InetAddress address = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes, 0,bytes.length,address,9090);
        socket.send(packet);
    }
    @Test
    public void method6() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);
        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        socket.receive(packet);
        String string = new String(packet.getData(),0,packet.getLength());
        System.out.println("string = " + string);
    }
    @Test
    public void method7() throws IOException {
        URL url = new URL("https://p0.ssl.qhimgs1.com/sdr/400__/t013e317e7970bd4f70.jpg");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("heee.jpg");
        int length ;
        byte[] bytes = new byte[1024];
        while ((length = inputStream.read(bytes))!=-1){
            outputStream.write(bytes, 0, length);
        }
        outputStream.close();
        inputStream.close();
        connection.disconnect();
    }

}

