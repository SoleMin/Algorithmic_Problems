import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class Beta97B {

    static Scanner in;
    static StreamTokenizer st;
    static int n;
    static int[] a;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        // in = new Scanner(System.in);
        st = new StreamTokenizer(new InputStreamReader(System.in));
        n = nextInt();
        a = new int[n];
        int ind = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = nextInt();
            if (a[i] > max) {
                max = a[i];
                ind = i;
            }
        }
        if (max == 1) {
            a[0] = 2;
        } else {
            a[ind] = 1;
        }
        Arrays.sort(a);
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }

    private static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
}
