

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static List<Turtle> turtles = new LinkedList();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int [][] dp;
    static int answer = 0;
    static final int inf = 9999999;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }
    public static void input() throws IOException {
        String buf;
        StringTokenizer token;
        for (int i = 0; i < 5607; i++){
            if ((buf = input.readLine()) == null || buf.isEmpty())
                break;
            token = new StringTokenizer(buf);
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            if (a <= b) {
                Turtle t = new Turtle(a, b);
                turtles.add(t);
            }
        }
        Collections.sort(turtles);
    }
    public static void solve() {
        int arrSize = turtles.size();
        dp = new int[arrSize][arrSize];
        for (int i = 0; i < arrSize; i++)
            dp[0][i] = inf;
        dp[0][0] = turtles.get(0).getWeight();
        for (int i = 1; i < arrSize; i++){
            for (int j = 0; j < arrSize; j++){
                dp[i][j] = dp[i-1][j];
                if (j > 0 && dp[i-1][j-1] + turtles.get(i).getWeight() <= turtles.get(i).getHealth())
                    dp[i][j] = Math.min(dp[i-1][j-1] + turtles.get(i).getWeight(), dp[i-1][j]);
            }
        }
        for (int i = arrSize-1; i >=0; i--)
            if (dp[arrSize-1][i] < inf)
            {
                answer = i + 1;
                break;
            }

    }
    public static void print(){
        if (answer > inf)
            answer = 0;
        System.out.println(answer);
    }
}
class Turtle implements Comparable<Turtle>{
    int weight;
    int health;

    public Turtle(int weight, int health) {
        this.weight = weight;
        this.health = health;
    }

    public int getWeight() {
        return weight;
    }

    public int getHealth() {
        return health;
    }


    @Override
    public int compareTo(Turtle o) {
        int rV;
        if (this.health >= o.health)
            rV = 1;
        else
            rV = -1;
        return rV ;
    }
}