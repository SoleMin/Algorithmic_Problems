import java.io.*;


public class Main {
    private StreamTokenizer in;
    private PrintWriter out;


    public static void main(String[] args) throws IOException {
        //long time = System.currentTimeMillis();

        new Main().run();
        //time = System.currentTimeMillis() - time;
        //System.out.println(time + " ms");

    }


    private void run() throws IOException {
        //in = new StreamTokenizer(new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"))));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        //out = new PrintWriter(new File("output.txt"));

        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(25);


        out.flush();

    }


    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}