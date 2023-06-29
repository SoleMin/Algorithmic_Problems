/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaurav
 */import java.io.*;
public class a23 {
    public static void main(String arg[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));




          String s=br.readLine();int max=0;
          for(int i=0;i<s.length();i++)
          {
              for(int j=i+1;j<=s.length();j++)
              {
                  String g=s.substring(i,j);
                  //System.out.println(g);
                  if(max<g.length())
                  for(int k=i+1;k<=s.length()-g.length();k++)
                  {
                      //System.out.println(s.substring(k,k+g.length()));
                      if(g.compareTo(s.substring(k,k+g.length()))==0)
                      {
                          max=g.length();
                          break;
                      }
                      }
              }
          }
          System.out.println(max);
}
}
