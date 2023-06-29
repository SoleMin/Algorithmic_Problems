import java.io.*;
import java.util.*;

public class A {
    private static Scanner sc = new Scanner(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException {
        BitSet b = new BitSet(1001);
        BitSet p = primes(1001);
        for (int i = 0; i < ps.length - 1; i++) {
            b.set(ps[i] + ps[i+1] + 1);
        }
        int n = sc.nextInt(), k = sc.nextInt();
        for (int x = 0; x <= n; x++) {
            if (b.get(x) && p.get(x)) k--;
        }
        System.out.println(k > 0 ? "NO" : "YES");
    }

    private static BitSet primes (int n) {
        BitSet b = new BitSet(n+1);
        b.set(2, n);
        for (int p = 2; p <= n; p++) {
            if (b.get(p)) {
                for (int x = p * 2; x <= n; x += p) {
                    b.clear(x);
                }
            }
        }
        return b;
    }
        private static int [] ps = new int[] {2,
                3,
                5,
                7,
                11,
                13,
                17,
                19,
                23,
                29,
                31,
                37,
                41,
                43,
                47,
                53,
                59,
                61,
                67,
                71,
                73,
                79,
                83,
                89,
                97,
                101,
                103,
                107,
                109,
                113,
                127,
                131,
                137,
                139,
                149,
                151,
                157,
                163,
                167,
                173,
                179,
                181,
                191,
                193,
                197,
                199,
                211,
                223,
                227,
                229,
                233,
                239,
                241,
                251,
                257,
                263,
                269,
                271,
                277,
                281,
                283,
                293,
                307,
                311,
                313,
                317,
                331,
                337,
                347,
                349,
                353,
                359,
                367,
                373,
                379,
                383,
                389,
                397,
                401,
                409,
                419,
                421,
                431,
                433,
                439,
                443,
                449,
                457,
                461,
                463,
                467,
                479,
                487,
                491,
                499};
}

