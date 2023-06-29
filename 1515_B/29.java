//I'm Whiplash99
import java.io.*;
import java.util.*;
public class B
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();

        while (T-->0)
        {
            N=Integer.parseInt(br.readLine().trim());

            boolean flag=false;
            int sqrt=(int) Math.sqrt(N/2);
            if(sqrt*sqrt==N/2&&N%2==0) flag = true;

            sqrt=(int) Math.sqrt(N/4);
            if(sqrt*sqrt==N/4&&N%4==0) flag = true;

            sb.append(flag?"YES\n":"NO\n");
        }
        System.out.println(sb);
    }
}