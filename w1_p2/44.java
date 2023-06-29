import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()) {
			
			String str = scan.nextLine();
			
			if (str.charAt(0) == '0') {
				
				int hex_to_dec = Integer.parseInt(str.substring(2), 16);
				
				System.out.println(hex_to_dec);
				
			}
			
			else {
				
				int dec = Integer.parseInt(str);
				String dec_to_hex = Integer.toHexString(dec);
				
				System.out.println("0x" + dec_to_hex.toUpperCase());
				
			}
		}
	}
}