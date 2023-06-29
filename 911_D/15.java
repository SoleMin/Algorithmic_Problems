//package educational35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {
	
	public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer tok = null;

	public static void main(String args[]) throws IOException {
		tok = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(tok.nextToken());
		
		int tab[] = new int[n]; 
		tok = new StringTokenizer(in.readLine());
		for (int i=0; i<n; i++)
			tab[i] = Integer.parseInt(tok.nextToken());
		
		int inversions = countInversions(tab);
		boolean isOdd = inversions % 2 == 1;
		
		tok = new StringTokenizer(in.readLine());
		int k = Integer.parseInt(tok.nextToken());
		
		int start, end, len;
		
		for (int i=0; i<k; i++)	{
			tok = new StringTokenizer(in.readLine());
			start = Integer.parseInt(tok.nextToken());
			end = Integer.parseInt(tok.nextToken());
			
			len = (end - start + 1) % 4;
			if (len == 2 || len ==3)
				isOdd = !isOdd;
			
			out.println(isOdd ? "odd" : "even");
		}
		
		out.close();
		
	}
	
	private static int countInversions(int tab[]) {
		int n = tab.length;
		int auxTab[] = new int[n+1];
		return _countInversions(tab, 0, n, auxTab);
	};
	
	private static int _countInversions(int tab[], int start, int end, int auxTab[]) {
		//indices from start to end; but values from start+1 to end+1 !!
		if (start+1 >= end)
			return 0;
		
		int mid = (start + end) / 2;
		int lowerFound = 0;
		int higherFound = 0;
		
		int count = 0;
		
		for (int i=start; i<end; i++){
			if (tab[i] < mid+1){
				count += higherFound;
				auxTab[start+lowerFound] = tab[i];
				lowerFound++;
			} else {
				auxTab[mid + higherFound] = tab[i];
				higherFound++;
			}
		}
		
		for (int i=start; i<end; i++)
			tab[i] = auxTab[i];
		
		count += _countInversions(tab, start, mid, auxTab);
		count += _countInversions(tab, mid, end, auxTab);
		
		return count;
	}
	
	
	
}
