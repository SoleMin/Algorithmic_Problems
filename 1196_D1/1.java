import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- != 0){
            int n = s.nextInt();
            int k = s.nextInt();
            String str = s.next();
            String append = "RGB";
            StringBuilder sb1 = new StringBuilder();
            for(int i = 0; i < k; i++){
                sb1.append(append.charAt(i % 3));
            }
            append = "GBR";
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < k; i++){
                sb2.append(append.charAt(i % 3));
            }
            append = "BRG";
            StringBuilder sb3 = new StringBuilder();
            for(int i = 0; i < k; i++){
                sb3.append(append.charAt(i % 3));
            }
            int ans = Math.min(solve(str,sb1,k,n),Math.min(solve(str,sb2,k,n),solve(str,sb3,k,n)));
            System.out.println(ans);

        
        }
    }
    public static int solve(String str,StringBuilder sb,int k,int n){
        int min = n;
            String check = sb.toString();
            for(int i = 0; i < n - k + 1; i++){
                int w = 0,opt = 0;
                for(int j = i; j < i + k; j++){
                    if(str.charAt(j) != check.charAt(w)){
                        opt++;
                    }
                    w++;
                }
                min = Math.min(min,opt);
            }
            return min;
    }
}