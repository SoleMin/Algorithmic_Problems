import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s1 = input.nextLine();
			String s2 = input.nextLine();
			
			if(s1.isEmpty() || s2.isEmpty())
				break;
			
			String temp1[] = s1.split("");
			String temp2[] = s2.split("");
			
			String str = "";
			String str2 = "";
			
			for(int i = 0; i < temp1.length; i++) 
				for(int j = 0; j < temp2.length; j++)
					if(temp1[i].equals(temp2[j])) {
						str += temp2[j];
						break;
					}
			
			for(int i = 0; i < temp2.length; i++)
				for(int j = 0; j < temp1.length; j++)
					if(temp2[i].equals(temp1[j])) {
						str2 += temp1[j];
						break;
					}
			
			if(str.length() > str2.length())
				str = str2;
			
			String result[] = new String[str.length()];
			
			for(int i = 0; i < result.length; i++)
				result[i] = Character.toString(str.charAt(i));
			
			Arrays.sort(result);
			
			for(int i = 0; i < result.length; i++)
				System.out.print(result[i]);
			
			System.out.println();
					
		}
		input.close();
	}
}