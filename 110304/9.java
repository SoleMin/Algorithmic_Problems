import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		input.nextLine();
		for(int r=0; r<repeat; r++) {
			// 표준 출력을 통해 데이터를 입력받는다.
			String s = input.nextLine();
			String[] crypt = new String[100];
			int count = 0;
			while(!s.isEmpty()) {
				crypt[count] = s;
				count++;
				if(!input.hasNextLine())
					break;
				s = input.nextLine();
			}
			
			// "the quick brown fox jumps over the lazy dog"를 찾아서 복호화법을 알아낸다.
			// 해당 문장을 찾을 수 없을 경우 "No solution"을 출력하고 다음 케이스로 넘어간다.
			int[] kicker = new int[26];
			String key = "the quick brown fox jumps over the lazy dog";
			boolean keyFound = false;
			for(int i=0; i<count; i++)
				if(key.length() == crypt[i].length()) {
					int wrong = 0;
					for(int j=0; j<key.length(); j++)
						if(key.charAt(j) == ' ') {
							if(crypt[i].charAt(j) != ' ')
								wrong++;
						} else
							if(crypt[i].charAt(j) == ' ')
								wrong++;
					
					for(int j=1; j<key.length(); j++)
						for(int k=0; k<j; k++)
							if(key.charAt(j)==key.charAt(k) && crypt[i].charAt(j)!=crypt[i].charAt(k))
								wrong++;
					
					HashSet<Character> h = new HashSet<Character>();
					for(int j=0; j<key.length(); j++)
						h.add(crypt[i].charAt(j));
					h.remove(' ');
					if(h.size() != 26)
						wrong++;
					
					if(wrong == 0) {
						for(int j=0; j<key.length(); j++)
							if(crypt[i].charAt(j) != ' ')
								kicker[crypt[i].charAt(j) - 97] = key.charAt(j) - 97;
						keyFound = true;
						break;
					}
				}
			if(!keyFound) {
				if(r>0)
					System.out.println();
				System.out.println("No solution.");
				continue;
			}
			
			// 알아낸 복호화법을 통해 암호 전체를 복호화하여 출력한다.
			StringBuffer[] solved = new StringBuffer[count];
			for(int i=0; i<count; i++) {
				solved[i] = new StringBuffer("");
				for(int j=0; j<crypt[i].length(); j++) {
					if(crypt[i].charAt(j) == ' ')
						solved[i].append(' ');
					else
						solved[i].append((char) (kicker[crypt[i].charAt(j)-97] + 97));
				}
			}
			if(r>0)
				System.out.println();
			for(StringBuffer sb : solved)
				System.out.println(sb.toString());
		}
		input.close();
	}
}