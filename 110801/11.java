import java.util.Scanner;

public class Main {
    static int[][] board;
    static int board_size;
    static int bishop_num;
    static int count;

    static boolean is_promising(int r, int c){
        if (board[r][c] == 1)
            return false;
        for (int i = 1; i <= Math.min(r, c); i++){
            if (board[r-i][c-i] == 1)
                return false;
        }
        for (int i = 1; i <= Math.min(r, board_size - 1 - c); i++){
            if (board[r-i][c+i] == 1)
                return false;
        }
        return true;
    }

    static void backtrack(int x, int y, int cnt, int[][] board) {
        if (cnt == 0){
            count += 1;
            return;
        }
        if (x == board_size - 1 && y >= board_size)
            return;
        if (x >= board_size)
            return;
        if (y >= board_size){
            x += 1;
            y = 0;
        }
        if (is_promising(x, y)){
            board[x][y] = 1;
            backtrack(x, y + 1, cnt - 1, board);
            board[x][y] = 0;
        }
        backtrack(x, y + 1, cnt, board);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()){
            count = 0;
            board_size = scan.nextInt();

            if (board_size == 0)
                break;

            bishop_num = scan.nextInt();
            board = new int[board_size][board_size];

            if (board_size == 1 && bishop_num == 1) {
                System.out.println(1);
                continue;
            }
            backtrack(0, 0, bishop_num, board);
            System.out.println(count);

            scan.nextLine();
        }
    }
}