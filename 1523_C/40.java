import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            ArrayList<Integer>list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(buffer.readLine());
                if (a == 1)
                    list.add(1);
                else {
                    for (int j = list.size()-1; j >= 0; j--) {
                        if (list.get(j)+1 == a)
                            break;
                        list.remove(list.size()-1);
                    }
                    list.remove(list.size()-1);
                    list.add(a);
                }
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (j == list.size()-1)
                        sb.append("\n");
                    else
                        sb.append(".");
                }
            }
        }
        System.out.println(sb);
    }
}
