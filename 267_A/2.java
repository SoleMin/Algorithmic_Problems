import java.io.*;
import java.util.StringTokenizer;

public class A267 {

    static  public  long _solve(long a,long b){
        long result = -1;
        while(a!=0 && b!=0){
            if(a>b){
                result +=(a/b);
                a = a%b;
            }
            else{
                result +=(b/a);
                b = b%a;
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long a,b;
        while(t-- > 0){
            a = in.nextLong();
            b = in.nextLong();
            System.out.println(_solve(a,b));
        }
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
