import java.util.Arrays;
import java.util.Scanner;


public class Success {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a = scan.nextInt();
		int b=scan.nextInt();
		int[] t=new int[n];
		for(int i=0;i<n;i++)
		{
			t[i]=scan.nextInt();
		}
		Arrays.sort(t);
		System.out.println(t[b]-t[b-1]);
		}
		

	}

