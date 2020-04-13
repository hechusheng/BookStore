package com.xzsd.pc.util;

import java.util.Random;

/**
 * 生成一串随机数
 * @author 戴顺
 * @date 2015-08-14
 */


public class RandomUtil {

    /*
     * @param count :需要产生随机数的个数
     */
    public static String radmonkey(int count){
        StringBuffer sbf=new StringBuffer();
        for (int i = 0; i <count; i++) {
            int num=(int)(Math.random()*10);
            sbf.append(num);
        }

        return sbf.toString();
    }
    //length用户要求产生字符串的长度
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        System.err.println(radmonkey(32));
    }

}