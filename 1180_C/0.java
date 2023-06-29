import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class First {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        //int a = 1;
        int t;
        //t = in.nextInt();
        t = 1;
        while (t > 0) {
            //out.print("Case #"+(a++)+": ");
            solver.call(in,out);
            t--;
        }
        out.close();

    }

    static class TaskA {
        public void call(InputReader in, PrintWriter out) {
            int n, q;
            n = in.nextInt();
            q = in.nextInt();

            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
            Map<Integer, answer> map = new HashMap<>();

            int a, b, c = 0, max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                a = in.nextInt();
                arrayDeque.add(a);
                max = Math.max(max, a);
            }

            for (int i = 0; i < n; i++) {
                if(arrayDeque.getFirst() == max){
                    break;
                }

                a = arrayDeque.removeFirst();
                b = arrayDeque.removeFirst();

                map.put(i+1,new answer(a,b));
                c = i+1;

                if(a>b){
                    arrayDeque.addFirst(a);
                    arrayDeque.addLast(b);
                }
                else{
                    arrayDeque.addFirst(b);
                    arrayDeque.addLast(a);
                }

            }

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = arrayDeque.removeFirst();
            }

            long m;
            for (int i = 0; i < q; i++) {
                m = in.nextLong();

                if(m<=c){
                    out.println(map.get((int)m).a +" "+map.get((int)m).b);
                }
                else{
                    m-=c;
                    m = m%(n-1);
                    if(m==0){
                        m = n-1;
                    }
                    out.println(max+" "+arr[(int)m]);
                }


            }

        }
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }

    static class answer implements Comparable<answer>{
        int a;
        int b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(answer o) {
            return this.a - o.a;
        }
    }

    static class answer1 implements Comparable<answer1>{
        int a, b, c;

        public answer1(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;

        }

        @Override
        public int compareTo(answer1 o) {
            return this.a - o.a;
        }
    }

    static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static void sort(long[] a) {
        ArrayList<Long> l=new ArrayList<>();
        for (long i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static final Random random=new Random();

    static void shuffleSort(int[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
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