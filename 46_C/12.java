import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        s.nextLine();
        String l = s.nextLine();
        char[] ca = l.toCharArray();
        int h = 0;
        for (char c : ca)
            h += A(c);
        int cur = h;
        int i;
        for (i = 0; i < h; i++)
            cur -= A(ca[i]);
        int best = cur;
        while (i != h + len) {
            cur -= A(ca[i % len]);
            cur += A(ca[(i - h) % len]);
            best = best > cur ? cur : best;
            i++;
        }
        System.out.println(best);
    }

    public static int A(char x) {
        return x == 'H' ? 1 : 0;
    }
}
