import java.util.Scanner;

public class Main {

    static int maxDepth = 16;
    static int[][] remainTo = {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
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
    static int[] finalState = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1};
    static int[] state = new int[24];
    static int[] point = new int[2];
    static int[] count = new int[2];
    static int[] stack = new int[maxDepth];
    static int[] result = new int[maxDepth];
    static int rn;
    static boolean solvable;

    static int left(int base, int offset){
        if (base < 12) {
            base += offset;
            if (base >= 12)
                base -= 12;
        }
        else {
            base += offset;
            if (base >= 24)
                base -= 12;
        }
        return base;
    }

    static int right(int base, int offset){
        if (base < 12) {
            base -= offset;
            if (base < 0)
                base += 12;
        }
        else {
            base -= offset;
            if (base < 12)
                base += 12;
        }
        return base;
    }

    static void backtrack(int a){
        int temp1, temp2;
        if (a == rn)
            return;

        boolean isSame = true;

        for (int i = 0; i < 12 && isSame; i++){
            if (state[left(point[0], i)] != finalState[i])
                isSame = false;
        }
        for (int i = 0; i < 12 && isSame; i++){
            if (state[left(point[1], i)] != finalState[i + 12])
                isSame = false;
        }

        if (isSame){
            for (int i = 0; i < a; i++){
                result[i] = stack[i];
            }
            rn = a;
            solvable = true;
            return;
        }
        int minMove = 0;
        for (int i = 0; i < 21; i++){
            temp1 = state[left(point[i / 12], i % 12)];

            if (minMove < remainTo[i / 2][temp1])
                minMove = remainTo[i / 2][temp1];
        }
        if (a == maxDepth || a + minMove > maxDepth || a + minMove >= rn)
            return;

        for (int i = 1; i <= 4; i++){
            if (a >= rn - 1)
                break;
            stack[a] = i;
            switch (i) {
                case 1:
                    if (count[0] > 0 || count[0] == -5)
                        break;
                    point[0] = right(point[0], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    temp1 = count[0];
                    temp2 = count[1];
                    count[0]--;
                    count[1] = 0;

                    backtrack(a + 1);

                    count[0] = temp1;
                    count[1] = temp2;

                    point[0] = left(point[0], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    break;
                case 2:
                    if (count[1] > 0 || count[1] == -5)
                        break;
                    point[1] = left(point[1], 2); // 8
                    for (int j = 1; j <= 3; j++){
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    temp1 = count[0];
                    temp2 = count[1];
                    count[0] = 0;
                    count[1]--;

                    backtrack(a + 1);

                    count[0] = temp1;
                    count[1] = temp2;

                    point[1] = right(point[1], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    break;
                case 3:
                    if (count[0] < 0 || count[0] == 5)
                        break;
                    point[0] = left(point[0], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    temp1 = count[0];
                    temp2 = count[1];
                    count[0]++;
                    count[1] = 0;

                    backtrack(a + 1);

                    count[0] = temp1;
                    count[1] = temp2;

                    point[0] = right(point[0], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[1], j)] = state[right(point[0], j)];
                    }
                    break;
                case 4:
                    if (count[1] < 0 || count[1] == 5)
                        break;
                    point[1] = right(point[1], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    temp1 = count[0];
                    temp2 = count[1];
                    count[0] = 0;
                    count[1]++;

                    backtrack(a + 1);

                    count[0] = temp1;
                    count[1] = temp2;

                    point[1] = left(point[1], 2);
                    for (int j = 1; j <= 3; j++){
                        state[right(point[0], j)] = state[right(point[1], j)];
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcase_num = scan.nextInt();
        scan.nextLine();

        for (int testcase = 0; testcase < testcase_num; testcase++){
            for (int i = 0; i < 24; i++){
                state[i] = scan.nextInt();
            }
            scan.nextLine();

            count[0] = count[1] = 0;
            point[0] = 0;
            point[1] = 12;
            rn = maxDepth + 1;
            solvable = false;
            backtrack(0);

            if (solvable){
                if (rn == 0)
                    System.out.println("PUZZLE ALREADY SOLVED");
                else {
                    for (int i = 0; i < rn; i++){
                        System.out.print(result[i]);
                    }
                    System.out.println("");
                }
            }
            else
                System.out.println("NO SOLUTION WAS FOUND IN 16 STEPS");
        }
    }
}