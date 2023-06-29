import java.util.*;
import java.io.*;

public class InversionCounting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(sc.nextLine());
		int inversions = 0;
		int[] data = new int[n];
		
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		for(int i = 0; i < n; i ++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(data[i] > data[j])
					inversions++;
			}
		}
		//false = 0, true = 1;
		boolean inversiontype = (inversions % 2 == 1);
		
		int n2 = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n2; i++) {
			st = new StringTokenizer(sc.nextLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int parity = (b-a)*(b - a + 1)/2;
			if(parity % 2 == 0) {
				if(inversiontype)
					pw.println("odd");
				else
					pw.println("even");
			} else {
				inversiontype = !inversiontype;
				if(inversiontype)
					pw.println("odd");
				else
					pw.println("even");
			}
		}
		pw.close();
	}
}
