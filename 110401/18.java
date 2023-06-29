import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int caseN = sc.nextInt();
		int x, y, l, r, pivot;
		
		for (int i = 0; i < caseN; i ++) {
			int n = sc.nextInt();
			int [] family = new int [n];
			for (int j = 0; j < n; j++) {
				family[j] = sc.nextInt();
			}
			l = 0;
			r = n -1;
			do {
				pivot = family[l];
				x = l;
				y = r;
				while (x <= y) {
					while (x <= r && family[x] <= pivot) x++;
					while (y > l && family[y] >= pivot) y--;
					if (x < y) {
						int tmp = family[x];
						family[x] = family[y];
						family[y] = tmp;
					}
				}
				family[l] = family[y];
				family[y] = pivot;
				if (y < n/2) l = y+1;
				else r = y - 1;
			} while (y != n/2);
			int sum = 0;
			for (x = 0; x < y; x++) sum += (pivot - family[x]);
			for (x = y + 1; x < n; x++) sum += (family[x] - pivot);
			System.out.println(sum);
		}
	}
}