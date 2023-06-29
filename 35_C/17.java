//package c;
import java.util.*;
import java.io.*;

public class Main {

	int n,m;
	int d[][];
	Queue<int[]> q = new LinkedList<int[]>();
	int cur[];
	
	public void run() throws Exception{
		Scanner in = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		n = in.nextInt();
		m = in.nextInt();
		int k = in.nextInt();
		d = new int[n][m];
		for(int i=0;i<n;i++) Arrays.fill(d[i], Integer.MAX_VALUE/2);
		for(int i=0;i<k;i++){
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			d[x][y] = 0;
			q.add(new int[]{x,y});
		}
		
		
		while(q.size() > 0){
			cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			add(x, y+1);
			add(x+1, y);
			add(x-1, y);
			add(x, y-1);
		}
		int max = 0;
		int x = 0;
		int y = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if (max < d[i][j]){
					max = d[i][j];
					x = i;
					y = j;
				}
		out.println((x+1) + " " + (y+1));
		out.close();
	}
	
	private void add(int x, int y){
		if (x < 0 || y < 0) return;
		if (x >=n || y >=m) return;
		if (d[x][y] > d[cur[0]][cur[1]] + 1){
			d[x][y] = d[cur[0]][cur[1]] + 1;
			q.add(new int[]{x,y});
		}
	}
	
	public static void main(String[] args) throws Exception{
		new Main().run();
	}

}
