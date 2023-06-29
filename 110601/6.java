import java.io.*;
class Main {
    private static int MAXDIGIT = 100;
    private static int[] a,b;
    private static char[][] fib = new char[3][MAXDIGIT + 1];
    private static int lengtha, lengthb;
    private static int[] length = new int[3];
    private static int result;

    static int input(BufferedReader br) throws Exception{

        String tempa = "";
        String tempb = "";
        a = new int[MAXDIGIT + 1];
        b = new int[MAXDIGIT + 1];
        String input = br.readLine();
        tempa = input.split(" ")[0];
        tempb = input.split(" ")[1];

        lengtha = tempa.length();
        lengthb = tempb.length();

        if(tempa.equals("0") && tempb.equals(("0")))
            return 0;
        for(int i = 0; i < lengtha; i++)
            a[i] = tempa.charAt(lengtha - i - 1) - '0';
        for(int i = 0; i < lengthb; i++)
            b[i] = tempb.charAt(lengthb - i - 1) - '0';

        return 1;

    }

    static int compare(int fi, int[] numb, int len) {
        if(length[fi] < len)
            return -1;
        if(length[fi] > len)
            return 1;

        for(int i = len - 1; i >= 0; i--) {
            if(fib[fi][i] < numb[i])
                return -1;
            if(fib[fi][i] > numb[i])
                return 1;
        }
        return 0;
    }

    static void plus(int target, int a, int b) {
        int len = 0, carry = 0;
        for(; len < length[a] && len < length[b]; len++) {
            fib[target][len] = (char)(fib[a][len] + fib[b][len] + carry);
            if(fib[target][len] >= 10)
                carry = 1;
            else
                carry = 0;
            fib[target][len] %= 10;
        }
        if(len < length[a]) {
            for(; len < length[a]; len++) {
                fib[target][len] = (char)(fib[a][len] + carry);
                if(fib[target][len] >= 10)
                    carry = 1;
                else
                    carry = 0;
                fib[target][len] %= 10;
            }
        }
        else {
            for(; len < length[b]; len++) {
                fib[target][len] = (char)(fib[b][len] + carry);
                if(fib[target][len] >= 10)
                    carry = 1;
                else
                    carry = 0;
                fib[target][len] %= 10;
            }
        }
        if(carry == 1)
            fib[target][len++] = 1;
        length[target] = len;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        while(input(br) == 1) {
            length[0] = length[1] = 1;
            fib[0][0] = fib[1][0] = 1;
            for(i = 1; compare(i % 3, a, lengtha) < 0; i++)
                plus((i + 1) % 3, i % 3, (i - 1) % 3);

            result = i;
            for(; compare(i % 3, b, lengthb) <= 0; i++)
                plus((i + 1) % 3, i % 3, (i - 1) % 3);

            result = i - result;
            System.out.println(result);
        }

    }
}