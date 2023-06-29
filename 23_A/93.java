import java.io.*;
import java.util.*;
public class a23
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        String s,subs;
       // System.out.println("Enter");
        s=in.readLine();
        int i,j,k,l=0,a=1,sl=0;
        for(i=0;i<s.length();i++)
        {
            a=1;
            for(j=i;j<s.length();j++)
            {
                subs=s.substring(i,i+a);
                for(k=i;k<(s.length()-a+1);k++)
                {
                    if(subs.compareTo(s.substring(k,k+a))==0)
                    l++;
                    if(l==2)
                    {
                        if(a>sl)
                        sl=a;
                        l=0;
                        break;
                    }
                }
                l=0;
                a++;
            }
        }
        System.out.println(sl);
    }
}
                    