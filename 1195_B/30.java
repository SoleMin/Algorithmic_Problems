import java.io.*;

public class Alpha_Round {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = reader.readLine().split(" ");
        long n = Long.parseLong(in[0]);
        long k = Long.parseLong(in[1]);
        long D = 9 + 8*k + 8*n;
        long m = (long) ((-3 + Math.sqrt(D))/2);
        writer.write((n - m) + "");
        writer.close();
    }
}