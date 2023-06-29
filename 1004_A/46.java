import java.util.*;
import java.io.*;
public class Main {
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);PrintWriter pw = new PrintWriter(System.out);
        int n=sc.nextInt(),d=sc.nextInt();int[] a = new int[n];int ans=2;a[0]=sc.nextInt();
        for (int i=1;i<n;i++){
            a[i]=sc.nextInt();
            if (a[i]-a[i-1]==2*d)ans++;
            else if (a[i]-a[i-1]>2*d)ans+=2;
        }
        System.out.println(ans);
    }
}