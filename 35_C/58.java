
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        File f = new File("input.txt");
        Scanner sc = new Scanner(f);
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] board = new boolean[n][m];
        int count = sc.nextInt();
        Point[] burningTrees = new Point[count];
        for (int i=0; i<count; i++) {
            burningTrees[i] = new Point(sc.nextInt() - 1,sc.nextInt() - 1);
        }
        Point last = findLastPoint(board,burningTrees);
        bw.append((last.x + 1) + " " + (last.y + 1) + "\n");
        bw.flush();
        bw.close();
        sc.close();
    }



    public static Point findLastPoint(boolean[][] board,  Point[] burningTree){
        Queue<Point> queue = new LinkedList<Point>();
        for(int i = 0; i <burningTree.length; i++ ) {
            queue.add(burningTree[i]);
            board[burningTree[i].x][burningTree[i].y] = true;
        }
        Point lastPoint = new Point(-1,-1);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            lastPoint = p;
            ArrayList<Point> neighbours = getNeighbours(p,board);
            for(int i = 0; i <neighbours.size(); i++ ) {
                queue.add(neighbours.get(i));
                board[neighbours.get(i).x][neighbours.get(i).y] = true;
            }
        }
        return lastPoint;
    }

    public static ArrayList<Point> getNeighbours(Point p, boolean[][] board){
        ArrayList<Point> neighbours = new ArrayList<>();
        for(int i = -1; i <=1; i++ ){
            for(int j = -1; j <= 1; j++ ){
                if(Math.abs(i) != Math.abs(j)) {
                    int x = p.x + i;
                    int y = p.y + j;
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                        if (board[x][y] == false) {
                            neighbours.add(new Point(x,y));
                        }
                    }
                }
            }
        }
        return neighbours;
    }
}
