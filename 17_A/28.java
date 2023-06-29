import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class A{

    void exe(){
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=2;i<=1000;i++)
            if(isPrime(i))
                list.add(i);
        Object[] primes=list.toArray();
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int cnt=0;
        for(int c=2;c<=n;c++){
            if(!isPrime(c))
                continue;
            for(int i=0;i<primes.length-1;i++){
                int p1=(Integer)primes[i];
                int p2=(Integer)primes[i+1];
                if(c==1+p1+p2){
//                  System.out.println("c="+c+", i="+p1+", j="+p2);
                    cnt++;
                }
            }
        }
        if(cnt>=k){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    boolean isPrime(int n){
        if(n<=1)return false;
        if(n==2)return true;
        if(n%2==0)return false;
        int m=(int)Math.sqrt(n)+1;
        for(int i=3;i<=m;i+=2)
            if(n%i==0)
                return false;
        return true;
    }
    
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        new A().exe();
    }
}
