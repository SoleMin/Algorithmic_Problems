import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C981 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Node[] nodes = new Node[N];
        for (int n=0; n<N; n++) {
            Node node = new Node();
            node.id = n+1;
            nodes[n] = node;
        }
        for (int n=1; n<N; n++) {
            int u = in.nextInt()-1;
            int v = in.nextInt()-1;
            nodes[u].next.add(nodes[v]);
            nodes[v].next.add(nodes[u]);
        }
        int degreeMoreThan2Count = 0;
        Node maxDegreeNode = nodes[0];
        for (Node node : nodes) {
            int degree = node.next.size();
            if (degree > 2) {
                degreeMoreThan2Count++;
            }
            if (degree > maxDegreeNode.next.size()) {
                maxDegreeNode = node;
            }
        }
        StringBuilder output = new StringBuilder();
        if (degreeMoreThan2Count > 1) {
            output.append("No\n");
        } else {
            output.append("Yes\n");
            output.append(maxDegreeNode.next.size()).append('\n');
            for (Node node : maxDegreeNode.next) {
                Node parent = maxDegreeNode;
                output.append(parent.id);
                while (true) {
                    if (node.next.size() == 1) {
                        break;
                    }
                    Node next = node.next.get(0);
                    if (next == parent) {
                        next = node.next.get(1);
                    }
                    parent = node;
                    node = next;
                }
                output.append(' ').append(node.id);
                output.append('\n');
            }
        }
        System.out.print(output);
    }

    static class Node {
        int id;
        List<Node> next = new ArrayList<>();
    }

}
