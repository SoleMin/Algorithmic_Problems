import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String s = input.nextLine();
			if(s.charAt(0)=='0'){
				if(s.equals("0")) {
					System.out.println("0x" + s);
					continue;
				}
				int hex = Integer.parseInt(s.substring(2),16);
				System.out.println(hex);
			}
			else{
				int dec = Integer.parseInt(s);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
}
}