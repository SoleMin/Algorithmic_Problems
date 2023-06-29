import java.util.Scanner;

public class A1_958 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        char[][] A = new char[N][];
        for (int r=0; r<N; r++) {
            A[r] = in.next().toCharArray();
        }
        char[][] B = new char[N][];
        for (int r=0; r<N; r++) {
            B[r] = in.next().toCharArray();
        }
        boolean found = false;
        for (int flip=0; flip<2; flip++) {
            for (int rotation=0; rotation<4; rotation++) {
                boolean match = true;
                for (int r=0; r<N; r++) {
                    for (int c=0; c<N; c++) {
                        int rr = r;
                        int cc = c;
                        if (flip != 0) {
                            rr = N-1-rr;
                        }
                        for (int i=0; i<rotation; i++) {
                            int newrr = cc;
                            int newcc = N-1-rr;
                            rr = newrr;
                            cc = newcc;
                        }
                        if (A[r][c] != B[rr][cc]) {
                            match  = false;
                        }
                    }
                }
                if (match) {
                    found = true;
                }
            }
        }
        System.out.println(found ? "Yes" : "No");
    }

}
