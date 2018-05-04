package com.qunincey.bbs.util;/*
* 这是一个读取配置文件的工具类
* */


import java.io.*;
import java.util.Properties;

public class ReadPop {

    /*
    * 读取配置文件 传入路径
    * */
    public static Properties readpop(){
        Properties props=new Properties();
        try {
            ReadPop readPop=new ReadPop();
            props.load(readPop.getClass().getResourceAsStream("/database.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;

    }
}
