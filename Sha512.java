import java.security.MessageDigest; 
public class SHA512 { 
public static void main(String[] args) throws Exception { 
String text = "Gowtham"; 
MessageDigest md = MessageDigest.getInstance("SHA-512"); 
byte[] digest = md.digest(text.getBytes()); 
 
// Convert to hex string 
StringBuilder sb = new StringBuilder(); 
for (byte b : digest) sb.append(String.format("%02x", b)); 
System.out.println("SHA-512 digest: " + sb); 
} 
} 
