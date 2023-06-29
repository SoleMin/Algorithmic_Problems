import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _0292GameShopping {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] c = new int[n];
		int count=0;
		for(int i=0;i<n;i++) {
			c[i]=sc.nextInt();
		}
		Queue<Integer> wallet = new LinkedList<>();
		for(int i=0;i<m;i++) {
			wallet.add(sc.nextInt());
		}
		
		for(int i=0;i<n&&wallet.size()>0;i++) {
			if(c[i]<=wallet.peek()) {
				count++;
				wallet.poll();
			}
		}
		System.out.println(count);
	}

}
