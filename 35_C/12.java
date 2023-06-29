import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashSet;

public class FireAgain {

	Point[] coordinate;
	Queue<Point> q = new LinkedList<>();
	// HashSet<Point> vis = new HashSet<>();
	boolean[][] vis;
	PrintStream out;
	int x, y;

	boolean distance(Point word1, Point word2) {

		if (Math.abs(word1.x - word2.x) == 1 && Math.abs(word1.y - word2.y) == 1)
			return false;

		if (Math.abs(word1.x - word2.x) == 1 && word1.y == word2.y)
			return true;

		if (word1.x == word2.x && Math.abs(word1.y - word2.y) == 1)
			return true;

		return false;
	}

	void bfs(Point s) {

		while (!q.isEmpty()) {
			s = q.poll();

			Point p = new Point();
			p.x = s.x - 1;
			p.y = s.y;

			if (p.x >= 1 && p.x <= x && p.y >= 1 && p.y <= y) {
				if (!vis[p.x][p.y]) {
					vis[p.x][p.y] = true;
					q.add(p);

				}
			}

			p = new Point();
			p.x = s.x + 1;
			p.y = s.y;

			if (p.x >= 1 && p.x <= x && p.y >= 1 && p.y <= y) {
				if (!vis[p.x][p.y]) {
					vis[p.x][p.y] = true;
					q.add(p);

				}
			}

			p = new Point();
			p.x = s.x;
			p.y = s.y - 1;

			if (p.x >= 1 && p.x <= x && p.y >= 1 && p.y <= y) {
				if (!vis[p.x][p.y]) {
					vis[p.x][p.y] = true;
					q.add(p);

				}
			}
			
			p = new Point () ;
			p.x = s.x ;
			p.y = s.y + 1;
			
			if (p.x >= 1 && p.x <= x && p.y >= 1 && p.y <= y) {
				if (!vis[p.x][p.y]) {
					vis[p.x][p.y] = true ;
					q.add(p);
					
				}
			}

			if (q.size() == 0)
				out.print(s.x + " " + s.y);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		FireAgain F = new FireAgain();
		 Scanner in = new Scanner (new FileReader("input.txt"));
		 F.out = new PrintStream(new File("output.txt"));
	
		F.x = in.nextInt();
		F.y = in.nextInt();

		int l = 0;
		F.vis = new boolean[F.x + 1][F.y + 1];

		int k = in.nextInt();

		for (int i = 0; i < k; i++) {
			Point P = new Point(in.nextInt(), in.nextInt());
			F.vis[P.x][P.y] = true; // add in set
			F.q.add(P);
		}

		F.bfs(F.q.peek());

	}

}
