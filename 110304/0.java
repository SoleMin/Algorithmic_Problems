import java.io.*;
import java.util.*;

class Main {
	private static final String plainText = "the quick brown fox jumps over the lazy dog";
	private static int alphabet[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String line;
		br.readLine();
		while (t-- > 0) {
			ArrayList<String> text = new ArrayList<>();
			boolean solution = false;
			while ((line = br.readLine()) != null && line.length() > 0) {
				text.add(line);
				if(!solution)
					solution = encryption(line);
			}
			if(solution)
				sb.append(decryption(text));
			else
				sb.append("No solution.\n");
			sb.append('\n');
		}
		System.out.print(sb);
	}
	
	public static boolean encryption(String text) {
		if(plainText.length() != text.length())
			return false;
		alphabet = new int[26];
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i) == ' '){
				if (plainText.charAt(i) != ' ')
					return false;
			}
			else {
				int index = text.charAt(i) - 'a';
				if (alphabet[index] == 0)
					alphabet[index] = plainText.charAt(i);
				else if (alphabet[index] != plainText.charAt(i))
					return false;
			}
		}
		return true;
	}
	
	public static StringBuilder decryption(ArrayList<String> text) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.size(); i++){
			for (int j = 0; j < text.get(i).length(); j++){
				if(text.get(i).charAt(j) == ' ')
					sb.append(' ');
				else
					sb.append((char) alphabet[text.get(i).charAt(j) - 'a']);
				}
			sb.append('\n');
		}
		return sb;
	}
}