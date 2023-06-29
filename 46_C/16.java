import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws Exception{
		StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		in.nextToken();
		int n = (int)in.nval;
		in.nextToken();
		String st = in.sval;
		char[] a = new char[n];
		for (int i = 0; i<n; i++)
			a[i] = st.charAt(i);
		int kH = 0;
		int kT = 0;
		for (int i =0; i<n; i++)
			if (a[i] == 'T') kT++;
			else kH++;
		int kol = 0;
		int min = Integer.MAX_VALUE;
		int poz;
		
		for (int i=0; i<n; i++)
		{
			kol = 0;
			if (a[i] == 'T') {
				for (int j = 0; j<kT; j++){
					poz = (i+j)%n;
					if (a[poz] == 'H') kol++;
				}
				if (kol < min) min = kol;
			}
			else {
				for (int j = 0; j<kH; j++){
					poz = (i+j)%n;
					if (a[poz] == 'T') kol++;
				}
				if (kol < min) min = kol;
			}
		}
		out.print(min);
		out.flush();
	}
}
