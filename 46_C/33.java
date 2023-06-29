import java.util.*;
import java.math.*;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Character.isDigit;

public class Main{
    public static void main(String[] args) {
        new Main().run();
    }
    Scanner sc=new Scanner(System.in);
    void run() {
        int n=sc.nextInt();
        char[] cs=sc.next().toCharArray();
        int h=0;
        for(int i=0;i<n;i++)if(cs[i]=='H')h++;
        int res=n;
        for(int i=0;i<n;i++) {
            int val=0;
            for(int j=0;j<h;j++)if(cs[(i+j)%n]=='T')val++;
            res=min(res,val);
        }
        System.out.println(res);
    }
}
