import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		String answer = "the quick brown fox jumps over the lazy dog";
		for (int t = 0; t < Testcase; t++) {
			int index = 0;
			int foxLine = 0;
			boolean is_fox=false;
			String[] input = new String[100];
			Map<Character, Character> map = new HashMap<>();
			while (scan.hasNextLine()) {
				input[index++] = scan.nextLine();
				if (input[index - 1].equals("")) {
					index--;
					break;
				}
			}

			for (int i = 0; i < index; i++) { // (the quick brown fox jumps over the lazy dog) find
				map=new HashMap<>();
				char a = 'a';
				int cnt = 26;
				//for (int j = 0; j < input[i].length(); j++) {
				//	if (a > 'z')
				//		break;
				//	if (!input[i].contains(String.valueOf(a)))
				//		break;
				//	else {
				//		a = (char) (a + 1);
				//		cnt++;
				//	}
				//}
				if (input[i].length() == answer.length() && cnt == 26 && input[i].charAt(3) == ' '
						&& input[i].charAt(9) == ' ' && input[i].charAt(15) == ' ' && input[i].charAt(19) == ' '
						&& input[i].charAt(25) == ' ' && input[i].charAt(30) == ' ' && input[i].charAt(34) == ' '
						&& input[i].charAt(39) == ' ') {
					foxLine = i;
					int j =0;
					for (j = 0; j < answer.length();j++) {
						//if (index == 0)
						//	break;
						if (answer.charAt(j) == ' ')
							continue;
						if(!map.containsKey(input[foxLine].charAt(j))) {
							map.put(input[foxLine].charAt(j), answer.charAt(j));
						}
						else {
							if(map.get(input[foxLine].charAt(j))!=answer.charAt(j)) break;
						}
					}
					if(j==answer.length()){is_fox=true; break;}
				}
			}

			if(!is_fox) System.out.println("No solution.");
			else{
				for (int i = 0; i < index; i++) {
					for (int j = 0; j < input[i].length(); j++) {
						if (input[i].charAt(j) == ' ')
							System.out.print(' ');
						else
							System.out.print(map.get(input[i].charAt(j)));
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}// xnm ceuob lrtzv ita hegfd tsmr xnm ypwq ktj
	// aaa aaaaa aaaaa aaa aaaaa aaaa aaa aaaa aaa
	// aaaa aaa
