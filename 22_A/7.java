import java.util.*;
import java.io.*;
public class Main{

        BufferedReader in;
        StringTokenizer str = null;
        PrintWriter out;

        private String next() throws Exception{
                if (str == null || !str.hasMoreTokens())
                        str = new StringTokenizer(in.readLine());
                return str.nextToken();
        }
        
        private int nextInt() throws Exception{
                return Integer.parseInt(next());
        }
        
        private long nextLong() throws Exception{
                return Long.parseLong(next());
        }
        
        private double nextDouble() throws Exception{
                return Double.parseDouble(next());
        }

        public void run() throws Exception{
                in = new BufferedReader(new InputStreamReader(System.in));//new FileReader();
                out = new PrintWriter(System.out);//new File();
                int n = nextInt();
                HashSet<Integer> hs = new HashSet<Integer>();
                for(int i=0;i<n;i++) hs.add(nextInt());
                if (hs.size() == 1){
                  out.println("NO");
                  out.close();
                  return;
                }
                int a[] = new int[hs.size()];
                int yk = 0;
                for(int i:hs) a[yk++] = i;
                Arrays.sort(a);
                out.println(a[1]);
                out.close();
        }

        public static void main(String args[]) throws Exception{
                new Main().run();
        }
}
 
