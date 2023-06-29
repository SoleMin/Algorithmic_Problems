import java.io.*;
import java.util.*;

public class Main {
    enum Color {
        BLACK, RED, WHITE
    }

    class Node {
        int number;
        LinkedList<Node> adjacent;
        Color color;
        Boolean visit;

        Node(int data) {
            this.number = data;
            this.color = Color.WHITE;
            this.adjacent = new LinkedList<Node>();
            this.visit = false;
        }
    }

    Node[] nodes;
    boolean biColoring;

    Main(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs(int index) {
        Node root = nodes[index]; // 시작 인덱스 설정
        Stack<Node> stack = new Stack<Node>(); // 노드를 담는 스택 생성
        stack.push(root); // 최초 인덱스 root 삽입
        root.visit = true;// 스택에 들어갔으므로 visit true로 변경
        root.color = Color.BLACK; //최초 색은 black
        while (!stack.isEmpty()) { // 스택이 빌 때 까지 탐색
            Node r = stack.pop(); // 탐색중인 노드 r에 값 저장 후 삭제
            for (Node n : r.adjacent) { // r의 인접노드들을 스택에 추가한다.
                if (n.visit == false) {
                    n.visit = true;
                    if (n.color == Color.WHITE) {
                        if (r.color == Color.BLACK) {
                            n.color = Color.RED;
                            stack.push(n); // r의 인접 노드 n 삽입
                        } else if (r.color == Color.RED) {
                            n.color = Color.BLACK;
                            stack.push(n); // r의 인접 노드 n 삽입
                        } else if (n.color == Color.BLACK && n.color == Color.RED) {
                            if (n.color != r.color) {
                                stack.push(n); // r의 인접 노드 n 삽입
                            }
                        }
                    }

                } else {
                    if (n.color == r.color) {
                        biColoring = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (true) {
            input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            int nodeNumber = Integer.parseInt(input);
            int edgeNumber = Integer.parseInt(br.readLine());
            Main b = new Main(nodeNumber);
            for (int i = 0; i < edgeNumber; i++) {
                int[] n = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                b.addEdge(n[0], n[1]);
            }
            b.biColoring = true;
            b.dfs(0);
            if (b.biColoring == true) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }
        }

    }
}
