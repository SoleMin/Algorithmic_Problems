import java.util.Scanner;


public class C344C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long count = a / b, c;
		a = a % b;
		while(true){
			if (a <= 1 || b <= 1) break;
			c = b - a;
			b = a;
			a = c;
			count++;
			if (a > b) count += a / b;
			a = a % b;
		}
		if (b > 1) count += b;
		System.out.println(count);	
		sc.close();
	}

}
