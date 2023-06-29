
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a,b;
		if (n%2==0) {
			a = 4;
		}else{
			a = 9;
		}
		b = n - a;
		System.out.println(a + " " + b);
	}

}
