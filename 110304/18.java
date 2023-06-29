import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) {//throws Exception {
		Scanner input = new Scanner (System.in);
		HashMap<Character, Character> map = new HashMap<>();
		
		int cases = input.nextInt();
		int sentenceCount;
		String sample = "the quick brown fox jumps over the lazy dog";
		//String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String [] sentences;
		StringBuilder sb = new StringBuilder();
		
		input.nextLine();
		input.nextLine();
		
		for (int i = 0; i < cases; i++) { // 테스트 케이스 갯수만큼 반복
	//		input.nextLine();
			sentenceCount = 0;
			map.clear();
			
			sentences = new String [100];
			
			while (input.hasNextLine()) {
				sentences[sentenceCount] = input.nextLine();
				if (sentences[sentenceCount].equals(""))
					break;
				sentenceCount++;
			}
			
			boolean hasSample = false;
			for (int j = 0; j < sentenceCount; j++)
				if (isCryptedSample(sentences[j]))
					hasSample = true;
			
			if (!hasSample)
				System.out.println("No solution.");
			
			else {
			
				for (int j = 0; j < sentenceCount; j++) {//문장 수
					if(isCryptedSample(sentences[j])) {
						for (int k = 0; k < 43; k++)
							if (!map.containsKey(sentences[j].charAt(k)))
								map.put(sentences[j].charAt(k), sample.charAt(k));
						
							
					}
					
					
				}
				
				for (int j = 0; j < sentenceCount; j++) {
					if (sentences[j].length() == 0)
						System.out.print("");
					else
						for (int k = 0; k < sentences[j].length(); k++)
							System.out.print(map.get(sentences[j].charAt(k)));
					System.out.println();
				}
				
			}
			
			System.out.println();
			
		}
	}
	
	public static boolean isCryptedSample (String sentence) {
		String sample = "the quick brown fox jumps over the lazy dog";
		
		StringBuilder sb = new StringBuilder();
		
		HashMap <Character, Character> tempmap = new HashMap<>();
		
		if (sentence.length() != 43)
			return false;
		
		for (int i = 0; i < sentence.length(); i++) {
			if (sample.indexOf(sentence.charAt(i)) == -1)
				return false;
			
		}
		
		// if (sentence.length() != 43)
		// 	return false;
		
		if (sentence.charAt(3) != ' ' || sentence.charAt(9) != ' ' 
			 || sentence.charAt(15) != ' ' || sentence.charAt(19) != ' '
				|| sentence.charAt(25) != ' ' || sentence.charAt(30) != ' '
				|| sentence.charAt(34) != ' ' || sentence.charAt(39) != ' ')
			return false;
		
		if (sentence.charAt(12) != sentence.charAt(17) ||
				sentence.charAt(17) != sentence.charAt(26) ||
				sentence.charAt(26) != sentence.charAt(41) ||
				sentence.charAt(0) != sentence.charAt(31) ||
				sentence.charAt(1) != sentence.charAt(32) ||
				sentence.charAt(2) != sentence.charAt(33) ||
				sentence.charAt(2) != sentence.charAt(28) ||
				sentence.charAt(5) != sentence.charAt(21) ||
				sentence.charAt(11) != sentence.charAt(29))
			return false;
		
		for (int i = 0; i < 43; i++)
			if (!tempmap.containsKey(sentence.charAt(i)))
				tempmap.put(sentence.charAt(i), sample.charAt(i));
		
		for (int i = 0; i < 43; i++)
			sb.append(String.valueOf(tempmap.get(sentence.charAt(i))));
		
		String check = sb.toString();
		
		if (!check.equals(sample))
			return false;
		
		tempmap.clear();
		
		
		return true;
		
	}
}