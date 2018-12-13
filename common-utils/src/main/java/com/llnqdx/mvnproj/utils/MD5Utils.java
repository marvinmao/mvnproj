package com.llnqdx.mvnproj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author marvinmao
 * @Description:
 * @since 2018/11/10
 */
public class MD5Utils {
    private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static final String WMS_TONGBU_KEY = "DBeAyw8RMvT586eelFYkrQMPo7s7I6tE";

    /**
     * 根据流获取MD5值
     *
     * @param inputStream
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getMD5ByInputStream(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        StringBuffer md5 = new StringBuffer();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = inputStream.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }
        byte[] mdbytes = md.digest();

        // convert the byte to hex format
        for (int i = 0; i < mdbytes.length; i++) {
            md5.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return md5.toString();
    }

    /**
     * 校验文件md5值是否合法
     *
     * @param multipartFile
     * @param fileMd5
     * @return
     */
    public static boolean isLegalFileMd5(MultipartFile multipartFile, String fileMd5) {
        InputStream inputStream;
        try {
            inputStream = multipartFile.getInputStream();
            String md5ByIs = getMD5ByInputStream(inputStream);
            logger.debug("md5ByIs--->" + md5ByIs);
            logger.debug("fileMd5--->" + fileMd5);
            if (fileMd5.equals(md5ByIs)) {
                return true;
            }
        } catch (IOException e) {
            logger.error("isLegalFileMd5 error " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            logger.error("isLegalFileMd5 NoSuchAlgorithmException error " + e.getMessage());
        }
        return false;
    }

    public static String getSign(Map<String, Object> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != "") {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + WMS_TONGBU_KEY;
        logger.info("Sign Before MD5:" + result);
        result = md5Encode(result).toUpperCase();
        logger.info("Sign Result:" + result);
        return result;
    }

    /**
     * MD5编码
     *
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String md5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder resultSb = new StringBuilder();
        for (byte bt : bytes) {
            resultSb.append(byteToHexString(bt));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     *
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }
}
