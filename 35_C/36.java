import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner read = new Scanner(new FileInputStream(new File("input.txt")));
		PrintWriter out = new PrintWriter(new File("output.txt"));
		int n = read.nextInt(), m = read.nextInt(), k = read.nextInt(), tree[][] = new int[n][m], a[] = new int[k],
				b[] = new int[k], x = 0, y = 0, max = -1, d = 0;

		for (int i = 0; i < k; i++) {
			a[i] = read.nextInt() - 1;
			b[i] = read.nextInt() - 1;	
			tree[a[i]][b[i]] = 0;
		}
		for(int i = 0; i < n; i++){
			Arrays.fill(tree[i], Integer.MAX_VALUE);
		}
		for (int o = 0; o < k; o++) {
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					d = Math.abs(a[o] - i) + Math.abs(b[o] - j);
					if(d < tree[i][j])
						tree[i][j] = d;
				}
			}
		}
		for(int i = 0; i<n; i++){
			for(int j = 0; j < m ; j ++){
				if(tree[i][j] > max){
					max=  tree[i][j];
					x=  i;
					y = j;
				}
			}
		}
		out.println(x + 1 + " " + (y + 1));
		out.close();
	}

}
