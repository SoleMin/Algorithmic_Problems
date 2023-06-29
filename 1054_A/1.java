import java.util.Scanner;

public class _0344ElevatororStairs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int start=sc.nextInt();
		int destination=sc.nextInt();
		int pos=sc.nextInt();
		int sT=sc.nextInt();
		int eT=sc.nextInt();
		int dT=sc.nextInt();
		
		if(Math.abs(start-destination)*sT >=((3*dT)+(Math.abs(pos-start)*eT)+(Math.abs(start-destination)*eT))) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");

		}
		
		
		
		
	}

}
