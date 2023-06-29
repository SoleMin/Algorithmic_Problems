import java.util.*;
public class codeee {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==1){System.out.println(1); return;}
        int []mas=new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
            mas[i]=sc.nextInt();
            sum+=mas[i];
        }
        Arrays.sort(mas);
        int sum1=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum1+=mas[n-i-1];
            if(sum1>(sum-sum1)){
                ans=i;
                break;
            }
        }
        System.out.println(ans+1);
    }
}
