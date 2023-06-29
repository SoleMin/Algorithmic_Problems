import java.util.Arrays;
import java.util.Scanner;

public class Round113_A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt() - 1;
        Obe[] a = new Obe[n];
        for (int i = 0; i < n; i++)
            a[i] = new Obe(in.nextInt(), in.nextInt());

        Arrays.sort(a);
        int c = 0;

        int p = 0, d = 0;
        if (k > -1 && k < n) {
            c = 1;
            p = a[k].p;
            d = a[k].d;
        } else {
            System.out.println(c);
            return;
        }
        for (int i = k + 1; i < n; i++) {
            if (a[i].p == p && a[i].d == d)
                c++;
        }
        for (int i = k - 1; i > -1; i--) {
            if (a[i].p == p && a[i].d == d)
                c++;
        }
        System.out.println(c);
    }

}

class Obe implements Comparable<Obe> {

    int p, d;

    public Obe(int pe, int de) {
        p = pe;
        d = de;
    }

    @Override
    public int compareTo(Obe o) {
        int x = new Integer(o.p).compareTo(this.p);
        if (x != 0)
            return x;
        return new Integer(this.d).compareTo(o.d);
    }

}