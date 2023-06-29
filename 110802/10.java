import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static final int MAXMOVE = 50;
    static int MAXDEPTH;
    static int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[] moveChar = {'U', 'R', 'D', 'L'};
    static int mTop;
    static boolean solved;
    static int[] moveStack = new int[MAXMOVE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            arr = new int[4][4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            mTop = 0;
            solved = false;
            solve();

            if (solved) {
                for (int i = 0; i < mTop; i++) {
                    sb.append(moveChar[moveStack[i]]);
                }
            } else {
                sb.append("This puzzle is not solvable.");
            }
            sb.append('\n');


        }

        System.out.println(sb);

    }

    public static int cost() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] != 0) sum += Math.abs(i - ((arr[i][j] - 1) / 4)) + Math.abs(j - ((arr[i][j] - 1) % 4));
            }
        }

        return sum;
    }

    public static void backTracking(int a, int startI, int startJ) {
        int c = cost();
        if (c == 0) {
            solved = true;
            return;
        }
        if (a + c > MAXDEPTH) return;

        for (int i = 0; i < 4; i++) {
            // U - D , L - R 반복하지 않게 하기 위함.
            if (mTop > 0 && (moveStack[mTop - 1] + 2) % 4 == i) continue;
///////////////////
            int newI = startI + move[i][0];
            int newJ = startJ + move[i][1];
            if(newI>=0 && newI<4 && newJ>=0 && newJ<4) {
                moveStack[mTop++] = i;
//                System.out.println(Arrays.toString(moveStack));
                arr[startI][startJ] = arr[newI][newJ];
                arr[newI][newJ] = 0;
                backTracking(a + 1, newI, newJ);
                arr[newI][newJ] = arr[startI][startJ];
                arr[startI][startJ] = 0;
                if (solved) return;
                mTop--;
            }
///////////////////



        }





    }

    public static void solve() {
        int value = 0;
        int x = 0;
        int y = 0;
        int l = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == 0) {
                    value += i;
                    x = i;
                    y = j;
                }
                for (int k = i; k < 4; k++) {
                    if (k == i) l = j + 1;
                    else l = 0;
                    for (; l < 4; l++) {
                        if (arr[k][l] != 0 && arr[i][j] > arr[k][l]) value++;
                    }
                }
            }
        }
        if ((value % 2) == 0) return;
        for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH += 2) backTracking(0, x, y);
    }
}