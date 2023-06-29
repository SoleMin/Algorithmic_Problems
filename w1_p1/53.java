import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(sc.hasNextLine()) {
			String s= sc.nextLine();
			int words= 0, letters=0;
			
			for(int i=0; i<s.length(); i++) {
				if(i==0 && s.charAt(i)!=' ' && s.charAt(i)!='\t') 
					words++;
				else if(i>0 && s.charAt(i)!=' ' && s.charAt(i)!='\t' && (s.charAt(i-1)==' ' || s.charAt(i-1)=='\t'))
					words++;
				
				if(s.charAt(i)!=' '&& s.charAt(i)!='\t') 
					letters++;
			}
			System.out.println(letters+" "+words);
		}
	}
}