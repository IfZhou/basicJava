package com.basicJava.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by zhouyifu on 2017/3/30.
 */

@Service
public class JavaIOService implements  ICommonService {
    @Override
    public Map<String, Object> excuteTest() {
//        testInputAndOutputStream();
//        testReaderAndWriterStream();
        try {
            testNioChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 流 都以File为例
     */
    void  testInputAndOutputStream(){
        File f= new File("D:"+File.separator+"test.txt");
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(f,true);  //追加内容
            String content ="我是由OutputStream写入!";
            fileOutputStream.write(content.getBytes());
            fileOutputStream.close();  //即使不关闭连接也会有输出内容,当然，正确的做法应该关闭

            FileInputStream fileInputStream = new FileInputStream(f);
            byte[] readedRes = new byte[(int)f.length()];
            int readed=fileInputStream.read(readedRes);
            System.out.println("InputStream读出的数据："+new String(readedRes));
            fileInputStream.close();

        } catch (FileNotFoundException e) {  //处理异常要把自异常放在上面
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void testReaderAndWriterStream(){
        File f= new File("D:"+File.separator+"test.txt");
        try {
            FileWriter fileWriter =new FileWriter(f,true);
            String content = "我是由Writer写入!";
            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();  //不关闭写入文件的内容不生效,除非加上flush

            FileReader fileReader=new FileReader(f);
            char[] c=new char[1024];
            int temp=0;
            int len=0;
            while((temp=fileReader.read())!=-1){
                c[len]=(char) temp;
                len++;
            }

            fileReader.close();
            System.out.println("Reader读出的数据："+new String(c));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * JavaNIO相关,Channel的简单示例
     */
    void testNioChannel() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile( this.getClass().getResource("/").getPath()+"/data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }




    public static void main(String[] args){
        ICommonService iCommonService = new JavaIOService();
        iCommonService.excuteTest();
    }

}
