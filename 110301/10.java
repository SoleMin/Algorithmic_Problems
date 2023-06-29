import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String temp = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;\'ZXCVBNM,./";
		char[] tempc = new char[temp.length()];
		
		for (int i = 0; i < temp.length(); i++) {
			tempc[i] = temp.charAt(i);
		}
		
		while (sc.hasNextLine()) {
			
			String line = sc.nextLine();
			char[] linec = new char[line.length()];
			
			for (int i = 0; i < line.length(); i++) {
				linec[i] = line.charAt(i);
			}
			
			for (int i = 0; i < line.length(); i++) {
				if (linec[i] == ' ') {
					System.out.print(" ");
					continue;
				}
				for (int j = 0; j < temp.length(); j++) {
					if (linec[i] == tempc[j]) {
						System.out.print(tempc[j-1]);
						break;
					}
				}
			}
			System.out.println();
		}
	}
}