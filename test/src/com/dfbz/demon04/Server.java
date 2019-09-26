package com.dfbz.demon04;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        System.out.println("服务端等待连接");
        ServerSocket ss=new ServerSocket(8888);
        while (true){
            Socket server=ss.accept();
            System.out.println("连接成功");
            InputStream is=server.getInputStream();
            byte[] b=new byte[1024];
            int len=is.read(b);
            String msg=new String(b,0,len);
            System.out.println("服务端收到客服端发送的消息："+msg);
            is.close();
            ss.close();
        }
    }
}
