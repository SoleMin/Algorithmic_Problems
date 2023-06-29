import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.*;
//import java.math.*;
//import static java.lang.Math.*;
//import static java.util.Arrays.*;
 
public class Main{
    public static void main(String[] args) throws IOException { //1-checker 2-console
        //if (args.length==2) open(args[0], args[1], true, false); else open ("input.txt", "output.txt", true, false);
        open ("input.txt", "output.txt", false, true);
        char[] alph = " ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Pattern pat = Pattern.compile("[A-Z]+[\\d]+");
        Matcher mat;
        boolean b ;
        String  s;
        int index, coef, row, col;
        int n = nextInt();
        String[] tmp;
        char[] c;
        for (int i=0; i<n; i++)
        {
            s = nextLine();
            c = s.toCharArray();
            mat = pat.matcher(s);
            b = mat.matches();
            if (b)
            {
                
                index = c.length-1;
                coef = 1;
                row = 0;
                while (c[index]>='0' && c[index]<='9')
                {
                    row += (c[index]-'0')*coef;
                    coef*=10;
                    index--;
                }
                coef = 1;
                col = 0;
                while (index>=0)
                {
                    /*if (coef!=1)*/ col += (Arrays.binarySearch(alph, c[index]))*coef;
                    //else col += (Arrays.binarySearch(alph, c[index]))*coef;
                    coef*=26;
                    index--;
                }
                out.println("R"+row+"C"+col);
            }
            else
            {
                tmp = s.split("R|C");
                //out.print(tmp.length);
                //row = Integer.parseInt(tmp[1]);
                col = Integer.parseInt(tmp[2]);
                char[] temp = new char[10];
                int len = 0;
                int v = 0;
                while (col>0)
                {
                    index = col%26;
                    if (index==0)
                        { index=26;
                          v = 1;
                        }
                    else v = 0;
                    /*if (len==0)*/ temp[len]=alph[index];
                    //else temp[len]=alph[index-1];
                    col = (col/26) - v;
                    len++;
                }
                for (int j=len-1; j>=0; j--)
                {
                    out.print(temp[j]);
                }
                out.println(tmp[1]);
            }
        }
        close();
    }
  
    static StringTokenizer st;
    static StreamTokenizer strTok;
    static BufferedReader in;
    static PrintWriter out;
 
    static String nextToken(boolean f) throws IOException {
        if (f) {
            return in.readLine();
        } else {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }
    }
 
    static String nextLine() throws IOException {
        return nextToken(true);
    }
 
    static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken(false));
    }
 
    static long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken(false));
    }
 
    static double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken(false));
    }
 
    static char nextChar() throws IOException {
        return ((char)in.read());
    }
 
    static void close(){
        out.flush();
        out.close();
    }
 
    static void open(String filein, String fileout, boolean flag, boolean console) throws IOException{
        if (flag) {
            strTok = new StreamTokenizer(new FileReader (new File(filein)));
            in = new BufferedReader(new FileReader (new File(filein)));
            out = new PrintWriter(new FileWriter(new File (fileout)));
        } else {
            if (console){
                strTok = new StreamTokenizer(new InputStreamReader (System.in, "ISO-8859-1"));
                in = new BufferedReader (new InputStreamReader (System.in, "ISO-8859-1"));
                out = new PrintWriter (new OutputStreamWriter (System.out, "ISO-8859-1"));
            } else {
                strTok = new StreamTokenizer(new FileReader (new File("input.txt")));
                in = new BufferedReader(new FileReader (new File("input.txt")));
                out = new PrintWriter(new FileWriter(new File ("output.txt")));
            }
        }
    }
}