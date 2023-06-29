import java.util.Scanner;

public class Main {

    static int MAXL = 100;
    static int n, carLength, carLengthSum, max;
    static int[][] dynamic = new int[MAXL * 100 + 1][2];
    static int[][][] from = new int[MAXL * 2 + 1][MAXL * 100 + 1][2];
    static int top;
    static int[] stack = new int[MAXL * 2];

    static void solve(int carNum){
        for (int i = n; i >= carLength; i--){
            if (dynamic[i - carLength][0] != -1 && carLengthSum - i + carLength <= n && dynamic[i][0] < carNum){
                dynamic[i][0] = carNum;
                dynamic[i][1] = carLengthSum - i + carLength;
                from[carNum][i][0] = dynamic[i - carLength][0];
                from[carNum][i][1] = carLength;
                if (dynamic[max][0] < dynamic[i][0] || (dynamic[max][0] == dynamic[i][0] && Math.abs(max - dynamic[max][1]) > Math.abs(i - dynamic[i][1])))
                    max = i;
            }
        }
    }

    static void output(int t){
        int k = top = 0;
        for (int i = dynamic[max][0]; i > 0; i = from[i][k][0]){
            int j = max;
            j -= from[i][k][1];
            stack[top++] = 1;
            for (k = i - 1; k > from[i][j][0]; k--){
                stack[top++] = 0;
            }
            k = j;
        }
        if (t > 0)
            System.out.println("");

        System.out.println(dynamic[max][0]);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcaseNum = scan.nextInt();
        scan.nextLine();
        scan.nextLine();

        for (int testcase = 0; testcase < testcaseNum; testcase++){
            n = scan.nextInt();
            n *= 100;
            scan.nextLine();
            for (int j = 0; j <= n; j++){
                dynamic[j][0] = -1;
                dynamic[j][1] = 0;
            }
            dynamic[0][0] = 0;
            carLengthSum = 0;
            max = 0;

            int j = 0;
            while (true){
                carLength = scan.nextInt();
                if (carLength == 0)
                    break;
                scan.nextLine();

                solve(j + 1);
                carLengthSum += carLength;
                j++;

            }
            output(testcase);
            scan.nextLine();
        }
    }

}