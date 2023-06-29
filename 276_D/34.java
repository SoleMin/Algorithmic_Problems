
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Abhimanyu Singh
 *
 */
public class LittleGirlAndMaximumXOR {

    private InputStream input;
    private PrintStream output;
    private Scanner inputSc;
    static final boolean ONE = true;
    static final boolean ZERO = false;
    char dp[][][];

    public LittleGirlAndMaximumXOR(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
        init();
    }

    private void init() {
        inputSc = new Scanner(input);
    }

    static int lineToInt(String line) {
        return Integer.parseInt(line);
    }

    public void solve() {
        solveTestCase(1);
    }

    void fill(char a[], long value) {
        String str = Long.toBinaryString(value);
        char array[] = str.toCharArray();
        int len = array.length;
        int index = 63;
        while (len > 0) {
            a[index] = array[len - 1];
            len--;
            index--;
        }
    }

    void init(char a[]) {
        for (int i = 0; i < 64; i++) {
            a[i] = '0';
        }
    }

    /*
     char[] getMax0(char lBit[], char rBit[], int lIndex, int rIndex) {
     char ans[]=new char[64];
     if(lIndex)
     }
    

     char[] getMax(char lBit[], char rBit[], int lIndex, int rIndex) {
     }*/
    private void solveTestCase(int testN) {
        long l = inputSc.nextLong();
        long r = inputSc.nextLong();
        char lBit[] = new char[64];
        char rBit[] = new char[64];
        init(lBit);
        init(rBit);
        fill(lBit, l);
        fill(rBit, r);
        int i = 0;
        char ansBit[] = new char[64];
        char a[] = new char[64];
        char b[] = new char[64];
        init(a);
        init(b);
        init(ansBit);
        for (; i < 64; i++) {
            if (lBit[i] == '0' && rBit[i] == '0') {
            } else if (lBit[i] == '1' && rBit[i] == '0') {
                throw new RuntimeException("Wrong Input");
            } else if (lBit[i] == '0' && rBit[i] == '1') {
                a[i] = '0';
                b[i] = '1';
                break;
            } else {
                a[i] = '1';
                b[i] = '1';
            }
        }
        boolean aLessB = true;
        boolean aBig = false;
        boolean bSmall = false;
        for (; i < 64; i++) {
            if (lBit[i] == '0' && rBit[i] == '0') {
                a[i] = '1';
                b[i] = '0';
                aBig = true;
            } else if (lBit[i] == '1' && rBit[i] == '0') {
                a[i] = '1';
                b[i] = '0';
            } else if (lBit[i] == '0' && rBit[i] == '1') {
                a[i] = '0';
                b[i] = '1';
            } else {
                a[i] = '1';
                b[i] = '0';
                bSmall = true;
            }
        }
        for (i = 0; i < 64; i++) {
            if (a[i] == '0' && b[i] == '0') {
                ansBit[i] = '0';
            } else if (a[i] == '1' && b[i] == '0') {
                ansBit[i] = '1';
            } else if (a[i] == '0' && b[i] == '1') {
                ansBit[i] = '1';
            } else {
                ansBit[i] = '0';
            }
        }
        String ansStr = new String(ansBit);
        long ansValue = Long.parseLong(ansStr, 2);
        output.println(ansValue);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LittleGirlAndMaximumXOR lgamx = new LittleGirlAndMaximumXOR(System.in, System.out);
        lgamx.solve();
    }
}
