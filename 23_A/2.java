import java.util.Scanner;


public class P23A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(F(input));
	}
	
	
	static int F(String string){
		int ans =0;
		for (int i = 0; i < string.length(); i++) {
			for (int j = 1; j < string.length()-i; j++) {
				String s = string.substring(i, i+j);
				int a=string.indexOf(s);
				int b=string.lastIndexOf(s);
				if ( a >= 0 && b >=0 && a !=b)  ans =Math.max(ans, s.length());
			}
		}
		return ans;
	}
}
