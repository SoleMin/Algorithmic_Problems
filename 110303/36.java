import java.io.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			
			ArrayList<Character> result = new ArrayList<Character>();
			
			String s1 = input.nextLine();
			String s2 = input.nextLine();
			
			char arr1[] = new char[s1.length()];
			char arr2[] = new char[s2.length()];
			
			for(int i=0;i<arr1.length;i++){
				arr1[i]=s1.charAt(i);
			}
			for(int i=0;i<arr2.length;i++){
				arr2[i]=s2.charAt(i);
			}
			
			for(int i=0;i<arr1.length;i++){
				for(int j=0;j<arr2.length;j++){
					if(arr2[j]==arr1[i]){
						result.add(arr1[i]);
						arr1[i]='0';
						arr2[j]='1';
						break;
					}
				}
			}
			
			Collections.sort(result);
			
			for(int i=0;i<result.size();i++){
				System.out.print(result.get(i));
			}
			
			System.out.println();
			
		}
	}
}