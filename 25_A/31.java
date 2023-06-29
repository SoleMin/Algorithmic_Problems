import java.io.*;

public class Main 
{
    public static void main(String []args)throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        n=Integer.parseInt(br.readLine());
        String inp="";
        inp=br.readLine();
        int no[]=new int[n];
        String tinp[]=inp.split(" ");
        for(int i=0;i<n;i++)
        {
            no[i]=Integer.parseInt(tinp[i]);
        }
        int eve=0,odd=0;
        for(int i=0;i<3;i++)
        {
            int rem=no[i]%2;
            if(rem==0)
                eve++;
            else
                odd++;
        }
               if(eve>1)
               {
                   for(int i=0;i<n;i++)
                   {
                       if(no[i]%2==1)
                       {
                           System.out.println(i+1);
                           break;
                       }
                   }
               }
               else
               {
                     for(int i=0;i<n;i++)
                      {
                          if(no[i]%2==0)
                          {
                           System.out.println(i+1);
                           break;
                          }
                      }
            
               }
                

}
}
