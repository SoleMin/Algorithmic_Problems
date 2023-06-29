import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, s;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            if (maps.containsKey(a)) {
                maps.put(a, -1);
            } else {
                maps.put(a, 1);
            }
            if (maps.containsKey(b)) {
                maps.put(b, -1);
            } else {
                maps.put(b, 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> i : maps.entrySet()) {
            if (i.getValue() == 1) {
                count++;
            }
        }
        double ans = 2.0 * s / count;
        System.out.printf("%.18f",ans);
    }
}

		   	  			   		   			 				 	 	