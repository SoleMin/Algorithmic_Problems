import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int casenum = sc.nextInt();
		
		for(int i = 0; i < casenum; i++) {
			int dayn = sc.nextInt();
			int partyn = sc.nextInt();
			int[] partyh = new int[dayn];
			int[] tempn = new int[dayn];
			int count = 0;
			
			for (int k = 0; k < partyn; k++) {
				partyh[k] = sc.nextInt();
				for (int j = 0; j < dayn; j++) {
					if (j % partyh[k] == partyh[k] - 1) {
						if (tempn[j] == 1) {
							continue;
						} else {
							tempn[j] = 1;
						}
					}
				}
			}
			for (int q = 0; q < dayn; q++) {
				if (tempn[q] == 1) {
					if (q % 7 == 5 || q % 7 == 6) {
						continue;
					} else {
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}