 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.*;
 public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner sc = new Scanner(new File("input.txt"));
        
        int n = sc.nextInt();
        int m =sc.nextInt();
        sc.nextLine();
        int k =sc.nextInt();
        int les[][] = new int[n][m];
        PrintWriter out = new PrintWriter(new FileWriter("output.txt")); 
        //sc.nextLine();
        ArrayList<Integer[]> list = new ArrayList();
        sc.nextLine();
        for(int i = 0;i<k;i++)
        {
            
            Integer[] ii = new Integer[2];
            ii[0] = sc.nextInt()-1;
            ii[1] = sc.nextInt()-1;
            list.add(ii);
            
        }
        sc.close(); 
        int maxr = 0;
        int maxi = 0;
        int maxj = 0;
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<m;j++)
            {
                int minr = 100000;
                int mini = 0;
                int minj = 0;
                for(int f = 0;f<k;f++)
                {
                    Integer[] ii = list.get(f);
                    int ww = Math.abs(ii[0] - i);
                    int hh = Math.abs(ii[1] - j);
                    int r = ww+hh;
                    if(r<minr)
                    {
                        minr = r;
                        mini=i;
                        minj=j;
                    }
                    
                }
                if(maxr<minr&&minr<100000)
                {
                    maxi = mini;
                    maxj = minj;
                    maxr = minr;
                }
            }
        }
        
        out.print((maxi+1)+" "+(maxj+1));
        out.close();
        
    }
    
    


    
    
}
