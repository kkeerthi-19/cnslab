import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class SimpleRSA {
    public static void main(String[] a) throws Exception {

        String msg = "HELLO RSA";
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);                    // key size
        KeyPair kp = kpg.generateKeyPair();
        PublicKey pub = kp.getPublic();
        PrivateKey pri = kp.getPrivate();
        Cipher c = Cipher.getInstance("RSA");
        c.init(Cipher.ENCRYPT_MODE, pub);
        String enc = Base64.getEncoder()
                           .encodeToString(c.doFinal(msg.getBytes()));
        c.init(Cipher.DECRYPT_MODE, pri);
        String dec = new String(
                c.doFinal(Base64.getDecoder().decode(enc))
        );

        System.out.println("Plain : " + msg);
        System.out.println("Enc   : " + enc);
        System.out.println("Dec   : " + dec);
    }
}
