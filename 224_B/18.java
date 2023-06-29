        import java.io.*;
        import java.math.BigInteger;
        import java.util.*;
        
        public class Main {
         
            static final double eps = 1e-8;
            
            public static void main(String[] args) throws IOException {
                try {
                    
                       int n = nextInt();
                       int k = nextInt();
                       int[] a = new int[n];
                       int[] d = new int[n];
                       int[] dr = new int[n];
                       boolean used[] = new boolean[100001];
                       a[0] = nextInt();
                       used[ a[0] ] = true;
                       d[0] = 1;
                       for(int i = 1; i < n; i++)
                       {
                           a[i] = nextInt();
                           if(!used[ a[i] ])
                           {
                               used[ a[i] ] = true;
                               d[i] = d[i - 1] + 1;
                           }
                           else
                           {
                               d[i] = d[i - 1];
                           }
                       }
                       Arrays.fill(used, false);

                       
                       int r = Arrays.binarySearch(d, k);
                       
                       if(r < 0)
                       {
                           pw.println("-1 -1");
                           return;
                       }
        
                       while( r > 0 && d[r] == d[r - 1] )
                           r--;
                       
                       used[ a[r] ] = true;
                       dr[r] = 1;
                       for(int i = r - 1; i >= 0; i--)
                       {
                           if(!used[ a[i] ])
                           {
                               used[ a[i] ] = true;
                               dr[i] = dr[i + 1] + 1;
                           }
                           else
                           {
                               dr[i] = dr[i + 1];
                           }
                       }
        
                       
                       
                       int l = 0;
        
                       while(l < n - 1 && dr[l] == dr[l + 1] && r - l >= k)
                           l++;
                       
                       
                       pw.println(l + 1 + " " + (r + 1));
                }
                finally {
                    pw.close();
                }
            }
        
        
            static Scanner sc = new Scanner(System.in);
            static PrintWriter pw = new PrintWriter(System.out);
            static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            static StringTokenizer st ;
            static int nextInt() throws IOException {
                in.nextToken();
                return (int) in.nval;
            }
            static long nextLong() throws IOException {
                in.nextToken();
                return (long) in.nval;
            }
            static double nextDouble() throws IOException {
                in.nextToken();
                return in.nval;
            }
            static String next() throws IOException {
                in.nextToken();
                return in.sval;
            }
            static void outArray(int[] O) {
                for(int i = 0; i < O.length - 1; i++)
                    pw.print(O[i] + " ");
                pw.println(O[O.length - 1]);
            }
        }