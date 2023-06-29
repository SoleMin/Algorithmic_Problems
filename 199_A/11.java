import java.io.*;
import java.util.*;
import java.math.*;

public class MAIN
{
    public static void main(String args[])
    {
        Scanner sn=new Scanner(System.in);
        int n,n1,n2,n3;

        int arr[]={0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986,102334155,165580141,267914296,433494437,701408733,1134903170};

        n=sn.nextInt();


        if(n==2)
        {
            n1=n2=1;
            n3=0;
        }
        else if(n==1)
        {
            n3=n2=0;
            n1=1;
        }
        else if(n==0)
        {
            n1=n2=n3=0;
        }
        else if(n==3)
        {
            n1=n2=n3=1;
        }
        else
        {
            int index=bsearch(arr,0,arr.length-1,n);
            n1=arr[index-1];
            n2=arr[index-3];
            n3=arr[index-4];
        }

        System.out.println(n3+" "+n2+" "+n1);

    }

    static int bsearch(int arr[],int l,int h,int n)
    {
        if(l>h)
        return -1;

        int mid=(l+h)/2;

        if(n==arr[mid])
        return mid;
        else if(n>arr[mid])
        return(bsearch(arr,mid+1,h,n));
        else
        return(bsearch(arr,l,mid-1,n));
    }
}