import java.util.*;

public class Main {
    static HashSet<String> v = new HashSet<String>();

    static class element {
        int[] arr;
        int dist;
    }

    static int wheels(int[] st, int[] end) {
        Queue<element> q = new LinkedList<>();
        String endd = Arrays.toString(end);
        v.add(Arrays.toString(st));
        element start = new element();
        start.arr = new int[4];
        for (int i = 0; i < 4; i++) {
            start.arr[i] = st[i];
        }
        start.dist = 0;
        q.add(start);
        while (!q.isEmpty()) {
            element curr = q.poll();
            int[] arr = curr.arr;
            if (endd.equals(Arrays.toString(arr)))
                return curr.dist;
            for (int i = 0; i < 4; i++) {
                int[] A = new int[4];
                int[] B = new int[4];
                for (int j = 0; j < 4; j++) {
                    if (i == j) {
                        A[j] = (arr[j] + 1) % 10;
                        B[j] = (arr[j] + 9) % 10;
                    } else {
                        A[j] = B[j] = arr[j];
                    }
                }
                String s1 = Arrays.toString(A);
                String s2 = Arrays.toString(B);
                if (!v.contains(s1)) {
                    v.add(s1);
                    element e = new element();
                    e.arr = A;
                    e.dist = curr.dist + 1;
                    q.add(e);
                }
                if (!v.contains(s2)) {
                    v.add(s2);
                    element e = new element();
                    e.arr = B;
                    e.dist = curr.dist + 1;
                    q.add(e);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int t = in.nextInt();
        int[] start = new int[4];
        int[] end = new int[4];
        int[] temp = new int[4];
        int n;
        for (int i = 0; i < t; i++) {
            v.clear();
            if (i != 0)
                in.nextLine();
            for (int j = 0; j < 4; j++) {
                start[j] = in.nextInt();
            }
            for (int j = 0; j < 4; j++) {
                end[j] = in.nextInt();
            }
            n = in.nextInt();
            for (int j = 0; j < n; j++) {
                for (int j2 = 0; j2 < 4; j2++) {
                    temp[j2] = in.nextInt();
                }
                v.add(Arrays.toString(temp));
            }
            out.append(wheels(start, end) + "\n");
        }
        System.out.print(out);
    }
}
