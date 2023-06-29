
import java.io.*;
import java.util.StringTokenizer;

class Main {
    static final int MAXMOVE = 50;
    static int MAXDEPTH;
    static int[][] map;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[] movechar = {'U', 'R', 'D', 'L'};
    static boolean solved;
    static int mtop;
    static int[] movestack = new int [MAXMOVE];
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String buf = input.readLine();
        int testCase = Integer.parseInt(buf);
        for (int i = 0; i < testCase; i++) {
            input();
            mtop = 0;
            solved = false;
            solve();
            output();
        }
    }

    public static void input() throws IOException {
        map = new int[4][4];
        StringTokenizer token;
        for (int i = 0; i < 4; i++) {
            token = new StringTokenizer(input.readLine());
            for (int j = 0; j < 4; j++)
                map[i][j] = Integer.parseInt(token.nextToken());
        }
    }

    public static void output() {
        if (solved) {
            for (int i = 0; i < mtop; i++)
                System.out.print(movechar[movestack[i]]);
            System.out.println();
        } else
            System.out.println("This puzzle is not solvable.");
    }

    public static int cost() {
        int a = 0, b = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (map[i][j] != 0)
                    a += Math.abs(i - ((map[i][j] - 1) / 4));

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (map[i][j] != 0)
                    b += Math.abs(j - ((map[i][j] - 1) % 4));

        return a + b;
    }

    public static void solve() {
        int value = 0, x = 0, y = 0, l;
        for (int i =0 ; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (map[i][j] == 0){
                    value += i;
                    x = i;
                    y = j;
                }
                for (int k = i; k < 4; k++){
                    if (k == i)
                        l = j + 1;
                    else
                        l = 0;
                    for (; l < 4; l++)
                        if (map[k][l] != 0 && map[i][j] > map[k][l])
                            value++;
                }
            }
        }
        if (value % 2 ==0)
            return;
        for (MAXDEPTH = cost(); !solved && MAXDEPTH <= MAXMOVE; MAXDEPTH+= 2)
            back (0, x, y);
    }

    public static void back(int a, int nowx, int nowy){
        int i, c;
        int nextx, nexty;
        c = cost();
        if (c == 0){
            solved = true;
            return;
        }
        if (a + c > MAXDEPTH) return;
        for ( i = 0; i < 4; i++){
            if (mtop > 0 && (movestack[mtop - 1] + 2) % 4 == i)
                continue;
            movestack[mtop++] = i;
            nextx = nowx + move[i][0];
            nexty = nowy + move[i][1];
            if (nextx >= 4 || nexty >= 4 || nextx <0 || nexty <0)
            {
                mtop--;
                continue;
            }
            map[nowx][nowy] = map[nextx][nexty];
            map[nextx][nexty] = 0;
            back(a + 1, nextx, nexty);
            if (solved) return;
            mtop--;
            map[nextx][nexty] = map[nowx][nowy];
            map[nowx][nowy] = 0;
        }
    }
}