import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] initial = new int[4];
    static int[][] banned;
    static boolean[][][][] visited;
    static int[][][][] count;

    static boolean isValid(int[] arr){
        boolean result = true;
        for (int i = 0; i < banned.length; i++){
            int count = 0;
            for (int j = 0; j < 4; j++){
                if (banned[i][j] == arr[j])
                    count += 1;
            }
            if (count == 4)
                result = false;
        }
        return result;
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[10][10][10][10];
        count = new int[10][10][10][10];
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count.length; j++){
                for (int k = 0; k < count.length; k++){
                    Arrays.fill(count[i][j][k], 1000000000);
                }
            }
        }

        q.add(initial);
        visited[initial[0]][initial[1]][initial[2]][initial[3]] = true;
        count[initial[0]][initial[1]][initial[2]][initial[3]] = 0;

        while (!q.isEmpty()){
            int[] now = q.poll();
            int[] arr = {now[0], now[1], now[2], now[3]};
            visited[arr[0]][arr[1]][arr[2]][arr[3]] = true;
            int nowCount = count[arr[0]][arr[1]][arr[2]][arr[3]];

            for (int i = 0; i < arr.length; i++){
                int temp = arr[i];

                arr[i]++;
                arr[i] %= 10;

                int[] next = {arr[0], arr[1], arr[2], arr[3]};
                if (isValid(next) && !visited[arr[0]][arr[1]][arr[2]][arr[3]] && nowCount + 1 < count[next[0]][next[1]][next[2]][next[3]]){
                    count[next[0]][next[1]][next[2]][next[3]] = nowCount + 1;
                    q.add(next);
                }

                arr[i] = temp - 1;
                if (arr[i] == -1)
                    arr[i] = 9;

                next = new int[]{arr[0], arr[1], arr[2], arr[3]};
                if (isValid(next) && !visited[arr[0]][arr[1]][arr[2]][arr[3]] && nowCount + 1 < count[next[0]][next[1]][next[2]][next[3]]){
                    count[next[0]][next[1]][next[2]][next[3]] = nowCount + 1;
                    q.add(next);
                }
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcase_num = scan.nextInt();
        scan.nextLine();
        scan.nextLine();

        for (int testcase = 0; testcase < testcase_num; testcase++) {

            for (int i = 0; i < 4; i++) {
                initial[i] = scan.nextInt();
            }
            scan.nextLine();

            int[] target = new int[4];

            for (int i = 0; i < 4; i++) {
                target[i] = scan.nextInt();
            }
            scan.nextLine();

            int banned_num = scan.nextInt();
            scan.nextLine();

            banned = new int[banned_num][4];

            for (int i = 0; i < banned_num; i++) {
                for (int j = 0; j < 4; j++){
                    banned[i][j] = scan.nextInt();
                }
                scan.nextLine();
            }

            bfs();

            int result = count[target[0]][target[1]][target[2]][target[3]];

            if (result >= 1000000000)
                System.out.println("-1");
            else
                System.out.println(result);
        }
    }
}