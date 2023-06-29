
import java.util.*;

class Main {
    static Node[] nodes;
    static int[] buf = new int[4];
    static int banNode, start, end;
    static int[][] moving = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {-1, 0, 0, 0}, {0, -1, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, -1}};
    static Scanner input = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();

    public static void init() {
        for (int j = 0; j < 4; j++)
            buf[j] = input.nextInt();
        start = value(buf);
        Node startNode = new Node(buf[0], buf[1], buf[2], buf[3], false);
        for (int j = 0; j < 4; j++)
            buf[j] = input.nextInt();
        end = value(buf);
        Node endNode = new Node(buf[0], buf[1], buf[2], buf[3], false);
        banNode = input.nextInt();
        for (int j = 0; j < banNode; j++) {
            for (int k = 0; k < 4; k++)
                buf[k] = input.nextInt();
            Node node = new Node(buf[0], buf[1], buf[2], buf[3], true);
            node.setBan(true);
            nodes[value(buf)] = node;
        }
        nodes[start] = startNode;
        nodes[end] = endNode;
    }

    public static int bfs() {
        int now, tmp;
        if (start == end) return 0;
        Node node;
        nodes[start].setLevel(0);
        queue.clear();
        queue.offer(start);
        while (!queue.isEmpty()) {
            now = queue.remove();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    buf[j] = nodes[now].getIndex(j) + moving[i][j];
                    buf[j] = (buf[j] + 10) % 10;
                }
                tmp = value(buf);
                if (nodes[tmp] == null || (nodes[tmp].isVisit() != true && nodes[tmp].isBan() != true)) {
                    node = new Node(buf[0], buf[1], buf[2], buf[3]);
                    node.setVisit(true);
                    node.setLevel(nodes[now].getLevel() + 1);
                    queue.offer(tmp);
                    if (tmp == end)
                        return nodes[now].getLevel() + 1;
                    nodes[tmp] = node;
                }
            }
        }
        return -1;
    }

    public static int value(int[] buf) {
        return buf[0] * 1000 + buf[1] * 100 + buf[2] * 10 + buf[3];
    }

    public static void main(String[] args) {

        int testCase;
        testCase = input.nextInt();
        for (int i = 0; i < testCase; i++) {
            nodes = new Node[10000];
            init();
            System.out.println(bfs());
        }

    }
}

class Node {
    boolean ban;
    boolean visit;
    int[] value;
    int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Node(int a, int b, int c, int d, boolean isBan) {
        value = new int[4];
        this.value[0] = a;
        this.value[1] = b;
        this.value[2] = c;
        this.value[3] = d;
        ban = isBan;
    }

    public Node(int a, int b, int c, int d) {
        value = new int[4];
        this.value[0] = a;
        this.value[1] = b;
        this.value[2] = c;
        this.value[3] = d;
    }

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public boolean isBan() {
        return ban;
    }

    public void setValue(int a, int b, int c, int d) {
        this.value[0] = a;
        this.value[1] = b;
        this.value[2] = c;
        this.value[3] = d;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public int getIndex(int i) {
        return value[i];
    }

    public int[] getArr() {
        return value;
    }
}