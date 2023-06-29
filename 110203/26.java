import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int cnt = 0;
		
		for (int i = 0 ; i < n; i++) {
			cnt = 0;
			int simul = scan.nextInt();
			int partyN = scan.nextInt();
			int [] party = new int [partyN];
			
			for (int j = 0; j < partyN; j ++)
				party[j] = scan.nextInt();
			
			for (int j = 1; j <= simul; j++) {
				if (!(j % 7 == 6 || j % 7 == 0)) {
					for (int l = 0; l < party.length; l++) {
						if (j % party[l] == 0) {
							cnt ++; break;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
}