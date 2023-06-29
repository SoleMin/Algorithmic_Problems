import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		Scanner input = new Scanner(System.in);
		
		int [] aCount, bCount, result;
		
		while(true) {
			
			String wordA = input.nextLine();
			String wordB = input.nextLine();
			
			aCount = new int[26];
			bCount = new int[26];
			result = new int[26];
			
			for (int i = 0; i < wordA.length(); i++)
				aCount[alphabet.indexOf(wordA.charAt(i))]++;
			for (int i = 0; i < wordB.length(); i++)
				bCount[alphabet.indexOf(wordB.charAt(i))]++;
			
			
			for (int i = 0; i < 26; i++) {
				if (aCount[i] != 0 && bCount[i] != 0) {
					if (aCount[i] < bCount[i])
						result[i] = aCount[i];
					else
						result[i] = bCount[i];
				}
			}
			
			for (int i = 0; i < 26; i++)
				for (int j = 0; j < result[i]; j++)
					System.out.print(alphabet.charAt(i));
			
			System.out.println();
			
			if (!input.hasNextLine())
				break;
		}
	}
	
}