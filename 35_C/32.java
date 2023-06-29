import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main{
	public static void main(String[] args)throws FileNotFoundException,IOException{
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		File outFile = new File("output.txt");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));

		int w = sc.nextInt();
		int h = sc.nextInt();
		boolean[][] map = new boolean[h+1][w+1]; //false:�u�G�v���ĂȂ�

		int x = -1, y = -1;
		Queue<Point> open = new LinkedList<Point>();
		int k = sc.nextInt();
		for(int i=0;i<k;i++){
			int tx = sc.nextInt();
			int ty = sc.nextInt();
			map[ty][tx] = true;
			x = tx;
			y = ty;
			open.add(new Point(x,y));
		}

		int dx[] = {1,-1,0,0};
		int dy[] = {0,0,1,-1};
		while(!open.isEmpty()){
			Point p = open.poll();

			for(int i=0;i<4;i++){
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if(nx>0 && nx<=w && ny>0 && ny<=h && !map[ny][nx]){
					map[ny][nx] = true;
					x = nx;
					y = ny;
					open.add(new Point(nx,ny));
				}
			}
		}

		pw.println(x + " " + y);

		pw.close();
	}
}
