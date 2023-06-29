import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String s = input.nextLine();
			if(s.equals(""))
				break;
			String s1 = input.nextLine();
			int len = s.length();
			int len1 = s1.length();
			
			int[] count = new int[26];
			int[] count1 = new int[26];
			int[] total = new int[26];
			boolean[] isVisit = new boolean[26];
			for(int i = 0; i < 26; i++){
				count[i] = 0;
				count1[i] = 0;
				isVisit[i] = false;
			}
			for(int i = 0; i < len; i++)
				count[s.charAt(i) - 97]++;
			for(int i = 0; i < len1; i++)
				count1[s1.charAt(i) - 97]++;
			for(int i = 0; i < len; i++){
				for(int j = 0; j < len1; j++){
					if(s.charAt(i) == s1.charAt(j))
						isVisit[s.charAt(i) - 97] = true;
				}
			}
			for(int i = 0; i < total.length; i++){
				if(isVisit[i]){
					if(count[i] > count1[i])
						total[i] = count1[i];
					else
						total[i] = count[i];
					for(int j = 0; j < total[i]; j++)
						System.out.print((char)(i + 97));
				}
			}
			System.out.println();
		}
		input.close();
	}
}