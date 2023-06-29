import java.util.Scanner;
public class _1420D {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        long sum=0;
        for(int i=0;i<m;i++)
        {
            int x=input.nextInt();
            int d=input.nextInt();
            if(d<0)
            {
                if(n%2!=0)
                {
                    long val=n/2;
                    val=val*(val+1);
                    sum+=(long)val*(long)d;
                    sum+=(long)n*x;
                }
                else
                {
                    long v1=n/2;
                    v1=v1*(v1+1)/2;
                    long v2=n/2-1;
                    v2=v2*(v2+1)/2;
                    long val=v1+v2;
                    sum+=val*(long)d+(long)n*x;
                }
            }
            else
            {
                sum+=(long)(n-1)*n/2*(long)d;
                sum+=(long)n*x;
            }
        }
        double s=(double)sum;
        double av=s/(double)n;
        System.out.println(av);
    }
}