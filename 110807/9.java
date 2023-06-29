import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] remainTo = new int[][]{
            {0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
            {1, 2, 2, 0, 0, 1, 2, 3, 4, 4, 4},
            {0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
            {1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
            {0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
            {1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
            {0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
            {1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
            {0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
            {1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
            {0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}};

    static int[] finalState = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9,
            10, 9, 0, 1, 2, 1};

    static int[] state, point, count, stack, result;
    static int rn;
    static boolean solveAble;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            state = new int[24];
            point = new int[2];
            count = new int[2];
            stack = new int[16];
            result = new int[16];
            rn = 17;
            point[1] = 12;
            solveAble = false;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 24; i++) {
                state[i] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(state));


            backTracking(0);


            if (solveAble) {
                if (rn == 0) sb.append("PUZZLE ALREADY SOLVED");
                else {
                    for (int i = 0; i < rn; i++) {
                        sb.append(result[i]);
                    }
                }
            } else {
                sb.append("NO SOLUTION WAS FOUND IN 16 STEPS");
            }
            sb.append('\n');
        }
        System.out.println(sb);


    }

    public static void backTracking(int depth) {
//        if(depth==16) {
//            System.out.println(Arrays.toString(stack));
//        }
//        if (stack[0] == 1 && stack[1] == 4 && stack[2] == 3 && stack[3] == 4 && stack[4] == 3 &&
//                stack[5] == 3 && stack[6] == 2 && stack[7] == 3 && stack[8] == 3 && stack[9] == 4)
//            System.out.println(Arrays.toString(stack));


        if (depth == rn) return;
        boolean isSame = true;
        for (int i = 0; i < 12 && isSame; i++) {
            if (state[left(point[0], i)] != finalState[i] || state[left(point[1], i)] != finalState[i + 12]) isSame = false;
        }


        if (isSame) {
            for (int i = 0; i < depth; i++) {
                result[i] = stack[i];
            }
            rn = depth;
            solveAble = true;
            return;
        }

        int minMove = 0;
        for (int i = 0; i < 21; i++) {
            int tmp1 = state[left(point[i / 12], i % 12)];
            minMove = Math.max(minMove, remainTo[i / 2][tmp1]);
        }

        if (depth == 16 || depth + minMove > 16 || depth + minMove >= rn) return;

        for (int i = 1; i <= 4; i++) {
            if (depth >= rn - 1) break;
            stack[depth] = i;
            int tmp1, tmp2;
            switch (i) {
                case 1 -> {
                    if (count[0] > 0 || count[0] == -5) break;
                    point[0] = right(point[0], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    tmp1 = count[0];
                    tmp2 = count[1];
                    count[0]--;
                    count[1] = 0;
                    backTracking(depth + 1);
                    count[0] = tmp1;
                    count[1] = tmp2;
                    point[0] = left(point[0], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                }

                // 1. for 내부
                // 2. 5번연속/ 왼-오 연속 판단 부분 (첫째줄)
                case 2 -> {
                    if (count[1] < 0 || count[1] == 5) break;
                    point[1] = left(point[1], 2);
                    for (int j = 1; j <= 3; j++) {
                        //
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    //
                    tmp1 = count[0];
                    tmp2 = count[1];
                    count[0] = 0;
                    count[1]++;
                    backTracking(depth + 1);
                    count[0] = tmp1;
                    count[1] = tmp2;
                    point[1] = right(point[1], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                }
                case 3 -> {
                    if (count[0] < 0 || count[0] == 5) break;
                    point[0] = left(point[0], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    tmp1 = count[0];
                    tmp2 = count[1];
                    count[0]++;
                    count[1] = 0;
                    backTracking(depth + 1);
                    count[0] = tmp1;
                    count[1] = tmp2;
                    point[0] = right(point[0], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                }
                case 4 -> {
                    if (count[1] > 0 || count[1] == -5) break;
                    point[1] = right(point[1], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    tmp1 = count[0];
                    tmp2 = count[1];
                    count[0] = 0;
                    count[1]--;
                    backTracking(depth + 1);
                    count[0] = tmp1;
                    count[1] = tmp2;
                    point[1] = left(point[1], 2);
                    for (int j = 1; j <= 3; j++) {
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }

                }
            }
        }
    }

    public static int left(int base, int offset) {
        if (base < 12) {
            base += offset;
            if (base >= 12) base -= 12;
        } else {
            base += offset;
            if (base >= 24) base -= 12;
        }
        return base;
    }

    public static int right(int base, int offset) {
        if (base < 12) {
            base -= offset;
            if (base < 0) base += 12;
        } else {
            base -= offset;
            if (base < 12) base += 12;
        }
        return base;
    }


}