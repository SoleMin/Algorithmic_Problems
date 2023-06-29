import java.util.Scanner;
class Main {
	public static void main(String[] args) {
	 	Scanner sc= new Scanner(System.in);
		char [] KeyBoard= new char[] {'`','1','2','3','4','5','6','7','8','9','0','-','=',
																 'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
																 'A','S','D','F','G','H','J','K','L',';','\'',
																 'Z','X','C','V','B','N','M',',','.','/'};
		char no=' ';
		
		while(sc.hasNextLine()) {
			
			String S= sc.nextLine();
			char [] newS= new char[S.length()];
			
			for(int i=0; i<S.length(); i++) {
				for(int j=0; j<47; j++) {
					if(S.charAt(i)==KeyBoard[j]) {
						newS[i]= KeyBoard[j-1];
					}
					else if(S.charAt(i)==' ') {
						newS[i]= no;
					}
				}
			}
			for(int i=0; i<S.length(); i++)
				System.out.print(newS[i]);
			
			System.out.println();
			
		}
		
	}
}