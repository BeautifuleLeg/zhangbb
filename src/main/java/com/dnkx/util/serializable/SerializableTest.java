package com.dnkx.util.serializable;

import java.io.*;

/**
 * Created by zhangbb on 2018/6/14.
 */
public class SerializableTest {

    public static void main(String[] args) {
        FlyPig flyPig = new FlyPig();
//        System.out.println(flyPig.getTe());

    }


//    public static void main(String[] args) throws Exception {
////        serializeFlyPig();
//        FlyPig fly = deserializeFlyPig();
//        System.out.println(fly.toString());
//    }

    /**
     * 序列化
     */
    private static void serializeFlyPig() throws IOException {
        FlyPig flyPig = new FlyPig();
        flyPig.setColor("black");
        flyPig.setName("测试");
        flyPig.setCar("0000");
        // ObjectOutputStream 对象输出流，将 flyPig 对象存储到E盘的 flyPig.txt 文件中，完成对 flyPig 对象的序列化操作
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("d:/flyPig.txt")));
        oos.writeObject(flyPig);
        System.out.println("FlyPig 对象序列化成功！");
        oos.close();
    }


    /**
     * 反序列化
     */
    private static FlyPig deserializeFlyPig() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("d:/flyPig.txt")));
        FlyPig person = (FlyPig) ois.readObject();
        System.out.println("FlyPig 对象反序列化成功！");
        return person;
    }


}
