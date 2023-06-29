import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
 
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            a[i]=s.nextInt();
            Arrays.sort(a);
            ArrayList<Integer>al=new ArrayList();
            int k=a[0];
            int count=0;
            for(int j=0;j<n;j++)
            {k=a[j];
                if(Collections.frequency(al,a[j])==0)
                {for(int i=0;i<n;i++)
            {if(a[i]%k==0)
            {al.add(a[i]);}}
            count++;}}
            System.out.println(count);}}