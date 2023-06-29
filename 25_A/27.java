import java.util.Locale;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] number = new String[n];
		sc.nextLine();
		String l = sc.nextLine();
		number = l.split(" ");
		int oe = 1;
		if((Integer.valueOf(number[0])%2 +
		   Integer.valueOf(number[1])%2 +
		   Integer.valueOf(number[2])%2) > 1) {
			oe = 0;
		}
		for(int i=0;i<n;i++) {
			if((Integer.valueOf(number[i])%2)==oe) {
				System.out.println(i+1);
				break;
			}
		}
	}
}