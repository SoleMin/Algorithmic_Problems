import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input= new Scanner(System.in);
		
		while(input.hasNextLine()){
			String str1=input.nextLine();
			String str2=input.nextLine();
			
			int arr1[]=new int[26];
			int arr2[]=new int[26];
			
			Arrays.fill(arr1,0);
			Arrays.fill(arr2,0);
			
			for(int i=0; i<str1.length(); i++){
				int temp=str1.charAt(i);
				if(temp>=97 && temp<=122) 
					arr1[temp-97]++;
			}
			
			for(int i=0; i<str2.length(); i++){
				int temp=str2.charAt(i);
				if(temp>=97 && temp<=122)
					arr2[temp-97]++;
			}
			
			for(int i=0; i<26; i++){
				int min=Math.min(arr1[i],arr2[i]);
				for(int j=0; j<min; j++){
					System.out.print((char)(i+97));
				}
			}
			System.out.println();
		}
	}
}