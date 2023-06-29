import java.util.*;


public class Main{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] a=new int[1010];
        while(in.hasNext()){
            int n=in.nextInt();
            String s=in.next();
            int sum=0;
            for(int i=0;i<n;++i){
                if(s.charAt(i)=='H'){
                    a[i]=1;
                    ++sum;
                }
                else a[i]=0;
            }
            int min=10010;
            for(int i=0;i<n-sum;++i){
                int count=0;
                for(int j=i+sum;j<n;++j){
                    if(a[j]==1)++count;
                }
                for(int j=0;j<i;++j){
                    if(a[j]==1)++count;
                }
                if(count<min)min=count;
            }
            sum=n-sum;
            for(int i=0;i<n-sum;++i){
                int count=0;
                for(int j=i+sum;j<n;++j){
                    if(a[j]==0)++count;
                }
                for(int j=0;j<i;++j){
                    if(a[j]==0)++count;
                }
                if(count<min)min=count;
            }
            System.out.println(min);
        }
    }
}
