import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			
			if(s1.length() <= 0 || s2.length() <= 0)
				break;
			
			int[] arrays1 = new int[26];
			int[] arrays2 = new int[26];
			
			for(int i = 0; i < s1.length(); i++)
				arrays1[s1.charAt(i)-97]++;
			for(int i = 0; i < s2.length(); i++)
				arrays2[s2.charAt(i)-97]++;
			
			for(int i = 0; i < 26; i++){
				if(arrays1[i] > 0 && arrays2[i] > 0){
					if(arrays1[i] >= arrays2[i])
						for(int k = 0; k < arrays2[i]; k++)
							System.out.print((char)(i+97));
					else
						for(int k = 0; k < arrays1[i]; k++)
							System.out.print((char)(i+97));
				}
			}
			
			System.out.println();
		}
	}
}