package netty.nio;

import java.nio.IntBuffer;

public class SimpleBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < 5; i++) {
            intBuffer.put(i);
        }
        intBuffer.put(0, 1);  //0,limit
        intBuffer.flip();
//        intBuffer.position(1); // 0,limit
//        intBuffer.limit(4); // 0,cap

        while (intBuffer.hasRemaining()){
            //get()函数不会阻塞，而BIO中read()函数会阻塞
            System.out.println(intBuffer.get() + "  " + intBuffer.get(4));  // 0,limit

        }
//        System.out.println(intBuffer.position());
//        System.out.println(intBuffer.capacity());
//        System.out.println(intBuffer.limit());
    }
}
