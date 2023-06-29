import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String a = "", b = "";
		
		while (sc.hasNextLine()) {
			
			List<Character> temp = new ArrayList<Character>();
			
			a = sc.nextLine();
			b = sc.nextLine();
			
			char[] ac = new char[a.length()];
			char[] bc = new char[b.length()];
			
			for (int i = 0; i < a.length(); i++) {
				ac[i] = a.charAt(i);
			}
			for (int i = 0; i < b.length(); i++) {
				bc[i] = b.charAt(i);
			}
			
			for (int i = 0; i < b.length(); i++) {
				for (int j = 0; j < a.length(); j++) {
					if (ac[j] == bc[i]) {
						temp.add(bc[i]);
						ac[j] = 0;
						break;
					}
				}
			}
			
			temp.sort(null);
			
			for (int i = 0; i < temp.size(); i++) {
				System.out.printf("%c", temp.get(i));
			}
			
			System.out.println();
		}
	}
}