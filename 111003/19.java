import java.util.Scanner;

public class Main {

    static int Inf = 9999999;
    static int[] f_pos = new int[101];
    static int[][] dis = new int[501][501];

    static void initialize(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                dis[i][j] = Inf;
            }
            dis[i][i] = 0;
        }
    }

    static void floyd(int n){
        for (int k = 1; k <= n; ++k){
            for (int i = 1; i <=n; ++i){
                for (int j = 1; j <= n; ++j){
                    if (dis[i][k] + dis[k][j] < dis[i][j])
                        dis[i][j] = dis[i][k] + dis[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int testcaseNum = scan.nextInt();
        scan.nextLine();
        scan.nextLine();

        for (int testcase = 0; testcase < testcaseNum; testcase++){
            int num_fs = scan.nextInt();
            int num_is = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < num_fs; i++){
                f_pos[i] = scan.nextInt();
            }
            scan.nextLine();

            initialize(num_is);

            String str;

            while (scan.hasNextLine()){
                str = scan.nextLine();
                if (str.equals(""))
                    break;

                String[] input = str.split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                int L = Integer.parseInt(input[2]);

                dis[x][y] = L;
                dis[y][x] = L;
            }

            floyd(num_is);

            int[] shortestLen = new int[501];
            int maxShortestLen = 0;

            for (int i = 0; i <= num_is; ++i){
                shortestLen[i] = Inf;
                for (int j = 0; j < num_fs; ++j){
                    shortestLen[i] = Math.min(shortestLen[i], dis[i][f_pos[j]]);
                }
                maxShortestLen = Math.max(maxShortestLen, shortestLen[i]);
            }

            int ans = 1;
            int min = 10000;
			
            for (int i = 1; i <= num_is; ++i) {
                int[] tempPos = f_pos;
                int[] tempShortest = new int[501];
                int tempMax = 0;
                boolean judge = true;
				
                for (int j = 0; j < num_fs; j++){
                    if (f_pos[j] == i) {
                        judge = false;
                        continue;
                    }
                    tempPos[num_fs] = i;
                }
                if (!judge)
                    continue;

                for (int j = 0; j <= num_is; ++j){
                    tempShortest[j] = Inf;
                    for (int k = 0; k < num_fs + 1; ++k){
                        tempShortest[j] = Math.min(tempShortest[j], dis[j][tempPos[k]]);
                    }
                    tempMax = Math.max(tempMax, tempShortest[j]);
                }

                if (min > tempMax){
                    min = tempMax;
                    ans = i;
                }
            }
            System.out.println(ans);

            if (testcase != testcaseNum - 1)
                System.out.println("");
        }
    }
}
