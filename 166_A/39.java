import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author codeKNIGHT
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
	public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n=in.nextInt(),k=in.nextInt()-1,i;
        scores a[]=new scores[n];
        for(i=0;i<n;i++)
            a[i]=new scores(in.nextInt(),in.nextInt());
        Arrays.sort(a);
        
        int c=1;
        for(i=k-1;i>=0;i--)
        {
            if(a[i].p==a[k].p&&a[i].t==a[k].t)
                c++;
            else break;
        }
        for(i=k+1;i<n;i++)
        {
            if(a[i].p==a[k].p&&a[i].t==a[k].t)
                c++;
            else break;
        }
        out.println(c);

	}
    class scores implements Comparable<scores>
    {
        int p,t;
        public scores(int p,int t)
        {
            this.p=p;
            this.t=t;
        }
        public int compareTo(scores a)
        {
            if(a.p>this.p)
                return 1;
            if(a.p==this.p&&a.t<this.t)
                return 1;
            return -1;
        }
    }
}

