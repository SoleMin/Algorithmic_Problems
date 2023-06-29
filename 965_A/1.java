import java.util.Scanner;

public class _0342PaperAirplanes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int n=sc.nextInt();
		int s=sc.nextInt();
		int p=sc.nextInt();
	    int a=n%s!=0?(n/s+1)*k:(n/s)*k;
	    System.out.format("%d\n",a%p!=0?a/p+1:a/p);

	
	}
	
}
