import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class A {

    static StreamTokenizer st;
    static class Sort implements Comparable<Sort> {
        int val;
        public int compareTo(Sort o) {
            return this.val-o.val;
        }
    }
    public static void main(String[] args) throws IOException{
        st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        Sort[]a = new Sort[n+1];
        int[]b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new Sort();
            a[i].val = nextInt();
            b[i] = a[i].val;
        }
        Arrays.sort(a, 1, n+1);
        int k1 = 0, k2 = 0;
        for (int i = 1; i <= n; i++) {
            if (b[i] != a[i].val) {
                if (k1==0)
                    k1 = i;
                else if (k2==0)
                    k2 = i;
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (k1==0)
            System.out.println("YES");
        else if (k2==0)
            System.out.println("NO");
        else {
            if (b[k1]==a[k2].val && b[k2]==a[k1].val)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        pw.close();
    }

    private static int nextInt() throws IOException{
        st.nextToken();
        return (int) st.nval;
    }

}
