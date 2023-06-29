
import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] graph;
    static int[] count;
    static Dictionary<String, Integer> cities;
    static Dictionary<Integer, String> out;
    static boolean isCut[];
    static int discovered[];
    static int city;
    static int number = 0;
    static int testCase = 0;
    static int cameras = 0;

    public static void main(String[] args) {
        boolean finish = false;
        while ( finish == false) {
            testCase++;
            finish = input();
            if (finish == true)
                break;
            solve();
            print();
        }
    }

    public static boolean input() {
        int connect;
        String buf1, buf2;
        city = sc.nextInt();
        if (city == 0)
            return true;
        graph = new int[city][city];
        count = new int[city];
        for (int i = 0; i < city; i++)
            for (int j = 0; j < city; j++)
                graph[i][j] = -1;
        cities = new Hashtable<>();
        out = new Hashtable<>();
        for (int i = 0; i < city; i++) {
            buf1 = sc.next();
            cities.put(buf1, i);
            out.put(i, buf1);
        }

        connect = sc.nextInt();
        for (int i = 0; i < connect; i++) {
            buf1 = sc.next();
            buf2 = sc.next();
            graph[cities.get(buf1)][count[cities.get(buf1)]++] = cities.get(buf2);
            graph[cities.get(buf2)][count[cities.get(buf2)]++] = cities.get(buf1);
        }
        return false;
    }

    public static void solve() {
        discovered = new int[city];
        isCut = new boolean[city];
        for (int i = 0; i < city; i++) {
            if (discovered[i] == 0)
                dfs(i, true);
        }
    }

    public static int dfs(int here, boolean isRoot) {
        discovered[here] = ++number;
        int ret = discovered[here];
        int child = 0;
        for (int i = 0; graph[here][i] != -1 && i <= city; i++) {
            int next = graph[here][i];
            if (discovered[next] != 0) {
                ret = Math.min(ret, discovered[next]);
                continue;
            }
            child++;
            int prev = dfs(next, false);
            if (!isRoot && prev >= discovered[here])
                isCut[here] = true;
            ret = Math.min(ret, prev);
        }
        if (isRoot)
            isCut[here] = (child >= 2);
        return ret;
    }
    public static void print(){
        cameras = 0;
        List <String> answer = new LinkedList<>();
        for (int i = 0; i < city; i++) {
            if (isCut[i] == true) {
                answer.add(out.get(i));
                cameras++;
            }
        }
        Collections.sort(answer);
        System.out.println("City map #" + testCase + ": " + cameras + " camera(s) found");
        while(!answer.isEmpty())
            System.out.println(answer.remove(0));
        System.out.println();
    }
}