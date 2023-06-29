import java.io.*;
import java.util.*;

class Main {
	static int [] F_pos = new int [100];
	static int [][] Dis = new int [500][500];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fs, is;
		sc.nextLine();
		while (n-- != 0) {
			fs = sc.nextInt();
			is = sc.nextInt();
			int [] fb = new int [is]; 
			for (int i = 0; i < fs; i++)  {
				F_pos[i] = sc.nextInt() -1;
				fb[F_pos[i]] = 1;
			}
			
			for (int i = 0; i < is; i++) {
				for (int j = 0; j < is; j++) 
					Dis[i][j] = 999999;
				Dis[i][i] = 0;
			}
			
			String line;
			sc.nextLine();
			line = sc.nextLine();
			while (line.length() != 0) {
				String [] tmp = line.split(" ");
				int x = Integer.parseInt(tmp[0]) -1;
				int y = Integer.parseInt(tmp[1]) -1;
				int L = Integer.parseInt(tmp[2]);
				Dis[x][y] = L;
				Dis[y][x] = L;
				
				if (!sc.hasNextLine()) break;
				line = sc.nextLine();
			}
			
			floyd(is);
			
			
			int [] s_l = new int [is];
			int max_s_l = 0;
			
			for (int i = 0; i < is; i++) {
				s_l[i] = 999999;
				for (int j = 0; j < is; j++) {
					if (fb[j] == 1)
						s_l[i] = Math.min(s_l[i], Dis[i][j]);
				}
				max_s_l = Math.max(max_s_l, s_l[i]);
			}
			
			int ans = 0;
			int max = 999999;
			for (int i = 0; i < is; i++) {
				int now = 0;
				for (int j = 0; j < is; j++) {
					now = Math.max(now, Math.min(s_l[j], Dis[i][j]));
				}
				
				if (now < max) {
					max = now;
					ans = i + 1;
				}
			}
			
			System.out.println(ans);
			if (n != 0)
				System.out.println();
		}
	}
	
	public static void floyd(int n) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (Dis[i][k] + Dis[k][j] < Dis[i][j])
						Dis[i][j] = Dis[i][k] + Dis[k][j];
				}
			}
		}
	}
}