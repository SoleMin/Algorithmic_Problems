import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
class Main {
		static ArrayList<ArrayList<String>> list = new ArrayList<>();
		static ArrayList<String> WORD_RESULT = new ArrayList<>();
		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String a = input.nextLine();
			if(a.isEmpty()) break;
			String b = input.nextLine();
			ArrayList<String> WORD2 = new ArrayList<>();
			ArrayList<String> WORD = new ArrayList<>();
			String[] word = a.split("");
			String[] word2 = b.split("");
			boolean check1[] = new boolean[word2.length];
			boolean check2[] = new boolean[word.length];
			
			for(int i = 0; i <word.length; i++) {
					for(int j = 0; j < word2.length; j++) {
						if(word[i].contentEquals(word2[j])&&check1[j]==false) {
							WORD.add(word[i]);
							check1[j] = true;
					}
				}
			}
			for(int j = 0; j < word2.length; j++) {
				for(int i = 0; i < word.length; i++) {
					if(word2[j].contentEquals(word[i])&&check2[i]==false) {
						WORD2.add(word2[j]);
						check2[i] = true;
					}
				}
			}
			ArrayList<String> WORD_RESULT = new ArrayList<>();
			WORD_RESULT = (sizecomp(WORD, WORD2));
			
			Collections.sort(WORD_RESULT);
			list.add(WORD_RESULT);
		}
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
		input.close();
	}
	//사이즈 작은거 반환
	public static ArrayList<String> sizecomp(ArrayList<String> a, ArrayList<String> b) {
		if(a.size() > b.size())
			return b;
		else
			return a;
	}

}