import java.util.Scanner;

public class _0194Coins {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		if(k%n==0) {
			System.out.println(k/n);
		}
		else {
			System.out.println(k/n+1);
		}
		
	}

}
