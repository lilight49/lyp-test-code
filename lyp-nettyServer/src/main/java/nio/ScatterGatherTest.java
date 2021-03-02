package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @methodName
 * @description scatter 数据的写入使用buffer数据,依次写入到多个buffer
 * gather 读取数据可以将buffer的数组,依次读写
 * @author liyunpeng
 * @date 2021/3/1 10:27
**/
public class ScatterGatherTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(9000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = serverSocketChannel.accept();
        int msgSize = 8;

        while (true){
            int byteRead = 0;

            while (byteRead < msgSize){
                long read = socketChannel.read(byteBuffers);
                byteRead += read;

                Arrays.asList(byteBuffers).stream().map(byteBuffer-> "position===="+ byteBuffer.position()+"=============limit========"+byteBuffer.limit()).forEach(System.out::println);
            }

            //将所有的buffer翻转
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());

            int byteWrite = 0;
            while (byteWrite < msgSize){
                long write = socketChannel.write(byteBuffers);//回显到客户端
                byteWrite += write;

            }

            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());//复位

            System.out.println("byteRead=========="+byteRead+"=============byteWrite=============="+byteWrite);
        }
    }
}
