/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author 111
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    static long k, n, ans;
    static private long binsearch(long l, long r)
    {
        if(l==r) return l;
        long m=(l+r)/2;
        long res=(m*(k+k-m+1)/2);
        if(res>=n)
            return binsearch(l, m);
        else
            return binsearch(m+1, r);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        n=in.nextLong();
        k=in.nextLong();
        n--;
        k--;
        if(k*(k+1)/2<n)
            ans=-1;
        else
            ans=binsearch(0, k);
        System.out.println(ans);            
    }
}
