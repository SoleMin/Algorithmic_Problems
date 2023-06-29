import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			int words = 0;
			int letters = 0;
			String[] s2 = s.strip().split("\\s+");
			for(int i = 0; i < s2.length;i++) {
				words += 1;
				letters += s2[i].length();
			}
			System.out.printf("%d %d\n",letters,words);
		}
	}
}