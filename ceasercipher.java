public class CaesarCipher {
    public static String cipher(String text, int key) {
        String result = "";
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result += (char)((c - base + key + 26) % 26 + base);
            } else {
                result += c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String msg = "Hello World";
        int key = 3;

        String encrypted = cipher(msg, key);      // encryption
        String decrypted = cipher(encrypted, -key); // decryption

        System.out.println("Original : " + msg);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
