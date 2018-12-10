package com.dnkx.test;

import java.io.*;

/**
 * Created by zhangbb on 2018/7/26.
 */
public class IOTest {


    public static void main(String[] args)throws Exception {

        /*
        字符流：
        1> 字符流中的对象融合了编码表，也就是系统默认的编码表。我们的系统一般都是GBK编码。
        2>字符流只用来处理文本数据，字节流用来处理媒体数据。
        3>数据最常见的表现方式是文件，字符流用于操作文件的子类一般是FileReader和FileWriter。

        注意事项
        1>写入文件后必须要用flush()刷新。
        2>用完流后记得要关闭流
        3>抛出I/O异常
         */

        //flush()作用为了提高效率，写入的数据会先放入缓冲区，然后写入文件。
        // 所以有时需要主动调用flush()方法, 不一定writer后一定要调用flash，close执行会flash的

        FileWriter writer = new FileWriter("E:\\test\\t1.txt");
        writer.write("21");
//        writer.flush();
        writer.write("2222");
//        writer.flush();
        writer.write("1111");
//        writer.flush();
        writer.write("22222");
//        writer.flush();
//        writer.close();
//        writer.write("33333");
//        writer.flush();
        writer.close();


        // FileReader和FileWriter  字符流操作  reader 读  writer：写
//        FileReader reader = new FileReader("E:\\test\\t1.txt");
//        FileWriter writer = new FileWriter("E:\\test\\t2.txt");
//        //buf限定一次写入的数组长度 也可不用数组
//        char[] buf = new char[100];
//        String cha = "UTF-8";
//        int num = 0;
//        //不等于-1或者＞0 读取数据 read（char cbuf[], int offset, int length）,length小于等于char的长度
//        while ((num = reader.read(buf, 0, 100)) != -1) {
//            //输出数据到控制台
//            System.out.println(new String(buf, 0, num));
//            //讲buf数据从0到num写入指定文件
//            writer.write(buf, 0, num);
//        }
//        //关闭流
//        reader.close();
//        writer.close();


        //读取字符乱码或者文件储存乱码的时候，可以使用InputStreamReader先修改编码
   /*    InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test\\t4.txt"),"UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\test\\t2.doc"),"UTF-8");
        char[] cha = new char[100];
        int nu = 0;
        while((nu = isr.read(cha))!=-1){
            System.out.println(new String(cha,0,nu));
            osw.write(cha,0,nu);
        }
        isr.close();
        osw.close();*/


        /*
        缓冲区：
        1>缓冲区的出现是为了提高操作流的效率而出现的
        2>简单点来说就是封装了一个数组，然后一次性取出
        3>需要被提高效率的流作为参数传递给缓冲区的构造函数:new BufferedReader(fr)
         */
        //字符流的缓冲区 bufferedReader 和bufferedWriter  同样不可解决乱码问题
        FileReader fr = new FileReader("E:\\test\\t2.doc");
        BufferedReader br = new BufferedReader(fr);
        String s = "";
        for(;;){
            s = br.readLine();
            if(s == null){
                break;
            }
            System.out.println(s);
        }
        fr.close();
        br.close();

        FileWriter fw = new FileWriter("E:\\test\\t3.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(int x = 1; x < 999999; x++) {
            bw.write("齐秦");
            bw.newLine();                  //java提供了一个跨平台的换行符newLine(); 相当于换行符
            bw.flush();
        }
        bw.close();
        fw.close();



        /*
        字节流
        1>字节流和字符流的基本操作是相同的，但是要想操作媒体流就需要用到字节流
        2>字节流因为操作的是字节，所以可以用来操作媒体文件。（媒体文件也是以字节存储的）jpg,avi,cvs,zip等等
        3>读写字节流：InputStream   输入流（读）和OutputStream  输出流（写）
        4>字节流操作可以不用刷新流操作。
        5>InputStream特有方法：int available();//返回文件中的字节个数
        注意：可以利用此方法来指定读取方式中传入数组的长度，从而省去循环判断。但是如果文件较大，而虚拟机启动分配的默认内存一般为64M。
        当文件过大时，此数组长度所占内存空间就会溢出。所以，此方法慎用，当文件不大时，可以使用。
         */


        //操作字节流 方法类似
        long t1 = System.currentTimeMillis();
        InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\m.mp4");
        OutputStream out = new FileOutputStream("E:\\test\\我喜欢的.mp4");
        //区别在于这里，字符流是将文件变成char操作的，字节流用字节byte操作，所有字节流适用于字符文件传输，相反则不适用
        byte[] input = new byte[1024];
        int number = 0;
        while ((number = in.read(input)) != -1) {
            out.write(input,0,number);
        }
        in.close();
        out.close();
        long t2 = System.currentTimeMillis();
        System.out.println("执行时间："+(t2-t1)+"ms,"+(t2-t1)/1000+"s");
    }



}
