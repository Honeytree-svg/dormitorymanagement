import org.junit.Test;
import util.EncryptUtil;

import java.security.MessageDigest;

public class UtileTest {

    @Test
    public void EncryptTest(){
        //EncryptUtil.byte2hex()
//        String s=EncryptUtil.encrypt("123456");
//        int x=0xff;
//        System.out.println("123456".getBytes().length);
//        System.out.println("123456".getBytes()[0]);
//        String stmp = Integer.toHexString(49 & 0xFF);
//        System.out.println(stmp);
//        for (int i=0;i<8;i++){
//            String stmp = Integer.toHexString(i & 0xFF);
  //        System.out.println(s);
//        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest("123456".getBytes());
            System.out.println(digest.length);

            String s1 = String.format("%8s", Integer.toBinaryString(digest[0] & 0xFF)).replace(' ', '0');
            System.out.println(s1);
            System.out.println(digest[0] & 0xFF);
            String stmp = Integer.toHexString(digest[0] & 0xFF);
            System.out.println(stmp);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void EncryptTest2(){
        System.out.println(EncryptUtil.encrypt("123456"));
    }
}
