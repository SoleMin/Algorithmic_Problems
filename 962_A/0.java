import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int sum = 0;
            int[] v = new int[n + 1];
            for(int i=1; i<=n; i++) {
                int t = in.nextInt();
                sum += t;
                v[i] = v[i - 1] + t;
            }
            double half = sum / 2.0;
            for(int i=1; i<=n; i++) {
                if(v[i] >= half) {
                    System.out.println(i);
                    break;
                }
            }
        }
        in.close();
    }

}

    		        	   				  	    		