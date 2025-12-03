import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.util.*;

public class CBC {
    public static void main(String[] a) throws Exception {
        String msg="HELLO CBC";
        SecretKey key=KeyGenerator.getInstance("AES").generateKey();
        byte[] iv=new byte[16]; new java.security.SecureRandom().nextBytes(iv);
        IvParameterSpec I=new IvParameterSpec(iv);
        
        Cipher c=Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE,key,I);
        String e=Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes()));
        
        c.init(Cipher.DECRYPT_MODE,key,I);
        String d=new String(c.doFinal(Base64.getDecoder().decode(e)));
        
        System.out.println(e);
        System.out.println(d);
    }
}
