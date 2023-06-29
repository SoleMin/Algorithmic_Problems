import java.util.*;
import java.io.*;
public class DigitSequence 
{
    public static PrintWriter out;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer("");
        String temp[] = br.readLine().split(" ");
        long pos = Long.parseLong(temp[0]);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        if (pos<10)
        {
            out.println(pos);
        }
        else
        {
            out.println(findDigitSequence(pos));
        }
        out.close();
    }

    private static char findDigitSequence(long pos) 
    {
        //long result = 0;
        long min = 0;
        long max = 9;
        long dig = 1;
        while (pos>max)
        {
            dig++;
            min = max+1;
            max=(long) (max+9*Math.pow(10, dig-1)*dig);
        }
        pos = pos-min;
        long num = (long) (pos/dig+Math.pow(10, dig-1));
        String st = String.valueOf(num);
        if (dig==1)
        {
            return st.charAt(0);
        }
        char result = st.charAt((int) (pos%dig));
        return result;
    } 
    
}