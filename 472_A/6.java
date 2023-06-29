import java.util.Scanner;


public class Composite {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n == 12)
			System.out.println("4 8");
		
		else if (n % 2 == 1)
			System.out.println((n - 9) + " 9");
		
		else
			System.out.println((n - 6) + " 6");
	}
}
