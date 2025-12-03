import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import java.security.*;
import java.util.Base64;

public class DiffieMini {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048);
        KeyPair alice = kpg.generateKeyPair();

        DHPublicKey pubA = (DHPublicKey) alice.getPublic();
        kpg.initialize(pubA.getParams());
        KeyPair bob = kpg.generateKeyPair();

        KeyAgreement aAgree = KeyAgreement.getInstance("DH");
        aAgree.init(alice.getPrivate());
        aAgree.doPhase(bob.getPublic(), true);
        byte[] aSecret = aAgree.generateSecret();

        KeyAgreement bAgree = KeyAgreement.getInstance("DH");
        bAgree.init(bob.getPrivate());
        bAgree.doPhase(alice.getPublic(), true);
        byte[] bSecret = bAgree.generateSecret();

        System.out.println("Alice Public: " + Base64.getEncoder().encodeToString(alice.getPublic().getEncoded()));
        System.out.println("Bob Public:   " + Base64.getEncoder().encodeToString(bob.getPublic().getEncoded()));
        System.out.println("Shared Secret: " + Base64.getEncoder().encodeToString(aSecret));
        System.out.println("Secrets match: " + MessageDigest.isEqual(aSecret, bSecret));
    }
}
