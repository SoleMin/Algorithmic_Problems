import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			
			if (input.charAt(0) == '0') {
				int hex = Integer.parseInt(input.substring(2), 16);
				System.out.println(hex);
			}
			else {
				int dec = Integer.parseInt(input);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
	}
}