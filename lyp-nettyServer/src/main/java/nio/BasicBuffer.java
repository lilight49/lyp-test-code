package nio;

import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;

public class BasicBuffer {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int index = 0; index < intBuffer.capacity()-1; index++) {
            intBuffer.put(index*2);

            System.out.println(intBuffer.mark());
        }

        intBuffer.flip();//读写翻转

        System.out.println(intBuffer.mark());

        while (intBuffer.hasRemaining()) {
            System.out.println("out======="+intBuffer.mark());
            System.out.println("result one=="+intBuffer.get());
        }
    }
}
