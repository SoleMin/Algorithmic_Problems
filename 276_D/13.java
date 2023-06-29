import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        new D().solve();
    }

    void solve() throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] sp;

        long L = sc.nextLong();
        long R = sc.nextLong();
        if (L == R) {
            System.out.println(0);
        } else {
            System.out.println(Long.highestOneBit(R ^ L) * 2 - 1);
        }
    }
}

//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
