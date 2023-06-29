import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String[] pangram = "the quick brown fox jumps over the lazy dog".split("");
		
		int testcase = Integer.parseInt(input.nextLine());
		String newline = input.nextLine();
		for(int i=0; i<testcase; i++) {
			ArrayList<String> list = new ArrayList<>();
			char[] alphabet = new char[26];
			
			while(input.hasNextLine()) {
				String str = input.nextLine();
				if(str.equals("")) break;
				
				boolean initialize = false;
				String[] strArr = str.split("");
				int[] checkArr = new int[26];
				if(strArr.length == pangram.length) {
					for(int j=0; j<pangram.length; j++) {
						if(pangram[j].equals(" ") && !strArr[j].equals(" ")) {
							initialize = true;
							break;
						}
						if(!pangram[j].equals(" ") && strArr[j].equals(" ")) {
							initialize = true;
							break;
						}
						if(pangram[j].equals(" ")) continue;
						
						int index = pangram[j].charAt(0) - 'a';
						int check = strArr[j].charAt(0) - 'a';
						if(alphabet[index] == '\0') {
							if(checkArr[check] == 0) {
								alphabet[index] = strArr[j].charAt(0);
								checkArr[check]++;
							}
							else {
								initialize = true;
								break;
							}
						}
						else
							if(alphabet[index] != strArr[j].charAt(0)) {
								initialize = true;
								break;
							}
					}
					list.add(str);
					
					if(initialize)
						for(int j=0; j<26; j++)
							alphabet[j] = '\0';
				}
				else
					list.add(str);
			}
			/*
			for(char s : alphabet)
				System.out.print(s);
			System.out.println();*/
			
			if(alphabet[0] == '\0')
				System.out.println("No solution.");
			else {
				for(int j=0; j<list.size(); j++) {
					String str = list.get(j);
					for(int k=0; k<str.length(); k++) {
						if(str.charAt(k) == ' ')
							System.out.print(" ");
						else {
							for(int l=0; l<26; l++) {
								if(alphabet[l] == str.charAt(k)) {
									char letter = (char)(l + 'a');
									System.out.print(letter);
								}
							}
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}