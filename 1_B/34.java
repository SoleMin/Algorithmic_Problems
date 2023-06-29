import java.io.*;

public class B {
    public static void main (String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(b.readLine());
        while (n-- > 0) {
            String s = b.readLine();
            if (s.matches("^[A-Z]+[0-9]+$")) {
                System.out.println(toRC(decodeCR(s)));
            } else {
                System.out.println(toCR(decodeRC(s)));
            }
        }
    }
    private static String toRC(int[] a) {
        return "R" + a[0] + "C" + a[1];
    }
    private static String toCR(int[] a) {
        String r = "";
        if (a[1] == 1) {
            r = "A";
        } else {
            for (int x = a[1]; x > 0; x /= 26) {
                r = (char)('A' + (x - 1) % 26) + r;
                if (x % 26 == 0) x -= 26;
            }
        }
        return r + a[0];
    }
    private static int[] decodeCR(String s) {
        int[] a = new int[2];
        int i = 0;
        while (s.charAt(i) >= 'A') {
            a[1] = a[1] * 26 + (s.charAt(i) - 'A' + 1);
            i++;
        }
        a[0] = Integer.parseInt(s.substring(i));
        // System.out.println("decoding CR: " + s + "..." + a[0] + ", " + a[1]);
        return a;
    }
    private static int[] decodeRC(String s) {
        assert s.charAt(0) == 'R';
        int[] a = new int[2];
        a[0] = Integer.parseInt(s.substring(1, s.indexOf('C')));
        a[1] = Integer.parseInt(s.substring(s.indexOf('C') + 1));
        // System.out.println("decoding RC: " + s + "..." + a[0] + ", " + a[1]);
        return a;
    }
}
