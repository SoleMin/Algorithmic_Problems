import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        Scanner in=new Scanner(new File("input.txt"));
        int n,m,k;
        n=in.nextInt();
        m=in.nextInt();
        k=in.nextInt();
        Vector<Integer> vec=new Vector<Integer>();
        Vector<Integer> temp=new Vector<Integer>();
        boolean[][] mas=new boolean[n][m];
        long time=System.currentTimeMillis();
        for(int i=0;i<k;i++)
        {
            vec.add(in.nextInt()-1);
            vec.add(in.nextInt()-1);
            mas[vec.get(vec.size()-2)][vec.get(vec.size()-1)]=true;
        }
        int x,y;
        x=y=0;
        while(vec.size()!=0)
        {
            for(int i=0;i<vec.size();i+=2)
            {
                x=vec.get(i);
                y=vec.get(i+1);
                if(x>0 && !mas[x-1][y])
                {
                    temp.add(x-1);
                    temp.add(y);
                    mas[x-1][y]=true;
                }
                if(x<n-1 && !mas[x+1][y])
                {
                    temp.add(x+1);
                    temp.add(y);
                    mas[x+1][y]=true;
                }
                if(y>0 && !mas[x][y-1])
                {
                    temp.add(x);
                    temp.add(y-1);
                    mas[x][y-1]=true;
                }
                if(y<m-1 && !mas[x][y+1])
                {
                    temp.add(x);
                    temp.add(y+1);
                    mas[x][y+1]=true;
                }
            }
            vec=temp;
            temp=new Vector<Integer>();
        }
        pw.println((x+1)+" "+(y+1));
        System.out.println(System.currentTimeMillis()-time);
        in.close();
        pw.close();
    }
}