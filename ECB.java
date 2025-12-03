import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class ECBExample {
    public static void main(String[] args) throws Exception {

        String msg = "HELLO ECB MODE";
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] enc = cipher.doFinal(msg.getBytes());
        String encText = Base64.getEncoder().encodeToString(enc);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = cipher.doFinal(Base64.getDecoder().decode(encText));
        String decText = new String(dec);

        System.out.println("Plain Text  : " + msg);
        System.out.println("Encrypted   : " + encText);
        System.out.println("Decrypted   : " + decText);
    }
}
