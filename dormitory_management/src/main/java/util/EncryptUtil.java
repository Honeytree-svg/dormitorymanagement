package util;

import java.security.MessageDigest;

//主要用于密码加密 然后存放到数据库
public class EncryptUtil {
    public static String encrypt(String inStr) {
        String out = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(inStr.getBytes());
            out = byte2hex(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public static String byte2hex(byte[] b) {
        StringBuffer hs = new StringBuffer();
        for (int n = 0; n < b.length; n++) {
            String stmp = Integer.toHexString(b[n] & 0xFF);
            //System.out.println(b[n]);
            //System.out.println(stmp);
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
            System.out.println(stmp.toString());
        }
        return hs.toString().toUpperCase();
    }
}

