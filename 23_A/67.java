import java.io.*;
public class Main 
{
     public static void main(String []args)throws Exception
    {
        String inp="";
        String res="";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        inp=br.readLine();
        for(int i=0;i<inp.length();i++)//counts the length
        {
            for(int j=0;j<(inp.length()-i);j++)//start index of string
            {
                for(int k=j+1;k<=inp.length()-i;k++)
                {
                    if(inp.substring(j,j+i).equals(inp.substring(k,k+i)))
                       res =inp.substring(j,j+i);
                }
            }
        }
        System.out.println(res.length());

     }
}