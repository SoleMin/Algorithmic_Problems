import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static class Fast {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Fast scn = new Fast();
    public static void main(String args[]) throws Exception {
        int t = 1;
        while(t-- > 0){
            func();
        }
        bw.close();
    }
    private static void func() throws Exception{
        int n = scn.nextInt();
        int m = scn.nextInt();
        int k = scn.nextInt();
        int[][] hori = new int[n][m - 1];
        int[][] vert = new int[n - 1][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m - 1; j++){
                hori[i][j] = scn.nextInt();
            }
        }

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                vert[i][j] = scn.nextInt();
            }
        }
        if(k % 2 != 0){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    bw.append(-1 + " ");
                }
                bw.append("\n");
            }
            return;
        }
        int[][][] strg = new int[n][m][k + 1];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         for(int x = 0; x < k; x++)
        //     }
        // }
        int[][] answer = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                answer[i][j] = steps(i, j, hori, vert, k, strg);
            }
        }
      for(int i = 0; i < n; i++){
          for(int j = 0; j < m; j++){
              bw.append(answer[i][j] + " ");
          }
          bw.append("\n");
      }
       
    }

    static int steps(int x, int y, int[][] hori, int[][] vert, int k, int[][][] strg){
        if(k == 0)
            return 0;
        if(strg[x][y][k] != 0)
            return strg[x][y][k];
        int xmove = x;
        int ymove = y;
        int ans = 0;
        int val = Integer.MAX_VALUE;
        if(y < hori[0].length){
            xmove = x;
            ymove = y + 1;
            val = Math.min(val, steps(xmove, ymove, hori, vert, k - 2, strg) + (2 * hori[x][y]));
        }
        if(y - 1 >= 0){
            xmove = x;
            ymove = y - 1;
            val = Math.min(val, steps(xmove, ymove, hori, vert, k - 2, strg) + (2 * hori[x][y - 1]));
            // val = hori[x][y - 1];
        }
        if(x - 1 >= 0){
            xmove = x - 1;
            ymove = y;
            val = Math.min(val, steps(xmove, ymove, hori, vert, k - 2, strg) + (2 * vert[x - 1][y]));
            // val = vert[x - 1][y];
        }
        if(x < vert.length){
            xmove = x + 1;
            ymove = y;
            val = Math.min(val, steps(xmove, ymove, hori, vert, k - 2, strg) + (2 * vert[x][y]));
            // val = vert[x + 1][y];
        }
        // System.out.println(val);
        ans += val;
        return strg[x][y][k] = ans;
    }
}

