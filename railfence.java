import java.util.*;
public class RailFence {
	static String encrypt(String text) {
	       StringBuilder rail1 = new StringBuilder();
	       StringBuilder rail2 = new StringBuilder();
	       for (int i = 0; i < text.length(); i++) {
	           if (i % 2 == 0) rail1.append(text.charAt(i));
	           else rail2.append(text.charAt(i));
	       }
	       return rail1.append(rail2).toString();
	   }

	   static String decrypt(String cipher) {
	       int mid = (cipher.length() + 1) / 2;
	       String rail1 = cipher.substring(0, mid);
	       String rail2 = cipher.substring(mid);
	       StringBuilder result = new StringBuilder();
	       for (int i = 0; i < mid; i++) {
	           result.append(rail1.charAt(i));
	           if (i < rail2.length()) result.append(rail2.charAt(i));
	       }
	       return result.toString();
	   }

	   public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter text: ");
	       String text = sc.nextLine().replaceAll("\\s+", "");
	       String encrypted = encrypt(text);
	       System.out.println("Encrypted: " + encrypted);
	       System.out.println("Decrypted: " + decrypt(encrypted));
	       sc.close();
	   }
}
