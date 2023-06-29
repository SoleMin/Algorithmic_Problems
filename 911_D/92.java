import java.io.*;
import java.util.StringTokenizer;

public class D911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[i] < num[j]) {
                    count++;
                }
            }
        }

        boolean ans = count % 2 == 0;
        for (int m = Integer.parseInt(br.readLine()); m-- > 0; ) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (((r - l + 1) / 2) % 2 != 0) {
                ans = !ans;
            }
            out.println(ans ? "even" : "odd");
        }
        out.close();
    }
}
