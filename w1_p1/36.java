import java.util.*;
class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			String str = sc.nextLine().trim();
			int words = 0;
			int word = 0;

			StringTokenizer st = new StringTokenizer(str, " |\t");
			words = st.countTokens();
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != ' ' && str.charAt(i) != '\t')
					word += 1;
			}
			System.out.println(word + " " + words);
		}
	}
}