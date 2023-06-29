import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int caseN = sc.nextInt();
		for (int c = 0; c < caseN; c++) {
			sc.nextLine();
			int n = sc.nextInt();
			int [] t = new int[n];
			int [] s = new int[n];
			int [] sort = new int[n];
			for (int i = 0; i < n; i++) {
				t[i] = sc.nextInt();
				s[i] = sc.nextInt();
				sort[i] = i;
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n -i; j++) {
					if (t[sort[j]] * s[sort[j+1]] > t[sort[j+1]] * s[sort[j]]) {
						int tmp = sort[j];
						sort[j] = sort[j+1];
						sort[j+1] = tmp;
					}
				}
			}
			if (c > 0) System.out.println();
			for (int j = 0; j < n -1; j++) System.out.print(sort[j] + 1 + " ");
			System.out.println(sort[n-1] + 1 + " ");
		}
	}
}