import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		int i;
		Scanner input1 = new Scanner(System.in);
	
		while(input1.hasNext()){
			String s1 = input1.next();
			String s2 = input1.next();
			int count1 [] = new int[26];
			int count2 [] = new int[26];
			for(i = 0; i < s1.length(); i++){
				char c = s1.charAt(i);
				int a = c-97;
				count1[a]++;
			}
			for(i =0; i < s2.length(); i++){
				char c= s2.charAt(i);
				int a = c-97;
				count2[a]++;
			}
			for(i = 0; i <26; i++){
				int output= Math.min(count1[i], count2[i]);
				if(output == 0)
					continue;
				else{
					for(int j=0; j <output; j++)
						System.out.print((char)(i+97));
				}
			}
			System.out.println();
			
		}
		
		input1.close();
		
	}
}