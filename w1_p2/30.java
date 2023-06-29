import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			if (str.charAt(0) == '0') {
				int hex = Integer.parseInt(str.substring(2), 16);
				System.out.println(hex);
			} else {
				int dec = Integer.parseInt(str);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
	}
}