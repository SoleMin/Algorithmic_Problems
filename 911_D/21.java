import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        int[] arr = new int[n];
        int initial = 0;
        for (int i = 0; i < n; i++) arr[i] = Reader.nextInt();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) if (arr[i] > arr[j]) initial++;
        }

        int m = Reader.nextInt();
        boolean parity = initial % 2 == 0;
//        System.out.println(parity ? "even": "odd");
        for (int i = 0; i < m; i++) {
            int l = Reader.nextInt();
            int r = Reader.nextInt();
            int elems = r - l + 1;
            boolean change = (elems/2) % 2 == 0;
            parity = parity == change;
            System.out.println(parity ? "even": "odd");
        }
    }
}

/**
 * Reader class based on the article at "https://www.cpe.ku.ac.th/~jim/java-io.html"
 * */
class Reader{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    static void init(InputStream inputStream){
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()){
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

//    static long nextLong() throws IOException{
//        return Long.parseLong(next());
//    }

    //Get a whole line.
//    static String line() throws IOException{
//        return reader.readLine();
//    }
//
//    static double nextDouble() throws IOException{return Double.parseDouble(next());}
}



