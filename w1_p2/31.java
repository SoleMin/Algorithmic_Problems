import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextLine()){
			String s = scan.nextLine();
			if(s.charAt(0) == '0'){
				int hex = Integer.parseInt(s.substring(2), 16);
				System.out.println(hex);
			}
			else{
				int dec = Integer.parseInt(s);
				String hs = Integer.toHexString(dec);
				System.out.println("0x"+hs.toUpperCase());
			}
		}
	}
}