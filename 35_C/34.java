import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FireAgain {

	Point coordinate;
	Queue<Point> q = new LinkedList<Point>();
	int m, n;
	boolean[][] arr;
	PrintStream out ;

	void bfs(Point start) {

		while (!q.isEmpty()) {
			Point front = q.poll();
			Point p = new Point();

			p.x = front.x - 1;
			p.y = front.y;
			if (p.x >= 1 && p.x <= n && p.y <= m && p.y >= 1) {
				if (!arr[p.x][p.y]) {
					arr[p.x][p.y] = true;
					q.add(p);
				}
			}
			
			p = new Point();
			p.x = front.x + 1;
			p.y = front.y;
			if (p.x >= 1 && p.x <= n && p.y <= m && p.y >= 1)
				if (!arr[p.x][p.y]) {
					arr[p.x][p.y] = true;
					q.add(p);
				}

			p = new Point() ;
			p.x = front.x;
			p.y = front.y + 1;
			if (p.x >= 1 && p.x <= n && p.y <= m && p.y >= 1)
				if (!arr[p.x][p.y]) {
					arr[p.x][p.y] = true;
					q.add(p);
				}

			p = new Point() ;
			p.x = front.x;
			p.y = front.y - 1;
			if (p.x >= 1 && p.x <= n && p.y <= m && p.y >= 1)
				if (!arr[p.x][p.y]) {
					arr[p.x][p.y] = true;
					q.add(p);
				}

			if (q.size() == 0)
				out.print(front.x + " " + front.y);
		}
	}

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		FireAgain fa = new FireAgain();
		Scanner Scan = new Scanner(new FileInputStream("input.txt"));
		fa.out = new PrintStream(new File("output.txt"));
		fa.n = Scan.nextInt();
		fa.m = Scan.nextInt();
		int k = Scan.nextInt();
		fa.arr = new boolean[2001][2001];

		for (int i = 0; i < k; i++) {
			fa.coordinate = new Point();
			fa.coordinate.x = Scan.nextInt();
			fa.coordinate.y = Scan.nextInt();
			fa.q.add(fa.coordinate);
			fa.arr[fa.coordinate.x][fa.coordinate.y] = true;
		}

		fa.bfs(fa.q.peek());

	}

}