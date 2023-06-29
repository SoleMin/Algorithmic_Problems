
import java.io.*;
import java.util.StringTokenizer;

class Main {
    static final int MAXMOVE = 50;
    static int MAXDEPTH;
    static int[][] puzzle;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[] movechar = {'U', 'R', 'D', 'L'};
    static boolean solved;
    static int mtop;
    static int[] movestack = new int [MAXMOVE];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String buff = br.readLine();
        int test_num = Integer.parseInt(buff);
        for (int i = 0; i < test_num; i++) {
            input();
            mtop = 0;
            solved = false;
            solve();
            output();
        }
    }

    public static void input() throws IOException {
        puzzle = new int[4][4];
        StringTokenizer tk;
        for (int i = 0; i < 4; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                puzzle[i][j] = Integer.parseInt(tk.nextToken());
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
        int md1 = 0, md2 = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (puzzle[i][j] != 0)
                    md1 += Math.abs(i - ((puzzle[i][j] - 1) / 4));

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (puzzle[i][j] != 0)
                    md2 += Math.abs(j - ((puzzle[i][j] - 1) % 4));

        return md1 + md2;
    }

    public static void solve() {
        int value, x, y, l;
        value = 0;
				x = 0;
				y = 0;
        for (int i =0 ; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (puzzle[i][j] == 0){
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
                        if (puzzle[k][l] != 0 && puzzle[i][j] > puzzle[k][l])
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
            if (nextx <0 || nextx >= 4 || nexty <0 || nexty >= 4)
            {
                mtop--; continue;
            }
            puzzle[nowx][nowy] = puzzle[nextx][nexty];
            puzzle[nextx][nexty] = 0;
            
            back(a + 1, nextx, nexty);
            if (solved) return;
            mtop--;

						puzzle[nextx][nexty] = puzzle[nowx][nowy];
            puzzle[nowx][nowy] = 0;
					
        }
    }
}