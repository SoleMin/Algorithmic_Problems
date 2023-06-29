
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CodehorsesT_shirts {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String input;
        for (int i = 0; i < n; i++) {
            input = reader.readLine();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
            } else {
                map.put(input, 1);
            }
        }
        int change = 0;
        for (int i = 0; i < n; i++) {
            input = reader.readLine();
            if (map.containsKey(input)) {
                map.put(input, map.get(input) - 1);
            } else {
                map.put(input, -1);
            }
        }
        for (int x : map.values()) {
            change += Math.abs(x);
        }
        System.out.println(change/2);
    }

}
