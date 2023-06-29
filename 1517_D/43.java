import java.util.*;
import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Scanner;
public class D{

    static void sort(int[] A){

        int n = A.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = A[i];
            int randomPos = i + rnd.nextInt(n-i);
            A[i] = A[randomPos];
            A[randomPos] = tmp;
        }
        Arrays.sort(A);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        //int cases = sc.nextInt();

        //for(int i=0;i<cases;i++)
        {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int steps=sc.nextInt();
            long arr[][][] = new long[n][m][5];
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<m-1;k++)
                {
                    long num=sc.nextLong();
                    arr[j][k][1]=num;
                    arr[j][k+1][3]=num;
                }
            }

            for(int j=0;j<n-1;j++)
            {
                for(int k=0;k<m;k++)
                {
                    long num=sc.nextLong();
                    arr[j][k][2]=num;
                    arr[j+1][k][4]=num;
                }
            }

            long temp[][]=new long[n][m];
            long ans[][]=new long[n][m];
            for(int i=0;i<steps/2;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int k=0;k<m;k++)
                    {
                        long min=Long.MAX_VALUE;
                        if(k>0)
                        {
                            long f=arr[j][k][3]+ans[j][k-1];
                            min=Math.min(min,f);
                        }

                        if(k<m-1)
                        {
                            long f=arr[j][k][1]+ans[j][k+1];
                            min=Math.min(min,f);
                        }

                        if(j>0)
                        {
                            long f=arr[j][k][4]+ans[j-1][k];
                            min=Math.min(min,f);
                        }

                        if(j<n-1)
                        {
                            long f=arr[j][k][2]+ans[j+1][k];
                            min=Math.min(min,f);
                        }

                        temp[j][k]=min;
                    }
                }

                for(int j=0;j<n;j++)
                {
                    for(int k=0;k<m;k++)
                    {
                        ans[j][k]=temp[j][k];
                    }
                }
            }


            StringBuilder p=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                for(int k=0;k<m;k++)
                {
                    if(steps%2!=0)
                    {
                        p.append(-1+" ");
                    }
                    else
                    {
                    p.append(2*ans[j][k]+" ");}
                }

                p.append("\n");
            }


            System.out.println(p);
        }

    }
}
