import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		while(input.hasNext()) {
			ArrayList<Character> array = new ArrayList<Character>();
			String a=input.next();
			String b=input.next();
			int[] bb= new int[b.length()];
			
			for (int i=0; i<a.length(); i++){
				for(int j=0; j<b.length(); j++){
					if(a.charAt(i)==b.charAt(j) && bb[j]==0) {
						array.add(a.charAt(i));
						bb[j]=1;
						break;
					}
				}
			}
			
			Collections.sort(array);
			for(Character c:array){
				System.out.print(c);
			}
			System.out.println();
		}
		
		
		input.close();
	}
}