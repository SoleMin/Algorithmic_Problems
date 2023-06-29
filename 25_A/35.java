import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		new A().run();
	}
	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ce = 0;
		int co = 0;
		int le = 0;
		int lo = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x % 2 == 0) {
				ce++;
				le = i + 1;
			} else {
				co++;
				lo = i + 1;
			}
		}
		System.out.println(ce == 1 ? le : lo);
	}

}
