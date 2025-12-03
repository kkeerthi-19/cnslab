import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SimpleDES {
    public static void main(String[] args) throws Exception {

        String plainText = "HELLO DES";
      
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encBytes = cipher.doFinal(plainText.getBytes());
        String encText = Base64.getEncoder().encodeToString(encBytes);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decBytes = cipher.doFinal(Base64.getDecoder().decode(encText));
        String decText = new String(decBytes);

        System.out.println("Plain text : " + plainText);
        System.out.println("Encrypted  : " + encText);
        System.out.println("Decrypted  : " + decText);
    }
}
