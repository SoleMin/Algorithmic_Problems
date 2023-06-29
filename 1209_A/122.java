import java.util.*;

public class cf573 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=0;
        if(scan.hasNext())
            n=scan.nextInt();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(scan.hasNext())
                set.add(scan.nextInt());
        }
        int[] arr=new int[set.size()];
        Iterator<Integer> it=set.iterator();
        int j=0;
        while(it.hasNext()){
            arr[j++]=it.next();
        }
        int tot=1,flag;
        for(int i=1;i<arr.length;i++){
            flag=0;
            for(int k=0;k<i;k++){
                if(arr[i]%arr[k]==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                tot++;
            }
        }
        System.out.println(tot);
    }
}
