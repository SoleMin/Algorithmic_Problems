import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int a[] = new int[105];
        int vis[] = new int[105];
        Arrays.fill(vis, 0);
        int n = cin.nextInt();
        for(int i = 0; i < n; i++)
            a[i] = cin.nextInt();
        Arrays.sort(a, 0, n);
        int ans = 0;

        for(int i = 0; i < n; i++){
            int x = a[i];
            if(vis[x] == 0){
                ans++;
                for(int j = x; j < 105; j += x)
                    vis[j] = 1;
            }
        }
        System.out.println(ans);
    }
}
		   					 				   	 		