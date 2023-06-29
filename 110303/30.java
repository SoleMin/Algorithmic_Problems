import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()){
			
			String a = scanner.nextLine();
			String b = scanner.nextLine();
			int[] ta = new int[26];
			int[] tb = new int[26];
			
			Arrays.fill(ta, 0);
			Arrays.fill(tb, 0);
			
			for(int i = 0; i < a.length(); i++){
				ta[a.charAt(i) - 97]++;
			}
			for(int j = 0; j < b.length(); j++){
				tb[b.charAt(j) - 97]++;
			}
			for(int k = 0; k < 26; k++){
				for(int l = 0; l < ta[k] && l < tb[k]; l++){
					System.out.print((char) (k + 97));
				}
			}
			System.out.println();
		}
		scanner.close();
	}
}