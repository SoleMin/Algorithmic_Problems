import java.util.Scanner;


public class p23a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] x = in.next().toCharArray();
        
        int min = 0;
        int max = x.length;
        while(true) {
            if(max-min == 1)
                break;
            int mid = (max+min)/2;
            boolean eq = false;
            for (int i = 0; i <= x.length-mid; i++) {
                for (int j = 0; j <= x.length-mid; j++) {
                    if(j == i)
                        continue;
                    eq = true;
                    for (int k = 0; k < mid; k++) {
                        if(x[i+k] != x[j+k]) { 
                            eq = false;
                            break;
                        }
                    }
                    if(eq)
                        break;
                }
                if(eq) break;
            }
            if(eq) {
                min = mid;
            } else {
                max = mid;
            }
        }
        System.out.println(min);
        
    }
}
