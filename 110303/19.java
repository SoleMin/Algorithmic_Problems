import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int [] num = new int[52];
		int [] cnt1 = new int[52];
		int [] cnt2 = new int[52];
		
		String line1 = sc.nextLine();
		
		while(sc.hasNextLine() && line1.length() != 0) {
			// System.out.println(line1.length());
			for (int i = 0; i < 52; i ++) {
				num[i] = 0;
				cnt1[i] = 0;
				cnt2[i] = 0;
			}
			
			String line2 = sc.nextLine();
			
			for(int i = 0; i < line1.length(); i ++) {
				int index = (int)line1.charAt(i) - 97;
				if (num[index] == 0) {
					num[index]++;
				}
				cnt1[index]++;
			}
			for(int i = 0; i < line2.length(); i++) {
				num[(int)line2.charAt(i) - 97]++;
				cnt2[(int)line2.charAt(i) - 97]++;
			}
			
			for (int i = 0; i < 52; i ++) {
				if (num[i] >= 2) {
					if (cnt1[i] > cnt2[i])
						for (int j = 0; j < cnt2[i]; j++)
							System.out.print((char)(i+97));
					else
						for (int j = 0; j < cnt1[i]; j++)
							System.out.print((char)(i + 97));
				}
			}
			System.out.println();
			if (sc.hasNextLine())
				line1 = sc.nextLine();
		}		
	}
}