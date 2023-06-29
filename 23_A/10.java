import java.util.Scanner;


public class prob1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int n = s.length();
		int i = n-1;
		CharSequence temp;
		for(i = n-1; i > 0; i--)
			for(int j = 0 ; j <= n-i; j++)
			{
				temp = s.subSequence(j, i+j);
				if( s.substring(j+1, n).contains(temp) || s.substring(0, j+i-1).contains(temp))
				{
					System.out.println(i);
					return;
				}
			}
		System.out.println(0);
	}
}
