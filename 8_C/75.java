import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by James on 1/29/2015.
 */
public class Driver {
    private static int [][] distances, parents;
    private static int [] distance, parent;
    private static String [][] longNames;
    private static String [] shortNames, answers;
    private static int N;

    public static void main(String [] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        String [] pieces = scanner.readLine().split("\\s+");

        //totally had to steal the vast majority of this from http://codeforces.com/contest/8/submission/9745593

        Point origin = new Point(Integer.parseInt(pieces[0]), Integer.parseInt(pieces[1]));

        N = Integer.parseInt(scanner.readLine());

        Point [] points = new Point[N + 1];
        distances = new int[N  + 1][N + 1];
        parents = new int[N + 1][N + 1];
        longNames = new String[N][N];
        shortNames = new String[N];

        for (int i = 0; i < N; ++i) {
            pieces = scanner.readLine().split("\\s+");

            points[i] = new Point(Integer.parseInt(pieces[0]), Integer.parseInt(pieces[1]));
        }

        points[N] = origin;

        for (int i = 0; i <= N; ++i) {
            if (i < N) {
                shortNames[i] = (i + 1) + " ";
            }

            for (int j = 0; j <= N; ++j) {
                if (i < N && j < N) {
                    longNames[i][j] = (i + 1) + " " + (j + 1) + " ";
                }

                distances[i][j] = 2 * points[i].distance(points[j]);
                parents[i][j] = points[i].distance(points[N]) + points[i].distance(points[j]) + points[j].distance(points[N]);
            }
        }

        distance = new int[1 << N];
        parent = new int[1 << N];
        answers = new String[1 << N];
        Arrays.fill(distance, -1);
        distance[0] = 0;

        int result = rec((1 << N) - 1);
        StringBuilder answer = new StringBuilder();

        for (int i = distance.length - 1; parent[i] != i; i = parent[i]) {
            answer.append("0 ");
            answer.append(answers[i]);
        }

        answer.append("0");
        System.out.println(result);
        System.out.println(answer.toString());
    }

    private static int rec(int mask) {
        if (distance[mask] != -1) {
            return distance[mask];
        }

        int min = 0;

        while (((1 << min) & mask) == 0) {
            min++;
        }

        int newMask = mask & (~(1 << min));
        distance[mask] = rec(newMask) + distances[min][N];
        parent[mask] = newMask;
        answers[mask] = shortNames[min];

        for (int i = min + 1; i < N; i++) {
            if (((1 << i) & mask) > 0) {
                newMask = mask & (~(1 << i)) & (~(1 << min));

                int temp = rec(newMask) + parents[i][min];

                if (temp< distance[mask]) {
                    distance[mask] = temp;
                    parent[mask] = newMask;
                    answers[mask] = longNames[min][i];
                }
            }
        }

        return distance[mask];
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(Point p) {
            return (int)(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }
    }
}