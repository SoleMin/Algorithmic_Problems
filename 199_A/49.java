import java.io.IOException;
import java.util.Scanner;


public class A199 {
	static int n[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		new A199().solve();
	}

	public void solve() throws IOException {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
//		int f1 = 0;
//		int f2 = 1;
//		
//		while(true){
//			int t = f1 + f2;
//			if(t == N){
//				//guaranteed that n is a Fibonacci number
//				break;
//			}
//			f1 = f2;
//			f2 = t;
//		}
		System.out.println("0 0 " + N );
	}
}
