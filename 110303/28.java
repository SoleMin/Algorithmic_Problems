import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		int i, j;
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()) {
			String scan1 = scanner.nextLine();
			String scan2 = scanner.nextLine();
			
			StringBuilder s1 = new StringBuilder();
			StringBuilder s2 = new StringBuilder();
			
			s1.append(scan1);
			s2.append(scan2);
			
			StringBuilder result = new StringBuilder();
			
			for(i = 0; i < s1.length(); i++) {
				for(j = 0; j < s2.length(); j++) {
					if(s1.charAt(i) == s2.charAt(j)) {
						result.append(s1.charAt(i));
						s2.deleteCharAt(j);
						break;
					}
				}
			}
			
			String ab = result.toString();
			
			String arr[] = ab.split("");
			Arrays.sort(arr);
			StringBuffer s = new StringBuffer();
			for(i = 0; i < arr.length; i++)
				s.append(arr[i]);
			
			System.out.print(s);
			System.out.println();
		}
	}
}