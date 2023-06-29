import java.io.*;
import java.math.*;
import java.util.*;
import java.util.List;
import java.awt.*;

public class Trains1_2 implements Runnable {

    private BufferedReader br = null;
    private PrintWriter pw = null;
    private StringTokenizer stk = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(new Trains1_2()).run();
    }

    public void run() {
        /*
         * try { br = new BufferedReader(new FileReader("knapsackfixed.in")); pw
         * = new PrintWriter("knapsackfixed.out"); } catch
         * (FileNotFoundException e) { e.printStackTrace(); }
         */
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));
        solver();
        pw.close();

    }

    private void nline() {
        try {
            if (!stk.hasMoreTokens())
                stk = new StringTokenizer(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("KaVaBUnGO!!!", e);
        }
    }

    private String nstr() {
        while (!stk.hasMoreTokens())
            nline();
        return stk.nextToken();
    }

    private int ni() {
        return Integer.valueOf(nstr());

    }

    private long nl() {

        return Long.valueOf(nstr());
    }

    private double nd() {
        return Double.valueOf(nstr());

    }

    boolean isNumber(char c) {
        if (c <= '9' && c >= '0')
            return true;
        return false;
    }

    String to10(String s) {
        long ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return String.valueOf(ans);
    }
    
    String to26(String s){
        String ans="";
        int a = Integer.valueOf(s);
        while(a>26){
            a--;
            int k = a%26;
            ans=ans+(char)((int)'A'+k);
            a/=26;
        }
        ans+=(char)(a+'A'-1);
        String ans1 = "";
        for(int i = ans.length()-1; i>=0; i--)ans1+=ans.charAt(i);
        
        return ans1;
        
    }

    String rev(String s) {
        String ans = "";
        int format = 0;
        int git = 0;
        String token1 = "";
        String token2 = "";
        String token3 = "", token4 = "";
        for (int i = 0; i < s.length(); i++) {
            if (!isNumber(s.charAt(i)))
                token1 += s.charAt(i);
            else
                break;
            git++;
        }
        for (int i = git; i < s.length(); i++) {
            if (isNumber(s.charAt(i)))
                token2 += s.charAt(i);
            else
                break;
            git++;
        }
        if (s.length() == git)
            format = 1;
        else {
            format = 2;
            
            for (int i = git; i < s.length(); i++) {
                if (!isNumber(s.charAt(i)))
                    token3 += s.charAt(i);
                else
                    break;
                git++;
            }
            for (int i = git; i < s.length(); i++)
                if (isNumber(s.charAt(i)))
                    token4 += s.charAt(i);
                else
                    break;
        }

        if (format == 1) {
            ans += "R";
            ans += token2;
            ans += "C";
            ans += to10(token1);

        }else{
            ans+=to26(token4);
            ans+=token2;
        }

        return ans;
    }

    private void solver() {

        int n = ni();
        for (int i = 0; i < n; i++)
            System.out.println(rev(nstr()));

    }

    void exit() {
        System.exit(0);
    }
}
