import java.math.BigDecimal;
import java.util.*;
import java.math.BigInteger;
public class Main {
    static Long[] a = new Long[205000];
    static Long[] postfix=new Long[205000];
    static HashMap<Long,Long> check=new HashMap<Long,Long>();
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        long k, j, p,sum,equal,bigone,lessone,cnt;
        BigInteger ans;
        int i,n;
        while (cin.hasNext()) {
            n=cin.nextInt();
            check.clear();
            for(i=1;i<=n;i++)
            {
                a[i]=cin.nextLong();
            }
            postfix[n+1]=0L;
            for(i=n;i>=1;i--) {
                postfix[i] = postfix[i + 1] + a[i];
                if (check.containsKey(a[i]) == true) {
                    Long v = check.get(a[i]);
                    v += 1;
                    check.put(a[i], v);
                }
                else
                    check.put(a[i],1L);
            }
            ans=BigInteger.ZERO;
            for(i=1;i<n;i++){
                Long v=check.get(a[i]);
                v--;
                check.put(a[i],v);
                equal=check.get(a[i]);
                bigone=0L;
                lessone=0L;
                if(check.containsKey(a[i]+1L)==true)
                bigone=check.get(a[i]+1L);
                if(check.containsKey(a[i]-1L)==true)
                lessone=check.get(a[i]-1L);
                sum=postfix[i]-bigone*(a[i]+1L)-lessone*(a[i]-1L)-equal*a[i]-a[i];
                cnt=n-i-bigone-lessone-equal;
                ans=ans.add(BigInteger.valueOf(a[i]*cnt).subtract(BigInteger.valueOf(sum)));
            }
            System.out.println(ans.multiply(BigInteger.valueOf(-1)));
        }
    }
}