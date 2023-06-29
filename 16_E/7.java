import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Main
{
    public static double p[];
    static double s[];
    static double m[];
    static int n;
    public static double a[][];
    public static int index=0;
    public static boolean vis[];
    public static HashMap<Integer, Integer> permMap;

    public static void main(String g[])
    {

        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m = new double[(1<<n) +1];
        vis = new boolean[(1<<n) +1];
        a = new double[n][n];

        for(int i=0;i<n;i++)
                {
            for(int j=0;j<n;j++)
            {
                //System.out.println("read"+(c++));
                a[i][j] = sc.nextDouble();
            }
                }

        s = new double[1<<n]; // 2^n
        int perm=0;
        m[0]=1;
        p();

//      System.out.println("answers : ");

        int c=((1<<n)-1);
        for(int i=0;i<n;i++)
        {
            perm = c-(1<<i);
//          System.out.printf("permutation = %x, prob = %f\n",perm,m[perm]);
            System.out.printf("%.6f ",m[perm]);
        }
//      getPerms(0);
//      p(perm);

//      double res[] = new double[n];
//      for(int i=0;i<n;i++)
        {
//          for(int j=0;j<n;j++)
//          if((i&(i-1))!=0)
//              continue;

//          res[i] =
//              p(perm,n);
//          System.out.println(m[i][j]);
        }

//      int cur=(1<<n)-1;
//
//int i=0;
//      for(i=0;i<n;i++)
//      {
//          int val=(cur-(1<<i));
//          int L = n-1;
//          System.out.printf("running for %x .... P = %f\n",val,getProb(val,L));
//
//      }

        //getP((1<<n)-1));

//      for(int i=0;i<m.length;i++)
//      {
//          System.out.println(m[perm]);
//      }


    }



    public static void p()
    {
        
            for(int k=0;k<(1<<n);k++)
            {
                
                int perm=k;
        for(int j=0;j<n;j++)
        {

            if(bitTest(perm, j))
            {
                continue;
            }

            int newPerm=perm|(1<<j);    // j got eaten

            for(int i=0;i<n;i++)
            {
                if( (i==j) || bitTest(newPerm,i))
                {
                    continue;
                }
                // i eats j

                int  L=n-countO(perm);
                if(L<2)
                {
                    continue;
                }
                //System.out.println("L="+L);
                double pm = 2.0/(L*(L-1));



//              System.out.printf("Left with %d,%d eats %d \n",L,i,j);
                m[newPerm]+=m[perm]*a[i][j]*pm;
//              System.out.printf("p(%x)= %f \n",newPerm,m[newPerm]);
                //System.out.printf("p(%x)= %f \n",newPerm2,m[newPerm2]);
            }
//          System.out.printf("p(%x)= %f \n",newPerm,m[newPerm]);
//          System.out.println("here-------------------->");

        }

            }
        

    }


    private static int countO(int marked) {
        // TODO Auto-generated method stub

        int count=0;
        for(int i=0;i<n;i++)
        {
            int test = (1<<i);
            if((test&marked)==(test))
                count++;
        }
        return count;
    }

    private static boolean bitTest(int perm, int i) {
        // TODO Auto-generated method stub
        int test = (1<<i);
        if((test&perm)==test)
            return true;
        return false;
    }

    private static int bitSet(int perm, int i) {
        // TODO Auto-generated method stub
        int np = (1<<i);
        return np;
    }

}

