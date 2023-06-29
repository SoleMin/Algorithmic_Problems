import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class VtoraiaStat implements Runnable {

    boolean isLocalMode = false;


    private void doJob() throws Exception {
       int n  = nextInt();
        int[] r = new int[n];
        for(int i =0;i<n;i++){
            r[i]=nextInt();
        }

        Arrays.sort(r);
        int m = r[0];
        for(int i=0;i<n;i++){
            if(r[i]!=m){
                writer.write(""+r[i]);
                return;
            }
        }
        writer.write("NO");
    }


    public static void main(String[] args) {
        new VtoraiaStat().run();
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