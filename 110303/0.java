import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null && line.length() > 0){
			ArrayList<Character> word1 = new ArrayList<>();
			ArrayList<Character> word2 = new ArrayList<>();
			for (int i = 0; i < line.length(); i++)
				word1.add(line.charAt(i));
			line = br.readLine();
			for (int i = 0; i < line.length(); i++)
				word2.add(line.charAt(i));
			Collections.sort(word1);
			Collections.sort(word2);
			for (int i = 0; i < word1.size(); i++)
				for (int j = 0; j < word2.size(); j++)
					if(word1.get(i) == word2.get(j)){
						sb.append(word1.remove(i));
						word2.remove(j);
						i = 0;
						j = -1;
					}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}