import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if (input.charAt(0)=='0') {
				int hex = Integer.parseInt(input.substring(2), 16);
				System.out.println(hex);
			}
			else {
				int dec = Integer.parseInt(input);
				String hex = Integer.toHexString(dec);
				System.out.println("0x" + hex.toUpperCase());
			}
		}
	}
}