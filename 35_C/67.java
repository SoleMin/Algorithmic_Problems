import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<ArrayList<Integer>> fire = new ArrayList<ArrayList<Integer>>();
		while (k-- != 0) {
			ArrayList<Integer> t = new ArrayList<Integer>();
			t.add(sc.nextInt());
			t.add(sc.nextInt());
			fire.add(t);
		}
		
		int maxI = 0, maxJ = 0, maxManhatten = -1;
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++){
				int curManhatten = Integer.MAX_VALUE;
				for(int u = 0; u < fire.size(); u++)
					curManhatten = Math.min(curManhatten, manhatten(i, j, fire.get(u).get(0), fire.get(u).get(1)));
				
				if(curManhatten > maxManhatten){
					maxManhatten = curManhatten;
					maxI = i;
					maxJ = j;
				}
			}
		
		out.print(maxI + " " + maxJ);
		out.flush();
		out.close();
	}

	private static int manhatten(int i, int j, Integer a, Integer b) {
		return Math.abs(i - a) + Math.abs(j - b);
	}
}
