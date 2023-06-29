//7_4
import java.util.Scanner;
import java.util.TreeMap;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<Long,Long> golomb = new TreeMap<>();
		golomb.put(1L, 1L);
		
		while(true) {
			long N = scan.nextLong();
			long sum = golomb.get(1L);
			if(N==0) break;
			scan.nextLine();
			long i;
			for(i=2L;i<=N;i++) {
				golomb.put(i,1L+golomb.get(i-golomb.get(golomb.get(i-1))));
				sum+=golomb.get(i);
			if(sum>=N) break;
			}
			
			System.out.println(i);
			/*a[1]=1;
			for(int i=1;i<N;i++)
				a[i+1]=1+a[i+1-a[a[i]]];
			System.out.println(a[N]);*/
			
		}
	}
}
//a(1)=1;
//a(n+1)=1+a(n+1-a(a(n))).