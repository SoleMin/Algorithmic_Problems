import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while ((input = br.readLine()) != null) {
			String kb = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./ ";
			for (int i = 0; i < input.length(); i++) {
				char a = kb.charAt(kb.indexOf(input.charAt(i)) - 1);
				if (a == '/') {
					System.out.print(" ");
				} else {
					System.out.print(a);
				}
			}
			System.out.println();
		}
	}
}