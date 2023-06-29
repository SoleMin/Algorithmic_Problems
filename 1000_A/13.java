import java.util.*;
import java.lang.*;
import java.io.*;

public class CodehorsesTShirt {

    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader();
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        Task.solve(in, out);
        out.close();
    }

    static class Task {

        public static void solve(FastReader in, PrintWriter out) {
            int n = in.nextInt();
            HashMap<String , Integer> hm1 = new HashMap<>();
            HashMap<String , Integer> hm2 = new HashMap<>();

            for(int i=0;i<n;i++){
                String val = in.next();
                if(hm1.containsKey(val)){
                    hm1.put(val, hm1.get(val)+1);
                }else{
                    hm1.put(val,1);
                }
            }

            for(int i=0;i<n;i++){
                String val = in.next();
                if(hm1.containsKey(val)){
                    int x = hm1.get(val);
                    if(x==1){
                        hm1.remove(val);
                    }else{
                        hm1.put(val,hm1.get(val)-1);
                    }
                }else{
                    if(hm2.containsKey(val)){
                        hm2.put(val, hm2.get(val)+1);
                    }else{
                        hm2.put(val,1);
                    }
                }
            }
            int ans = 0;
            for(Map.Entry<String , Integer> row: hm1.entrySet()){
                ans += row.getValue();
            }
            System.out.println(ans);

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
