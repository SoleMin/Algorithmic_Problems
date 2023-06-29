import java.util.Scanner;

public class FirstNoSuccess {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), n = in.nextInt();
		
		in.close();
		System.out.println(c <= Math.min(a, b) && a - c + b < n ? n - (a - c + b) : -1);
	}
}
