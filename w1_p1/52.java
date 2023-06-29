import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNextLine()) {
			
			String input = scan.nextLine();
			int chr = 0;
			int word = 0;
			int s = input.length();
			char[] chr_list = input.toCharArray();
						
			for (int i = 0; i < s; i++) {
				
				if ((i == 0 && (chr_list[i] != ' ' && chr_list[i] != '\t')) || (i > 0 && (chr_list[i-1] == ' ' || chr_list[i-1] == '\t') && (chr_list[i] != ' ' && chr_list[i] != '\t'))) {
					word += 1;
				}
				if (chr_list[i] != '\t' && chr_list[i] != ' ') {
					chr += 1;
				}
				
			}
			
			System.out.println(chr + " " + word);
			
		}
				
	}
	
}