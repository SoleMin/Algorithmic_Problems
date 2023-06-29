import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		char[] charArray;
		String str1, str2;
		
		while(true) {
			str1 = input.nextLine();
			if(str1.equals(""))
				break;
			str2 = input.nextLine();
			
			charArray = equalChar(str1, str2).toCharArray();
			
			Arrays.sort(charArray);
			for(int i=0; i < charArray.length; i++)
				System.out.print(charArray[i]);
			System.out.println();
			
			if(input.hasNextLine() != true)
				break;
		}
		input.close();
	}
	
	public static String equalChar(String s1, String s2) {
		StringBuilder sb = new StringBuilder();
		boolean[] check = new boolean[s2.length()];
		
		for(int i=0; i < s2.length(); i++)
			check[i] = false;
		
		
		for(int i=0; i < s1.length(); i++)
			for(int j=0; j < s2.length(); j++) 
				if(check[j] == false && s1.charAt(i) == s2.charAt(j)) {
					sb.append(s1.charAt(i));
					check[j] = true;
					break;
				}
		return sb.toString();
	}
}