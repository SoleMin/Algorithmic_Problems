import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()){
			String wordsAndBlanks = input.nextLine();
			int letters = 0;
			int blanks = 1;
			
			if(wordsAndBlanks.charAt(0) == ' ' || wordsAndBlanks.charAt(0) == '\t')
				blanks = 0;
			
			for(int i=0; i<wordsAndBlanks.length()-1; i++){
				if(wordsAndBlanks.charAt(i) == ' ' || wordsAndBlanks.charAt(i) =='\t'){
					if(wordsAndBlanks.charAt(i+1) != ' ' && wordsAndBlanks.charAt(i+1) != '\t'){
						blanks++;
					}
					else
						continue;
				}
				else{
					letters++;
				}				
			}
			
			if(wordsAndBlanks.charAt(wordsAndBlanks.length()-1) != ' ' && wordsAndBlanks.charAt(wordsAndBlanks.length()-1) != '\t')
				letters++;
			
			System.out.println(letters + " " + blanks);
		}
		input.close();
	}
}