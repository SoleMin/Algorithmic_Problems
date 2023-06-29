
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class A{

    public static void main(String args[]){
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        boolean change = false;
        if(a > b){
            int t = a;
            a = b;
            b = t;
            change = true;
        }
        boolean[] inb = new boolean[n];
        int[] numbers = new int[n];
        TreeMap<Integer, Integer> num = new TreeMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            num.put(in.nextInt(), i);
        }
        boolean hasAns = true;
        while(!num.isEmpty()){
            Entry<Integer, Integer> last = num.lastEntry();
            int key = last.getKey();
            if(num.containsKey(a - key)){
                num.remove(key);
                num.remove(a - key);
            } else if(num.containsKey(b - key)){
                inb[num.get(key)] = true;
                inb[num.get(b - key)] = true;
                num.remove(key);
                num.remove(b - key);
            } else{
                hasAns = false;
                break;
            }
        }
        if(hasAns){
            out.println("YES");
            for(int i = 0; i < n && !change; i++){
                if(inb[i]){
                    out.print("1");
                } else{
                    out.print("0");
                }
                if(i != n - 1){
                    out.print(" ");
                }
            }
            for(int i = 0; i < n && change; i++){
                if(inb[i]){
                    out.print("0");
                } else{
                    out.print("1");
                }
                if(i != n - 1){
                    out.print(" ");
                }
            }
        } else{
            out.println("NO");
        }
        out.close();
    }

    static class FastScanner{
        private BufferedReader reader;

        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine(){
            try{
                return reader.readLine();
            } catch(IOException e){
                e.printStackTrace();
                return null;
            }
        }

        public String next(){
            while(tokenizer == null || !tokenizer.hasMoreTokens()){
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch(IOException e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}
