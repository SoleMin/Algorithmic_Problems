import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
		
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					System.out.print(" ");
				} else {
					System.out.print(key.charAt(key.indexOf(str.charAt(i)) - 1));
				}
			}
			System.out.println();
		}
	}
}