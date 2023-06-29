import java.util.Scanner;

public class sub {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int num = in.nextInt();
		while(num-->0) {
			int a = in.nextInt();
			int b = in.nextInt();

			int res = 0;

			while(a!=0 && b!=0) {
				if(a>=b) {
					res += a/b;
					a %= b;
				} else {
					res += b/a;
					b %= a;
				}
			}
			System.out.println(res);
		}
	}
}