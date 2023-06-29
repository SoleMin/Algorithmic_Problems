import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		while((input = br.readLine()) != null) {
			String s = input;
			if(s.charAt(0) == '0') {
				int hex = Integer.parseInt(s.substring(2),16);
				System.out.println(hex);
			}
			else {
				int dec = Integer.parseInt(s);
				String hs = Integer.toHexString(dec);
				System.out.println("0x" + hs.toUpperCase());
			}
		}
	}
}