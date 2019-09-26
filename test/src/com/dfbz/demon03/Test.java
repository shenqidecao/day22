package com.dfbz.demon03;

import javax.xml.crypto.Data;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        String format=df.format(new Date());
        FileReader fr = new FileReader("D:\\test\\a.txt");
        FileWriter fw = new FileWriter("D:\\test2\\"+format+".txt");
        int len;
        char[] c = new char[1024];
        while ((len=fr.read(c))!=-1){
            fw.write(new String(c,0,len));
        }
        fw.flush();
        fw.close();
        fr.close();
    }
}
