import java.util.Scanner;


public class main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int a = n / 2;
		int b = n - a;
		
		if (n % 2 == 0) {
			if (a % 2 == 1) {
				a++;
				b--;
			}
			
			System.out.println(a + " " + b);
		} else {
			if (a % 2 == 1) {
				int x = a;
				a = b;
				b= x;
			}
			
			if (b % 3 == 0) {
				
			} else if (b % 3 == 1) {
				a-=2;
				b+=2;
			} else {
				a+=2;
				b-=2;
			}
			
			System.out.println(a + " " + b);
		}
	}
}
