import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String s1 = input.nextLine();
			String s2 = input.nextLine();
			
			char[] c1 = s1.toCharArray();
			char[] c2 = s2.toCharArray();
			
			int[] n1 = new int[26];
			int[] n2 = new int[26];
			int[] min = new int[26];
			
			for(int i = 0; i<26; i++){
				for(int j = 0; j<c1.length; j++)
					if(((int)c1[j] - 97) == i)
						n1[i]++;
				for(int j = 0; j<c2.length; j++)
					if(((int)c2[j] - 97) == i)
						n2[i]++;
			}
			
			for(int i = 0; i<26; i++){
				if(n1[i] == n2[i])
					min[i] = n1[i];
				else if(n1[i] > n2[i])
					min[i] = n2[i];
				else
					min[i] = n1[i];
			}
			
			for(int i = 0; i<min.length; i++){
				if(min[i] != 0){
					for(int j = 0; j<min[i]; j++)
						System.out.print((char)(i+97));
				}
				else
					continue;
			}
			
			System.out.println();	
		}
	}
}