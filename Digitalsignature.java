import java.security.*;
import java.util.Base64;

public class DigitalSignatureShort {
    public static void main(String[] args) throws Exception {
        String msg = "This is a secret message.";

        KeyPair kp = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        Signature s = Signature.getInstance("SHA256withRSA");

        s.initSign(kp.getPrivate());
        s.update(msg.getBytes());
        String sig = Base64.getEncoder().encodeToString(s.sign());

        s.initVerify(kp.getPublic());
        s.update(msg.getBytes());
        boolean ok = s.verify(Base64.getDecoder().decode(sig));

        System.out.println("Message: " + msg);
        System.out.println("Signature: " + sig);
        System.out.println(ok ? "✅ Verified" : "❌ Verification failed");
    }
}
