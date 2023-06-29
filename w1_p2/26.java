import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		StringBuilder tempsb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int innum;
		
		while(sc.hasNextLine()) {
			String stnum = sc.nextLine();
			sb.setLength(0);
			if (stnum.length() == 1 || stnum.charAt(1) != 'x') {
				innum = Integer.parseInt(stnum);
				while (innum > 0) {
					if (innum % 16 < 10) {
						sb.append((innum % 16));
					} else {
						switch(innum % 16 - 10) {
							case 0: sb.append('A');
								break;
							case 1: sb.append('B');
								break;
							case 2: sb.append('C');
								break;
							case 3: sb.append('D');
								break;
							case 4: sb.append('E');
								break;
							case 5: sb.append('F');
								break;
						}
					}
					innum /= 16;
				}
				System.out.printf("0x%s\n", sb.reverse());
			} else {
				int hex = Integer.parseInt(stnum.substring(2), 16);
				System.out.println(hex);
			}
		}
	}
}