import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Node[] node;

    public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int ret = 2, del;
    int n = cin.nextInt();
    int t = cin.nextInt() * 2;
    node = new Node[n];
    for (int i = 0; i < n; i++) {
        int x = cin.nextInt();
        int a = cin.nextInt();
        node[i] = new Node(x * 2 - a, x * 2 + a);
    }
    Arrays.sort(node);
    for (int i = 1; i < n; i++) {
        del = node[i].l - node[i - 1].r;
        if (del > t) {
        ret += 2;
        } else if (del == t) {
        ret++;
        }
    }
    System.out.println(ret);
    }

    private static class Node implements Comparable<Node> {
    public int l;
    public int r;

    public Node(int l, int r) {
        // TODO Auto-generated constructor stub
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Node arg0) {
        // TODO Auto-generated method stub
        return l - arg0.l;
    }
    }
}