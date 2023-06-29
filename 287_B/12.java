import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n=in.nextLong();
        long k=in.nextInt();
        if(n==1){
            out.println(0);
            return;
        }
        long max=k*(k-1)/2+1;
        if(max<n){
            out.println("-1");
            return;
        }

        long low=1,high=k-1;
        long ans=k-1;
        while (low<=high){
            long mid=(low+high)/2;
            long val=mid*mid-mid*(2*k-1)+2*n-2;
            if(val>0){
                low=mid+1;
            }
            else {
                ans=mid;
                high=mid-1;
            }
        }
        out.println(ans);

    }
}

