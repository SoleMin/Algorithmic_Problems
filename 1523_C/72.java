import java.util.*;
public class CompressionAndExpansion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int n = in.nextInt();
                if (n == 1) {
                    list.add(n);
                } else {
                    for (int j = list.size() - 1; j >= 0; j--) {
                        if (list.get(j) == n - 1) {
                            list.set(j, n);
                            break;
                        }
                        list.remove(j);
                    }
                }
                for (int j = 0; j < list.size(); j++) {
                    System.out.print(list.get(j) + (j == list.size() - 1 ? "\n" : "."));
                }
            }
        }
    }
}