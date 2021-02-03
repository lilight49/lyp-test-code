package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @methodName
 * @description BIO - 同步并阻塞队列
 * @author liyunpeng
 * @date 2021/1/27 14:16
 * @return: null
**/
public class BioService {

    public static void main(String[] args) throws IOException {

        //thread pool new
        ExecutorService executorService = Executors.newCachedThreadPool();

        //run socket server
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("serverSocket===========run");

        while (true){
            final Socket socket = serverSocket.accept();//启用socekt连接
            System.out.println("client connect start");

            executorService.execute(new Runnable() {//启用线程处理socket客户端传递的数据
                public void run() {
                    System.out.println("thread run"+Thread.currentThread().getId()+"============"+Thread.currentThread().getName());

                    handlerSocket(socket);
                }
            });
        }


    }

    /**
     * @methodName handlerSocket
     * @description 处理socket的信息
     * @param socket:
     * @author liyunpeng
     * @date 2021/1/27 14:29
     * @return: void
    **/
    public static void handlerSocket(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();//获取socket的数据

            while (true){
                int read = inputStream.read(bytes);
                System.out.println(read);

                if(read != -1) {//未读取完成
                    System.out.println("thread run"+Thread.currentThread().getId()+"============"+Thread.currentThread().getName());
                    System.out.println(new String(bytes, 0, read));
                }else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("socket connect close");
                socket.close();//socket关闭
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
