import java.util.Scanner;

public class d {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		
		int[] vals = new int[size];
		long[] cum = new long[size];
		for(int i=0; i<size; i++){
			vals[i] = in.nextInt();
			
			int c = 0;
			for(int j=0; j<i; j++)
				if(vals[j] > vals[i]) c++;
			
			if(i != 0) cum[i] = cum[i-1]+c;
			else cum[i] = c;
		}
		
		long tot = cum[size-1];
		int q = in.nextInt();

		int[] nv = new int[size];
		for(int i=0; i<q; i++)
		{
			int l = in.nextInt()-1;
			int r = in.nextInt()-1;
			int n = (r-l);
			
			long add = (n*(n+1))/2 - (cum[r] - cum[l]);
			tot = tot - (cum[r] - cum[l]) + add;
			
			if(tot%2 == 0)
				System.out.println("even");
			else
				System.out.println("odd");
			
//			for(int j=0; j<=r-l; j++)
//				nv[l+j] = vals[r-j];
//			
//			for(int j=0; j<=r-l; j++)
//				vals[l+j] = nv[l+j];
			
		}
	}
}
/*
3
1 2 3
2
1 2
2 3

4
1 2 4 3
4
1 1
1 4
1 4
2 3

*/
