import java.io.*;
import java.util.StringTokenizer;

public class DoubleWord implements Runnable {

    boolean isLocalMode =false;


    private void doJob() throws Exception {
        //do here
        String s = nextToken();
                int max=0;
        for(int i = 0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String s1 = s.substring(i, j);
                if(s.substring(i+1).contains(s1)){
                    max = Math.max(max,s1.length());
                }
            }
        }
        writer.write(""+max);
    }


    public static void main(String[] args) {
        new DoubleWord().run();
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