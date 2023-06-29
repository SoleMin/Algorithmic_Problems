import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			if (input.charAt(0) == '0') {
				System.out.println(Integer.decode(input));
			} else {
				
				System.out.println("0x" + Integer.toHexString(Integer.parseInt(input)).toUpperCase());
			}
		}
	}
}