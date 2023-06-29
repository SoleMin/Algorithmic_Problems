    import java.awt.Point;
import java.io.*;
    import java.text.*;
    import java.util.*;
import java.util.regex.*;

    public class Main{
        static class Run implements Runnable{
            //TODO parameters
            final boolean consoleIO = true;
            final String inFile = "input.txt";
            final String outFile = "output.txt";
            
            Pair<Double,Double>[] p;
            int n, t;
            
            int find() {
                int count = 2;
                
                for(int i = 0; i < n-1; ++i) {
                    double dif = p[i+1].a-p[i].b;
                    int comp = Double.compare(dif,t);
                    
                    if(comp==0)
                        count+=1;
                    else
                        if(comp>0)
                            count+=2;
                }
                
                return count;
            }
            
            @Override
            public void run() {
                n = nextInt();
                t = nextInt();
                
                p = new Pair[n];
                for(int i = 0; i < n; ++i) {
                    int x = nextInt()+1000;
                    int a = nextInt();
                    
                    double h = a/(double)2;
                    p[i] = new Pair<Double,Double>(x-h,x+h);
                }
                
                Arrays.sort(p, new PComparator());
                print(find());
                close();
            }
            
            class PComparator implements Comparator<Pair<Double,Double>> {
                @Override
                public int compare(Pair<Double, Double> o1,
                        Pair<Double, Double> o2) {
                    
                    return Double.compare(o1.a, o2.a);
                }
            }
        //=========================================================================================================================
            BufferedReader in;
            PrintWriter out;
            StringTokenizer strTok;
           
            Run() {
                if (consoleIO) {
                    initConsoleIO();
                }
                else {
                    initFileIO();
                }
            }
           
            void initConsoleIO() {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
           
            void initFileIO() {
                try {
                    in = new BufferedReader(new FileReader(inFile));
                    out = new PrintWriter(new FileWriter(outFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            void close() {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           
            int nextInt() {
                return Integer.parseInt(nextToken());
            }
           
            double nextDouble() {
                return Double.parseDouble(nextToken());
            }
           
            float nextFloat() {
                return Float.parseFloat(nextToken());
            }
           
            long nextLong() {
                return Long.parseLong(nextToken());
            }
           
            String nextLine() {
                try {
                    return in.readLine();
                } catch (IOException e) {
                    return "__NULL";
                }
            }
           
            boolean hasMoreTokens() {
                return (strTok == null) || (strTok.hasMoreTokens());
            }
           
            String nextToken() {
                while (strTok == null || !strTok.hasMoreTokens()) {
                    String line;
                    try {
                        line = in.readLine();
                        strTok = new StringTokenizer(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
               
                return strTok.nextToken();
            }
           
            void cout(Object o){
                System.out.println(o);
            }
           
            void print(Object o) {
                out.write(o.toString());
            }
            
            void println(Object o) {
                out.write(o.toString() + '\n');
            }
           
            void printf(String format, Object... args) {
                out.printf(format, args);
            }
           
            String sprintf(String format, Object... args) {
            return MessageFormat.format(format, args);
        }
        }
       
        static class Pair<A, B> {
            A a;
            B b;
           
            A f() {
                return a;
            }
           
            B s() {
                return b;
            }
           
            Pair(A a, B b) {
                this.a = a;
                this.b = b;
            }
           
            Pair(Pair<A, B> p) {
                a = p.f();
                b = p.s();
            }
            
            @Override
            public String toString() {
                return a+" "+b;
            }
        }
       
        public static void main(String[] args) throws IOException {
            Run run = new Run();
            Thread thread = new Thread(run);
            thread.run();
        }
    }