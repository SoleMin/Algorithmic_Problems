import java.io.IOException;
import java.util.Scanner;

public class TC
{
    static long N;
    static int k;
    static long WHOLESUM;
    
    static long SUM( long k )
    {
        long res=k*( k+1 )/2;
        return res-1;
    }
    
    static long returnPipes( int mid )
    {
        long not=SUM( mid-1 );
        long totpipes=WHOLESUM-not;
        int number=k-mid+1;
        long res=totpipes-number+1;
        return res;
    }
    
    static long binarySearch( int lo, int hi )
    {
        int res=Integer.MAX_VALUE;
        int val=0;
        while( lo <= hi )
        {
            int mid=( lo+hi )/2;
            long cnt=returnPipes( mid );
            val=k-mid+1;;
          
            if( cnt  < N )
            {
                hi=mid-1;
                continue;
            }
            else
            {
                res=Math.min( val, res );
                lo=mid+1;
            }
        }
        
        if( res==Integer.MAX_VALUE )
            return -1;
        else
            return res;
        
    }
    

    public static void main( String[] args ) throws IOException
    {
        Scanner s=new Scanner( System.in );
        N=s.nextLong();
        k=s.nextInt();
        WHOLESUM=SUM( k );
        if( N<=1 )
            System.out.println(0 );
        else
            System.out.println( binarySearch( 2, k ) );
    }
    
    
}