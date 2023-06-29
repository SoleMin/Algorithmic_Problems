import java.util.*;

public class Main {

	public static void main(String[] args) {

		// long start = System.currentTimeMillis();
		// long end = System.currentTimeMillis();
		// System.out.println(" Execution time was "+(end-start)+" ms.");

		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int a[] = new int[n];
		int b[] = new int[n];
		for(int i = 0;i<n;i++){
			a[i]=kb.nextInt();
			b[i]=a[i];
		}
		Arrays.sort(a);
		int count = 0;
		for(int i=0;i<n;i++){
			if(a[i]!=b[i])count++;
		}
		if(count<=2)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
