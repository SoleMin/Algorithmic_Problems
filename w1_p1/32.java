import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String s = input.nextLine();
			boolean isBlank = true;
			int words = 0, letters = 0;
			
			for(int i=0; i < s.length(); i++) {
				if(s.charAt(i) != ' ' && s.charAt(i) != '\t') {
					if(isBlank){
						words++;
						isBlank = false;
					}
					letters++;
				}
				else
					isBlank = true;
			}
			
			System.out.println(letters + " " + words);
		}
		
		input.close();
	}
}