import java.io.*;
import java.util.Scanner;


public class T
{
    public static void main(String[] args) throws IOException
    {
        T t = new T();
        t.run();
        t.close();
    }

    private void close()
    {
        sc.close();
        pw.close();
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(reader);
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    void yesno(boolean b)
    {
        pw.println(b ? "YES" : "NO");
    }


    void run() throws IOException
    {
        int n = sc.nextInt();

        if (n % 2 == 0)
        {
            pw.print(4 + " " + (n - 4));
        }
        else
        {
            pw.print(9 + " " + (n - 9));
        }

    }
}
