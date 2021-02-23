package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {

        FileOut();//文件输出

//        FileIn();//文件读取
//
//        FileCopy();//文件从读取到写入
//
//        FileCopy2();//复制目标通道的数据到指定通道
    }

    /**
     * @methodName FileCopy2
     * @description
     * @author liyunpeng
     * @date 2021/2/23 13:50
     * @return: void
    **/
    private static void FileCopy2() throws IOException{
        File file = new File("D:\\java_test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\java_test_copy.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        //将inputStreamChannel目标通道的数据复制到outputStreamChannel当前通道
//        outputStreamChannel.transferFrom(inputStreamChannel, 0, inputStreamChannel.size());

        //将inputStreamChannel当前通道的数据复制到outputStreamChannel目标通道
        inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel);

        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * @methodName FileCopy
     * @description 文件拷贝
     * @author liyunpeng
     * @date 2021/2/23 11:17
     * @return: void
    **/
    private static void FileCopy() throws IOException{
        File file = new File("D:\\java_test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\java_test_copy.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        while (true){
            byteBuffer.clear();

            int read = inputStreamChannel.read(byteBuffer);

            if(read == -1){//-1代表结束
                break;
            }

            byteBuffer.flip();

            outputStreamChannel.write(byteBuffer);

        }

        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * @methodName FileIn
     * @description 文件输入
     * @author liyunpeng
     * @date 2021/2/23 11:04
     * @return: void
    **/
    private static void FileIn() throws IOException{
        File file = new File("D:\\java_test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        int read =  fileChannel.read(byteBuffer);

        byteBuffer.flip();

        System.out.println(new String(byteBuffer.array(),0,read));

        fileInputStream.close();
    }

    /**
     * @methodName FileOut
     * @description 文件输出
     * @author liyunpeng
     * @date 2021/2/23 11:04
     * @return: void
    **/
    private static void FileOut() throws IOException {
        String test = "hello test \n \t hello lyp";

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\java_test.txt");

        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(test.getBytes());

        byteBuffer.flip();

        fileChannel.write(byteBuffer);

        fileOutputStream.close();
    }
}
