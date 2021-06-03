package com.example.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolsUtils {

    /**
     * url地址MD5加密
     * @param url
     * @return
     */
    public String EncryptionUrl(String url) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(url.getBytes("UTF-8"));
            byte[] b = md5.digest();

            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            url = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 大量数据分段处理
     */
    public void HandMassData() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 21210; i++) {
            list.add(i);
        }
        int listSize = list.size();
        int toIndex = 1000;
        for (int i = 0; i < list.size(); i += 1000) {
            if (i + 1000 > listSize) {
                toIndex = listSize - i;
            }
            List<Integer> list1 = list.subList(i, i + toIndex);
            System.out.println(Arrays.toString(list1.toArray()));
        }
    }
}
