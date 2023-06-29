import java.io.*;
import java.util.Scanner;

class Main {
    static int MAX_M = 50;
    static int MAX_N = 50;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        String[] result;
        scan.nextLine();
        for(int tcNum = 0; tcNum < tc; tcNum++) {
            scan.nextLine();
            int inputRow = scan.nextInt();
            int inputCol = scan.nextInt();
            scan.nextLine();
            char[][] grid = new char[MAX_M + 2][MAX_N + 2];
            for(int i = 0; i < MAX_M + 2; i++) {
                for(int j = 0; j < MAX_N + 2; j++) {
                    grid[i][j] = '*';
                }
            }
            for(int i = 1; i <= inputRow; i++) {
                String str = scan.nextLine();
                for(int j = 1; j <= inputCol; j++) {
                    grid[i][j] = str.toUpperCase().charAt(j - 1);
                }
            }
            int searchNum = scan.nextInt();
            result = new String[searchNum];
            scan.nextLine();
            String searchStr = "";
            int matchRow = -1;
            int matchCol = -1;
            for(int i = 0; i < searchNum; i++) {
                searchStr = scan.nextLine().toUpperCase();
                int index = 0;
                loop:
                for(int r = 1; r <= inputRow; r++) {
                    for(int c = 1; c <= inputCol; c++) {
                        if(grid[r][c] == searchStr.charAt(index)) {
                            matchRow = r;
                            matchCol = c;
                            if(searching(grid, searchStr, matchRow, matchCol, index)) {
                                result[i] = matchRow + " " + matchCol;
                                index++;
                                break loop;
                            }
                        }
                    }
                }
            }
            for(int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
            System.out.println();
        }
    }
    static boolean searching(char[][] grid, String searchStr, int row, int col, int index) {
        index++;
        boolean result = false;

        //Top
        if(searchStr.charAt(index) == grid[row - 1][col]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row - i][col]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //Top Right
        if(searchStr.charAt(index) == grid[row - 1][col + 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row - i][col + i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //Right
        if(searchStr.charAt(index) == grid[row][col + 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row][col + i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //Bottom Right
        if(searchStr.charAt(index) == grid[row + 1][col + 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row + i][col + i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //Bottom
        if(searchStr.charAt(index) == grid[row + 1][col]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row + i][col]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //BottomLeft
        if(searchStr.charAt(index) == grid[row + 1][col - 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row + i][col - i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //Left
        if(searchStr.charAt(index) == grid[row][col - 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row][col - i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        //TopLeft
        if(searchStr.charAt(index) == grid[row - 1][col - 1]) {
            for(int i = 1; i < searchStr.length(); i++) {
                if(searchStr.charAt(i) == grid[row - i][col - i]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
            if(result)
                return true;
        }

        return false;
    }
}