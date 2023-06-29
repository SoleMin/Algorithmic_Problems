import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String in_str;
		
		while(sc.hasNextLine()) {
			in_str = sc.nextLine();
			
			for(int i=0; i<in_str.length(); i++) {
				correct(in_str.charAt(i));
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static void correct(char s) {
		//13, 13, 11, 10개
		char line0[] = { '`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=' };
		char line1[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'};
		char line2[] = { 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\'' };
		char line3[] = { 'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/' };
		
		char corr = ' ';
		
		if(s == ' ') {
			System.out.print(" ");
			return;
		}
		
		for(int i=1; i<13; i++) {
			if(line0[i]==s) { corr=line0[i-1]; break; }
			else if(line1[i]==s) { corr=line1[i-1]; break; }
			else if(line2[i]==s) { corr=line2[i-1]; break; }
			else if(line3[i]==s) { corr=line3[i-1]; break; }
		}
		
		System.out.print(corr);
	}
}