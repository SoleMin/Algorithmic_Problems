
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] S = in.readLine().split(" ");
        int[] A = new int[n];
        boolean allOnes = true;
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(S[i]);
            allOnes &= A[i] == 1;
        }
        Arrays.sort(A);
        if (A[A.length - 1] > 1)
            A[A.length - 1] = 1;
        else
            A[A.length - 1] = 2;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }
}
