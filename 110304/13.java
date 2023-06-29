import java.util.*;

class Main {

	static boolean isAlpha(char ch) {
		return 'a' <= ch && ch <= 'z';
	}
	
	static boolean equalsToHint(String line, String hint) {
		boolean[] shown = new boolean[26];
		char[] alpha = new char[26];
		
		Arrays.fill(shown, false);
		
		for (int i=0; i < line.length(); i++) {
			if (isAlpha(line.charAt(i))) {
				int index = line.charAt(i) - 'a';
				if (!shown[index]) {
					shown[index] = true;
					alpha[index] = hint.charAt(i);
				} else {
					if (alpha[index] != hint.charAt(i)) { // 이전과 다른 글자
						return false;
					}
				}
			}
		}
			
		return true;
	}
	
	static char[] getTable(String encoded, String hint) {
		char[] table = new char[26];
		for(int i=0; i < encoded.length(); i++) {
			if (isAlpha(encoded.charAt(i))) {
				int index = encoded.charAt(i) - 'a';
				table[index] = hint.charAt(i);
			}
		}
		return table;
	}
	
	public static void main(String[] args) throws Exception {
		
		String hint = "the quick brown fox jumps over the lazy dog";
		String encodedHint = "";
		
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine());
		input.nextLine();
		
		for (int i=0; i < tc; i++) {
			if (0 < i) System.out.println();
			
			List<String> list = new ArrayList<>();
			boolean found = false;
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				if (line == null || line.length() == 0) break;
				list.add(line);
				
				if (found) continue;
				
				if (line.length() == hint.length()) {
					if (equalsToHint(line, hint)) {
						encodedHint = line;
						found = true;
					}
				}
			}
			
			if (found) {
				char[] table = getTable(encodedHint, hint);
				for(String line: list) {
					for (int j=0; j < line.length(); j++) {
						if (isAlpha(line.charAt(j))) {
							int index = line.charAt(j) - 'a';
							System.out.print(table[index]);
						} else {
							System.out.print(line.charAt(j));
						}
					}
					System.out.println();
				}
			} else {
				System.out.println("No solution.");
			}
		}
		input.close();
	}
}