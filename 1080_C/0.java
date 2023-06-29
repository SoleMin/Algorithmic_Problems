import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int t;
        t = in.nextInt();
        //t = 1;

        while (t > 0) {
            solver.call(in,out);
            t--;
        }
        out.close();
    }

    static class TaskA {
        public void call(InputReader in, PrintWriter out) {
            int n, m;
            n = in.nextInt();
            m = in.nextInt();

            int[] white = new int[4];
            int[] black = new int[4];

            for (int i = 0; i < 4; i++) {
                white[i] = in.nextInt();
            }

            for (int i = 0; i < 4; i++) {
                black[i] = in.nextInt();
            }

            int c;
            long a, b, w, d;
            a = (long) n*(long)m;
            w = (a+1)/2;
            b = a/2;

            c = white[1];

            d = white[2] - white[0] +1;
            d= d * (long)( white[3] - white[1] +1);

            if (c % 2 == 0) {
                if(white[0]%2==0){
                    b-=d/2;
                    w+=d/2;

                }
                else{
                    b-=(d+1)/2;
                    w+=(d+1)/2;
                }

            }
            else{
                if(white[0]%2==0){
                    b-=(d+1)/2;
                    w+=(d+1)/2;

                }
                else{
                    b-=d/2;
                    w+=d/2;
                }
            }

            c = black[1];

            d = black[2] - black[0] +1;
            d= d * (long) (black[3] - black[1] +1);

            if (c % 2 == 0) {
                if(black[0]%2==0){
                    //white
                    w-=(d+1)/2;
                    b+=(d+1)/2;

                }
                else{
                    //black
                    w-=d/2;
                    b+=d/2;
                }

            }
            else{
                if(black[0]%2==0){
                    w-=d/2;
                    b+=d/2;
                }
                else{
                    w-=(d+1)/2;
                    b+=(d+1)/2;

                }
            }


            int row1 , row2, column1 , column2;

            if(black[1]<=white[1]){
                if(black[3]<white[1]){
                    out.println(w+" "+b);
                    return;
                }
                row1 = white[1];
            }
            else{
                if(black[1]>white[3]){
                    out.println(w+" "+b);
                    return;
                }
                row1 = black[1];

            }
            row2 = Math.min(black[3] ,white[3]);

            if(black[0]<=white[0]){
                if(black[2]<white[0]){
                    out.println(w+" "+b);
                    return;
                }
                column1 = white[0];
            }
            else {
                if(black[0]>white[2]){
                    out.println(w+" "+b);
                    return;
                }
                column1 = black[0];
            }
            column2 = Math.min(black[2] ,white[2]);

            d = row2 - row1 +1;
            d = d*(long)(column2 - column1 +1);

            if (row1 % 2 == 0) {
                if(column1 % 2==0){
                    //white
                    w-=d/2;
                    b+=d/2;

                }
                else{
                    //black
                    w-=(d+1)/2;
                    b+=(d+1)/2;
                }

            }
            else{
                if(column1%2==0){
                    w-=(d+1)/2;
                    b+=(d+1)/2;
                }
                else{
                    w-=d/2;
                    b+=d/2;

                }
            }

            out.println(w+" "+b);

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
        int a,b;

        public answer(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(answer o) {
            return o.a - this.a;
        }
    }

    static class arrayListClass {
        ArrayList<Integer> arrayList2 ;

        public arrayListClass(ArrayList<Integer> arrayList) {
            this.arrayList2 = arrayList;
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