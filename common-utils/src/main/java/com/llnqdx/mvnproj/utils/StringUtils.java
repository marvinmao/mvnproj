package com.llnqdx.mvnproj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author marvinmao
 * @Description:
 * @since 2018/11/10
 */
public class StringUtils {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final String PATTERN_HEX = "[A-Fa-f0-9]";// 十六进制字符

    public static final String PATTERN_CHAR = "[A-Za-z0-9]";// 普通字符，包括数字

    public static String print(String msg) {
        System.out.println(msg);
        return msg;
    }


    private StringUtils() {
        throw new IllegalStateException("StringUtils is a static Class!");
    }

    /**
     * @param obj
     * @return boolean
     * @Methods Name isEmpty 判断字符串为空
     * @Create In 2018年1月8日 By zhoushenghua
     */
    public static boolean isEmpty(Object obj) {
        boolean flag = false;
        if (obj instanceof String) {
            if ("".equals((String) obj)) {
                flag = true;
            }

        } else if (obj == null) {

            flag = true;
        }
        return flag;
    }

    public static boolean validString(String s, String pattern, int length) {
        return validString(s, pattern, length, 0);
    }

    public static boolean validString(String s, String pattern, int min, int max) {
        if (!PATTERN_HEX.equals(pattern) && !PATTERN_CHAR.equals(pattern)) {
            return false;
        }
        StringBuilder regex = new StringBuilder();
        regex.append("^").append(pattern);
        if (max > min) {
            regex.append("{").append(min).append(",").append(max).append("}");
        } else if (min > 0) {
            regex.append("{").append(min).append("}");
        } else {
            regex.append("+");
        }
        regex.append("$");
        return s.matches(regex.toString());
    }
}
