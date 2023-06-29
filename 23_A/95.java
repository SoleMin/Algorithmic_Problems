import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static boolean bg = true;

    public static void main(String[] args) throws Exception {
        String k1 = scan.next();
        HashSet<String> met = new HashSet();
        String ans = "";
        for (int i=1;i<=k1.length()-1;i++){
            for (int j=0;j+i<=k1.length();j++){
                String cur = k1.substring(j, j+i);
                if (!met.contains(cur)){
                    met.add(cur);
                }
                else {
                    if (cur.length()>ans.length())ans=cur;
                }
            }
        }
        System.out.println(ans.length());
        
    }
}
