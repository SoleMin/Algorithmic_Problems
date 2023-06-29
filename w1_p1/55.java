import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()){
			String s = input.nextLine();
			int count = 0;
			int words =0;
			for ( int i = 0 ; i<s.length();i++){
				
				if((i==0 && (s.charAt(i) != ' ' && s.charAt(i) != '\t')) || i > 0 && (s.charAt(i-1)==' '||s.charAt(i-1) == '\t') && (s.charAt(i) != ' '&& s.charAt(i) != '\t'))
					words++;
				
				
				if(s.charAt(i)==' ' || s.charAt(i)=='\t'){
					count++;
				}
			}
			System.out.println(s.length()-count+" "+words);
		}

	}
}