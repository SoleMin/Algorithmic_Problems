import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @zhendeaini6001
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		Scanner in = new Scanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
     class Pair{
		public int a;
		public int b;
		public Pair(int a, int b) {
			// TODO Auto-generated constructor stub
			this.a = a;
			this.b = b;
		}
	}

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();  --k;
        ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 1; i <= n; ++i){
            int num = in.nextInt();
            int pen = in.nextInt();
			Pair t = new Pair(num, pen);
		    list.add(t);
        }
        Collections.sort(list, new Comparator<Pair>(){
				public int compare(Pair o1, Pair o2){
					if (o1.a != o2.a){
						return (o2.a - o1.a);
					}
					return (o1.b - o2.b);
				}
		});

        int res = 1;
        Pair compare = list.get(k);
        int i = k - 1;
        while (i >= 0){
            Pair t = list.get(i);
            if (t.a == compare.a && t.b == compare.b){
                --i;
                ++res;
                continue;
            }else{
                break;
            }
        }
       i = k + 1;
        while (i < list.size()){
            Pair t = list.get(i);
            if (t.a == compare.a && t.b == compare.b){
                ++res; ++i;
                continue;
            }else{
                break;
            }
        }
        out.println(res);
       return;
    }
}

