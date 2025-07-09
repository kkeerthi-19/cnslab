import java.util.Scanner;
public class RowColumn {
	    public static String encrypt(String message, int rows, int cols) {
	        message = message.replaceAll(" ", "").toUpperCase();
	        int total = rows * cols;
	        if (message.length() < total) {
	            int padLength = total - message.length();
	            for (int i = 0; i < padLength; i++) {
	                message += "X";
	            }
	        }
	        char[][] matrix = new char[rows][cols];
	        int index = 0;
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                matrix[i][j] = message.charAt(index++);
	            }
	        }
	        String cipher = "";
	        for (int j = 0; j < cols; j++) {
	            for (int i = 0; i < rows; i++) {
	                cipher += matrix[i][j];
	            }
	        }

	        return cipher;
	    }
	    public static String decrypt(String cipher, int rows, int cols) {
	        // Fill matrix column-wise
	        char[][] matrix = new char[rows][cols];
	        int index = 0;
	        for (int j = 0; j < cols; j++) {
	            for (int i = 0; i < rows; i++) {
	                matrix[i][j] = cipher.charAt(index++);
	            }
	        }
	        String message = "";
	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                message += matrix[i][j];
	            }
	        }
	        return message;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the message: ");
	        String message = sc.nextLine();
	        System.out.print("Enter number of rows: ");
	        int rows = sc.nextInt();
	        System.out.print("Enter number of columns: ");
	        int cols = sc.nextInt();
	        String encrypted = encrypt(message, rows, cols);
	        System.out.println("Encrypted Message: " + encrypted);
	        String decrypted = decrypt(encrypted, rows, cols);
	        System.out.println("Decrypted Message: " + decrypted);
	    }
	}
