import java.util.*;
public class algo121
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        int n=ex.nextInt();
        String a[]=new String[n];
        String b[]=new String[n];
        for(int i=0;i<n;i++)
        a[i]=ex.next();
        for(int i=0;i<n;i++)
        b[i]=ex.next();
        String valid[]={"S","M","L","XS","XL","XXS","XXL","XXXS","XXXL"};
        int ai[]=new int[9];
        int bi[]=new int[9];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a[i].equals(valid[j]))
                ai[j]++;
                if(b[i].equals(valid[j]))
                bi[j]++;
            }
        }
        int ans=0;
        for(int i=0;i<9;i++)
        {
            if(ai[i]>bi[i])
            ans=ans+ai[i]-bi[i];
        }
        System.out.println(ans);
    }
}