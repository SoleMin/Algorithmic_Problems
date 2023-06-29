import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    
    static ArrayList<Edge> graph;
    static ArrayList<ArrayList<Integer>> graphForKuhn;
    static int n, m, u = 0;
    static int mt[];
    static int used[];

    public static void main(String[] args) {
        formGraph();
        System.out.println(getAnswer()); 
    }
    
    static boolean kuhn(int start) {
        if (used[start] == u)
            return false;
        used[start] = u;
        for (int i=0; i< graphForKuhn.get(start).size(); i++) {
            int to = graphForKuhn.get(start).get(i);
            if (mt[to] == -1 || kuhn(mt[to])) {
                mt[to] = start;
                return true;
            }
        }
        return false;
    }

    private static int getAnswer() {
        int currentAnswer = Integer.MAX_VALUE;
        for (int cur= 0; cur<n; cur++) {
            int adj = 0, otheradj = 0, answer = 0;
            for (int j=0; j<n; j++) {
                graphForKuhn.get(j).clear();
                mt[j] = -1;
            }
            for (int j=0; j<m; j++) {
                if (graph.get(j).from == cur || graph.get(j).to == cur)
                    adj++;
                else {
                    graphForKuhn.get(graph.get(j).from).add(graph.get(j).to);
                    otheradj++;
                }
            }
            for (int j=0; j<n; j++) {
                u++;
                kuhn(j);
            }
            int tsz = 0;
            for (int j=0; j<n; j++) {
                if (mt[j] != -1)
                    tsz++;
            }
            answer = 2*(n-1)+1-adj+otheradj-2*tsz+(n-1);
            currentAnswer = Math.min(answer, currentAnswer);
        }
        return currentAnswer;
    }

    private static void formGraph() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<Edge>(m);
        for (int i=0; i<m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.add(new Edge(x-1, y-1));
        }
        graphForKuhn = new ArrayList<ArrayList<Integer>>(n);
        for (int i=0; i<n; i++) graphForKuhn.add(new ArrayList<Integer>(n));
        mt = new int[n];
        used = new int[n];
        in.close();
    }

    
}

class Edge {
    int from;
    int to;
    
    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
