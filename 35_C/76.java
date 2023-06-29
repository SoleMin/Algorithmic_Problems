import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FireAgain {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new FileReader("input.txt"));
		String s = r.readLine();
		String[] sp = s.split(" ");
		n = new Integer(sp[0]);
		m = new Integer(sp[1]);
		boolean[][] v = new boolean[n][m];
		r.readLine();
		s = r.readLine();
		sp = s.split(" ");
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < sp.length; i += 2) {
			v[new Integer(sp[i]) - 1][new Integer(sp[i + 1]) - 1] = true;
			q.add(new Integer(sp[i]) - 1);
			q.add(new Integer(sp[i + 1]) - 1);
		}

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int lx = -1;
		int ly = -1;
		while (!q.isEmpty()) {
			int x = q.remove();
			int y = q.remove();
			lx = x;
			ly = y;
			for (int i = 0; i < dy.length; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (valid(nx, ny) && !v[nx][ny]) {
					v[nx][ny] = true;
					q.add(nx);
					q.add(ny);
				}
			}
		}
		lx++;
		ly++;
		BufferedWriter wr=new BufferedWriter(new FileWriter("output.txt"));
		wr.write(""+lx + " " + ly);
		wr.newLine();
		wr.close();
		
	}

	private static boolean valid(int nx, int ny) {
		return nx >= 0 && nx < n && ny >= 0 && ny < m;
	}
}
