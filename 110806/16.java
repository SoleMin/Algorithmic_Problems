import java.io.*;

public class Main {
    static int n, id, po;
    static int[] am = new int[8];
    static int[] pc = new int[32];
    static int[] cl = new int[33];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        String input;
        while ((input = br.readLine()) != null) {
            String[] ia = input.split(" ");
            id = Integer.parseInt(ia[0]);
            n = Integer.parseInt(ia[1]);
            for (i = 0; i < n; i++) cl[i] = ia[2].charAt(i) - '0';
            for (i = 0; i < 8; i++) {
                am[i] = id % 2;
                id /= 2;
            }
            po = 0;
            for (i = 0; i < 8; i++) {
                if (am[i] == cl[1]) {
                    pc[0] = (i/4)%2;
                    pc[1] = (i/2)%2;
                    pc[2] = i%2;
                    back(2);
                    if (po != 0) break;
                }
            }
            if (po != 0)
                System.out.println("REACHABLE");
            else
                System.out.println("GARDEN OF EDEN");
        }

    }

    static void back(int a) {
        int i;
        if (a == n - 1) {
            if (am[pc[a-1] * 4 + pc[a]*2 + pc[0]] == cl[a] && am[pc[a]*4 + pc[0]*2 + pc[1]] == cl[0]) {
                po = 1;
            }
            return;
        }
        for (i = pc[a-1]*4 + pc[a]*2; i <= pc[a-1]*4 + pc[a]*2 + 1; i++) {
            if (am[i] == cl[a]) {
                pc[a + 1] = i % 2;
                back(a + 1);
                if (po != 0) break;
            }
        }


    }


}