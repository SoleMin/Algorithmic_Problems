import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Naldbah implements Runnable {

    boolean isLocalMode = false;

    public static void main(String[] args) {
        new Naldbah().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(getReader());
            tokenizer = null;
            writer = new PrintWriter(System.out);
            //do job
            doJob();

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void doJob() throws IOException {
        int n = nextInt();
        int k = nextInt();
        boolean[] primes = sieve(n + 1);

        for(int i=n;i>=2;i--){
            if(primes[i]){
                int solve = i-1;
                int sn=getNextD(primes,solve);
                int en = getNextD(primes,n);
                while(en!=-1&&sn+en>=solve){
                    if((sn+en)==solve)k--;
                    sn=en;
                    en=getNextD(primes,en);
                }
            }
        }
        writer.write(k<=0?"YES":"NO");
    }

    private int getNextD(boolean[] primes, int i) {
        for(int p = i-1;p>=2;p--){
            if(primes[p])return p;
        }
        return -1;
    }

    public boolean[] sieve(int n)
    {
       boolean[] prime=new boolean[n+1];
       Arrays.fill(prime,true);
       prime[0]=false;
       prime[1]=false;
       int m= (int) Math.sqrt(n);

       for (int i=2; i<=m; i++)
          if (prime[i])
             for (int k=i*i; k<=n; k+=i)
                prime[k]=false;

       return prime;
    }



    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public Reader getReader() throws FileNotFoundException {
        if (isLocalMode) {
            return new FileReader("input.txt");
        } else {
            return new InputStreamReader(System.in);
        }
    }
}