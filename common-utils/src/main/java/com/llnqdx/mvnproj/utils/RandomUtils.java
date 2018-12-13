package com.llnqdx.mvnproj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.UUID;

/**
 * @author marvinmao
 * @Description:
 * @since 2018/11/10
 */
public class RandomUtils {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String SOURCES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    public static final int SOURCES_DEFAULT_LENGTH = 20;
    public static final int RANDOM_DEFAULT_MAX = 100;
    public static final int RANDOM_DEFAULT_MIN = 1;

    private RandomUtils() {
        throw new IllegalStateException("RandomUtils is a static Class!");
    }

    /**
     * 生成UUID
     *
     * @return String
     * @Create In 2018年1月8日 By 刘淦潮
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 生成随机字符串
     *
     * @return
     */
    public static String randomString() {
        return randomString(SOURCES, SOURCES_DEFAULT_LENGTH);
    }

    /**
     * 生成随机字符串(长度截取)
     *
     * @param length
     * @return
     */
    public static String randomString(int length) {
        return randomString(SOURCES, length);
    }

    /**
     * 生成随机字符串(字符串、长度截取)
     *
     * @param characters
     * @param length
     * @return
     */
    public static String randomString(String characters, int length) {
        Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     * 生成随机字符串类型数字
     */
    public static String randomNum() {
        return randomNum(RANDOM_DEFAULT_MIN, RANDOM_DEFAULT_MAX);
    }

    public static String randomNum(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max) % (max - min + 1) + min;
        return result + "";
    }

    public static double[] randomDArray(int m, int n) {
        double[] dobRet = new double[n];
        int intRd = 0; // 存放随机数
        int count = 0; // 记录生成的随机数个数
        boolean flag = false;  // 是否已经生成过标志
        while (count < n) {
            Random rdm = new Random(System.currentTimeMillis());
            intRd = Math.abs(rdm.nextInt()) % m + 1;
            for (int i = 0; i < count; i++) {
                if (dobRet[i] == intRd) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (flag == false) {
                dobRet[count] = intRd;
                count++;
            }
        }
        return dobRet;
    }
}
