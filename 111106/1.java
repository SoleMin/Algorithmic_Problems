
import java.io.*;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Stack;

class Main {
    static int testCase, peri, carlengthsum, max, carLength;
    static int [][] dynamic;
    static int [][][]from;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < testCase; i++){
            input();
            print(i);
        }
    }
    public static void init() throws IOException {
        String buf;
        buf = input.readLine();
        testCase = Integer.parseInt(buf);
    }
    public static void input() throws IOException {
        input.readLine();
        stack.empty();
        dynamic = new int [20001][2];
        from = new int [201][10001][2];
        String buf;
        buf = input.readLine();
        peri = Integer.parseInt(buf);
        peri *= 100;
        for (int i = 0; i <= peri; i++){
            dynamic[i][0] = -1;
            dynamic[i][1] = 0;
        }
        dynamic[0][0] = 0;
        carlengthsum = 0;
        max = 0;
        carLength = Integer.parseInt(input.readLine());
        int i = 0;
        while(carLength != 0){
            if (carlengthsum <= 2 * peri){
                solve(i+1);
                carlengthsum += carLength;
            }
            i++;
            carLength = Integer.parseInt(input.readLine());
        }
    }
    public static void solve(int carnum){
        int i;
        for (i = peri; i>= carLength; i--){
            if (dynamic[i-carLength][0] != -1 && carlengthsum -i + carLength <= peri && dynamic[i][0] < carnum){
                dynamic[i][0] =carnum;
                dynamic[i][1] = carlengthsum - i + carLength;
                from[carnum][i][0] = dynamic[i - carLength][0];
                from[carnum][i][1] = carLength;
                if (dynamic[max][0] < dynamic[i][0] || (dynamic[max][0] == dynamic[i][0] && Math.abs(max - dynamic[max][1]) > Math.abs(i - dynamic[i][1])))
                    max = i;
            }
        }
    }
    public static void print(int t){

        if (t > 0)
            System.out.println();
        System.out.println(dynamic[max][0]);

    }
}