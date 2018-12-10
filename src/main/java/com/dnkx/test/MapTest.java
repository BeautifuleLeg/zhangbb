package com.dnkx.test;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * Created by zhangbb on 2018/12/3.
 */
public class MapTest {



//     HashMap<String, String> map = new HashMap<String, String>() {
//        {
//            put("test", "1");
//            System.out.println("-------init----4------------");
//        }
//    };
//
//    public void test1(){
//        System.out.println("2");
//    }
//
//    public String test1(String s){
//        return "1";
//    }
//
//    {
//        init();
//    }
//
//    public void init(){
//
//    }
//
//    MapTest(){
//
//    }



    public static void main(String[] args) {
        Class claszz = MapTest.class;
        System.out.println(claszz.getModifiers());
        Modifier.isAbstract(claszz.getModifiers());
    }


}
