import java.util.Scanner;


public class BB {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int a[]=new int[n+1];
    boolean used[]=new boolean[100009];
    for (int i = 1; i <=n; i++) {
        a[i]=sc.nextInt();
    }
    int cnt=0;
    int id=0;
    for (int i = 1; i <=n; i++) {
        if(!used[a[i]]){
            cnt++;
        used[a[i]]=true;
        }
        if(cnt==k){
            id=i;
            break;
        }
    }
    boolean x[]=new boolean[100005];
    int y=0;
    int id1=0;
    if(id==0){
        System.out.println(-1+" "+-1);
            return;
    }
    for (int i =id; i >=1; i--) {
        if(!x[a[i]]){
            y++;
            x[a[i]]=true;
        }
        if(y==k){
            id1=i;
            break;
        }
    }
    System.out.println(id1+" "+id);
}
}
