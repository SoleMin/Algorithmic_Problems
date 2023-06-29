import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			
			int[] temp1 = new int[26]; // 26개 - 모든 입력은 알파벳 소문자
			int[] temp2 = new int[26];
			
			Arrays.fill(temp1,0); // 0으로 초기화 
			Arrays.fill(temp2,0);
			
			String line1 = input.nextLine();
			if (line1 == null || line1.length() == 0) break;
			
			String line2 = input.nextLine();
			if (line2 == null || line2.length() == 0) break;
			
			for (int i=0; i < line1.length(); i++) {
				int index = line1.charAt(i) - 'a'; // 'b' - 'a' = 1
				temp1[index]++;
			}
			
			for (int i=0; i < line2.length(); i++) {
				int index = line2.charAt(i) - 'a';
				temp2[index]++;
			}
			
			String result = "";
			for (int i=0; i < 26; i++) {
				char ch = (char)(i + 'a');
				for (int j=0; j < temp1[i] && j < temp2[i]; j++) {
					result += ch;
				}
			}
			System.out.println(result);
		}
		input.close();
	}
}