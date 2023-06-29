import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Two {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int t;
        //t = in.nextInt();
        t = 1;
        while (t > 0) {
            solver.call(in,out);
            t--;
        }
        out.close();
    }

    static class TaskA {
        public void call(InputReader in, PrintWriter out) {
            int n = 14 ;
            long c , a = Long.MIN_VALUE, b = 0;
            long[] arr = new long[n];
            long[] array = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            for (int i = 0; i < n; i++) {
                array[i] = arr[i];
            }

            for (int i = 0; i < n; i++) {
                array[i]=0;
                if(arr[i]==0)
                    continue;

                if(arr[i]<14){
                    for (int j = 1; j <= arr[i]; j++) {
                        array[(i+j)%14] ++;
                    }

                }
                else {
                    c = arr[i]/14;
                    for (int j = 1; j <= n; j++) {
                        array[(i+j)%14] +=c;
                    }
                    c = arr[i]%14;
                    for (int j = 1; j <= c; j++) {
                        array[(i+j)%14] ++;
                    }

                }

                for (int j = 0; j < 14; j++) {
                    if(array[j]%2==0){
                        b+=array[j];
                    }
                }

                for (int j = 0; j < n; j++) {
                    array[j] = arr[j];
                }

                a = Math.max(a,b);
                b = 0;

            }

            out.println(a);

        }
    }

    static class answer implements Comparable<answer>{
        int a, b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(answer o) {
            return this.a - o.a;
        }
    }


    static long lcm(long a , long b){
        return (a/gcd(a,b)) *b;
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b,  a % b);
    }


    static final Random random=new Random();
    static void shuffleSort(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {

            int a=random.nextInt(n), temp=arr[a];
            arr[a]=arr[i];
            arr[i]=temp;

        }

        Arrays.sort(arr);

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }

    }
}