import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FireAgain {

	Scanner in;
	PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new FireAgain().run();

	}
	
	void run() throws IOException {
		in = new Scanner(new FileReader("input.txt"));
        out = new PrintWriter(new FileWriter("output.txt"));

		solve();

		in.close();
		out.close();
	}

	private void solve() {
		// TODO Auto-generated method stub
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] burn = new int[N + 1][M + 1];
		int K = in.nextInt();
		
		int[] qx = new int[N * M];
		int[] qy = new int[N * M];
		
		int first = 0;
		int last = 0;
		for (int i = 0; i < K; i ++){
			qx[last] = in.nextInt();
			qy[last] = in.nextInt();
			burn[qx[last]][qy[last]] = 1;
			last ++;
		}
		
		while (first < last){
			int x = qx[first];
			int y = qy[first];
			if (x - 1 > 0 && burn[x - 1][y] == 0){
				burn[x - 1][y] = 1;
				qx[last] = x - 1;
				qy[last] = y;
				last ++;
			}
			if (y - 1 > 0 && burn[x][y - 1] == 0){
				burn[x][y - 1] = 1;
				qx[last] = x;
				qy[last] = y - 1;
				last ++;
			}
			if (x + 1 <= N && burn[x + 1][y] == 0){
				burn[x + 1][y] = 1;
				qx[last] = x + 1;
				qy[last] = y;
				last ++;
			}
			if (y + 1 <= M && burn[x][y + 1] == 0){
				burn[x][y + 1] = 1;
				qx[last] = x;
				qy[last] = y + 1;
				last ++;
			}
			first ++;
		}
		
		out.println(qx[last - 1] + " " + qy[last - 1]);
	}
}
