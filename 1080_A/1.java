import java.util.Scanner;

public class _0217PetyaandOrigami {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int sum=(((n*2)/k)+((n*5)/k)+((n*8)/k));
		if((n*8)%k!=0) {
			sum++;
		}
		if((n*5)%k!=0) {
			sum++;
		}
		if((n*2)%k!=0) {
			sum++;
		}
		
		System.out.println(sum);
	}

}
