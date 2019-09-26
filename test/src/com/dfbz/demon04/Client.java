package com.dfbz.demon04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("开启客户端,请输入");
        while (true){
            Socket client=new Socket("127.0.0.1",8888);
            OutputStream os=client.getOutputStream();
            os.write(s.nextLine().getBytes());
        }
    }
}
