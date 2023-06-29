import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class First {
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

            int n;
            char[] arr = in.next().toCharArray();
            char[] array = in.next().toCharArray();
            n = arr.length;

            int a = 0;
            int j = 0;

            for (int i = 0; i < n; i++,j++) {
                if(arr[i]=='0' && array[j]=='0' &&  j+1<n && array[j+1]=='0'){
                    a++;
                    arr[i]='X';
                    array[j]='X';
                    array[j+1]='X';
                }
                else if(arr[i]=='0' && array[j]=='0' &&  i+1<n && arr[i+1]=='0'){
                    a++;
                    arr[i]='X';
                    array[j]='X';
                    arr[i+1]='X';
                }
                else if(i+1<n && arr[i+1]=='0' && array[j]=='0' &&  j+1<n && array[j+1]=='0'){
                    a++;
                    arr[i+1]='X';
                    array[j]='X';
                    array[j+1]='X';
                }
                else if(i+1<n && arr[i+1]=='0' && arr[i]=='0' &&  j+1<n && array[j+1]=='0'){
                    a++;
                    arr[i+1]='X';
                    arr[i]='X';
                    array[j+1]='X';
                }
            }

            out.println(a);
        }
    }

    static class answer implements Comparable<answer> {
        int a, b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(answer o) {
            if(o.a==this.a){
                return this.b- o.b;
            }
            return o.a - this.a;
        }
    }




    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final Random random=new Random();

    static void shuffleSort(int[] arr) {
        int n=arr.length;
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
        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}