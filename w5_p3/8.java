import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	public static int[] compute_Next (String P) {
		
		int size = P.length();
		int[] array = new int[size];
		char[] p = new char[size];
		p = P.toCharArray();
		
		int k=0;
		for (int i=1; i<size; i++) {
			while (k>0 && p[i] != p[k])
				k = array[k-1];
			if (p[i]==p[k])
				array[i] = ++k;
		}
		return array;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String T = scanner.nextLine();
		String P = scanner.nextLine();
	
		List<Integer> KMP = new ArrayList<>();
		int[] next = compute_Next(P);
		
		char[] t = T.toCharArray();
		char[] p = P.toCharArray();
		int T_size = T.length();
		int P_size = P.length();
		int k=0;
		
		for (int i=0; i<T_size; i++) {
			while (k>0 && t[i] != p[k])
				k = next[k-1];
			if (t[i]==p[k]) {
				if (k==(P_size-1)) {
					KMP.add(i-P_size+2);
					k = next[k];
				}
				else
					k++;
			}
		}
		
		System.out.println(KMP.size());
		for (int i=0; i<KMP.size(); i++) {
			System.out.print(KMP.get(i) + " ");
		}
	}
}