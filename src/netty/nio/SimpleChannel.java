package netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class SimpleChannel {

    public static void main(String[] args) throws Exception {

//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\hello.txt");
//
//        FileChannel channel = fileOutputStream.getChannel();
//
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//
//        String str  = "Hello, Netty";
//
//        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
//
//        byteBuffer.flip();
//
//        channel.write(byteBuffer);
//
//        fileOutputStream.close();

        File file = new File("D:\\hello.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        channel.read(byteBuffer);

//        System.out.println(byteBuffer.position());
//
//        System.out.println(new String(byteBuffer.array()));

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()){
            System.out.println((char)byteBuffer.get());
        }
    }
}
