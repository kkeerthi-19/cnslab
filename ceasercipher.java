import java.util.*;
public class ceaser_cipher {
	public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shifted = (c - base + shift) % 26;
                if (shifted < 0) shifted += 26; // Handle negative shifts for decryption
                result.append((char) (base + shifted));
            } else {
                // Non-alphabetic characters remain unchanged
                result.append(c);
            }
        }

        return result.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        System.out.print("Enter shift amount: ");
        int shift = scanner.nextInt();

        String encrypted = caesarCipher(input, shift);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = caesarCipher(encrypted, -shift);
        System.out.println("Decrypted text: " + decrypted);

        scanner.close();
	}

}
