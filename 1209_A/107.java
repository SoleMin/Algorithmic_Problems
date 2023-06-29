import java.util.*;

public class Paint {
    public static void main (String srgs[] ){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=0;i<n;++i){
            ts.add(sc.nextInt());
        }
        int x=0;
        int a[]=new int[ts.size()];
        for(int y:ts){
            a[x++]=y;
        }
        for(int i=0;i<ts.size()-1;++i){
            for(int j=i+1;j<ts.size();++j){
                if((a[i]!=-1)&&(a[j]!=-1)&&(a[j]%a[i]==0)){
                    a[j]=-1;
                }
            }
        }
        int c=0;
        for(int z:a){
            if(z!=-1)++c;
        }
        System.out.print(c);
    }
}