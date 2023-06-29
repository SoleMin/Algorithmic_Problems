import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s =sc.nextLine().split(" ");
		long a = Long.parseLong(s[0]);
		long b = Long.parseLong(s[1]);

		long count = 0;
		long c = 0;

		while(true) {
			count += (a / b);
			c = a % b;
			a = b;
			b = c;
			if(c == 0) {
				break;
			}
		}
		System.out.println(count);
	}
}
						 			    		 	   	    					