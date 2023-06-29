import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String sa = input.nextLine();
			String sb = input.nextLine();
			
			int[] a = new int[26];
			int[] b = new int[26];
			for(int i=0; i<sa.length(); i++)
				a[sa.charAt(i) - 97]++;
			for(int i=0; i<sb.length(); i++)
				b[sb.charAt(i) - 97]++;
			
			StringBuffer stb = new StringBuffer("");
			for(int i=0; i<26; i++) {
				int m = a[i]>b[i] ? b[i] : a[i];
				for(int j=0; j<m; j++)
					stb.append((char) (97+i));
			}
			System.out.println(stb.toString());
		}
		input.close();
	}
}