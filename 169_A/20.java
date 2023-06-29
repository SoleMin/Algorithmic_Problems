import java.io.*;
import java.util.*;


public class Contest169ProblemA implements Runnable {

    void solve() throws NumberFormatException, IOException {
        int n = nextInt(), a = nextInt(), b = nextInt();

        ArrayList<Integer> tasks= new ArrayList<Integer>();
        
        for (int i = 0; i < n; ++i){
            tasks.add(nextInt());
        }
        Collections.sort(tasks);

        int l1 = tasks.get(b-1);
        int l2 = tasks.get(b);

        if (l2 - l1 >= 0){
            out.print(l2-l1);
        } else {
            out.print(l2-l1);
        }

    }


    StringTokenizer st;

    BufferedReader in;

    PrintWriter out;


    public static void main(String[] args) {

        new Thread(new Contest169ProblemA()).start();
    }


    public void run() {

        try {
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
            } else {
                in = new BufferedReader(new FileReader("input.txt"));
            }

            out = new PrintWriter(System.out);


            solve();


        } catch (Exception e) {

            e.printStackTrace();
            System.out.print(e);
            System.exit(9000);


        } finally {


            out.flush();

            out.close();

        }

    }

    //Получаем следующий токен

    String nextToken() throws IOException {

        while (st == null || !st.hasMoreTokens()) {

            st = new StringTokenizer(in.readLine());

        }

        return st.nextToken();

    }


    int nextInt() throws NumberFormatException, IOException {

        return Integer.parseInt(nextToken());

    }


    long nextLong() throws NumberFormatException, IOException {

        return Long.parseLong(nextToken());

    }


    double nextDouble() throws NumberFormatException, IOException {

        return Double.parseDouble(nextToken());

    }


}
