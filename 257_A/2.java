import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Sockets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt(), m = in.nextInt(), socket = in.nextInt();
        int[] filters = new int[n];

        for (int i = 0; i < n; i++ ) {
            filters[i] = in.nextInt();
        }
        Arrays.sort(filters);

        int result = 0, index = n - 1;
        while ( m > socket && index >= 0) {
            socket += filters[index] - 1;
            result += 1;
            index -= 1;
        }

        out.println(m > socket ? -1 : result);
        out.close();
    }
}
