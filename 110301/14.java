import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		String str;
		
		while(input.hasNextLine()) {
			str = input.nextLine();
			System.out.println(encodeStr(str));
		}
		input.close();
	}
	
	public static String encodeStr(String str) {
		StringBuilder sb = new StringBuilder();
		String encode = "1234567890-=QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,./";
		
		for(int i=0; i < str.length(); i++)
			if(str.charAt(i) == ' ')
				sb.append(" ");
			else
				sb.append(encode.charAt(encode.indexOf(str.charAt(i)) - 1));
		return sb.toString();
	}
}