import java.io.*;
import java.util.*;

public class cf35c {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] seen = new int[n][m];
		for(int i=0; i<n; i++)
			Arrays.fill(seen[i], -1);
		Queue<Integer> q = new LinkedList<Integer>();
		int k = in.nextInt();
		for(int i=0; i<k; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			q.add(x);
			q.add(y);
			q.add(0);
			seen[x][y] = 0;
		}
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			int t = q.poll();
			for(int i=0; i<dx.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if(seen[nx][ny] != -1) continue;
				seen[nx][ny] = t+1;
				q.add(nx);
				q.add(ny);
				q.add(t+1);
			}
		}
		int best=-1,x=0,y=0;
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				if(seen[i][j] > best) {
					best = seen[i][j];
					x = i+1;
					y = j+1;
				}
		out.println(x + " " +y);
		out.close();
	}
}
