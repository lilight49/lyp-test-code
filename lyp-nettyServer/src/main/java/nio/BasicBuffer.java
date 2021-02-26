package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.util.Arrays;
import java.util.List;

public class BasicBuffer {

    public static void main(String[] args) {
//        intBufferTest();

    }

    /**
     * @methodName intBufferTest
     * @description buffer的基本操作
     * @author liyunpeng
     * @date 2021/2/26 14:57
     * @return: void
    **/
    private static void intBufferTest() {
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
