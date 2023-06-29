import java.io.*;
import java.util.*;

class Node {
    String word;
    Node next;
}
public class Main {
    static HashSet<String> dictionary = new HashSet<String>();    
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        while (!words.equals("")) {
            dictionary.add(words);
            words = br.readLine();
        }
        boolean first = true;
        while ((words = br.readLine()) != null) {
            if (!first) {
                System.out.println();
            }
            first = false;
            String start = words.split(" ")[0];
            String end = words.split(" ")[1];
            Stack<String> solution = hasSolution(start, end);
            if (solution != null) {
                while (!solution.isEmpty()) {
                    System.out.println(solution.pop());
                }
            } else {
                System.out.println("No solution.");
            }
        }
 
    }
    public static Stack<String> hasSolution(String start, String end) {
        HashSet<String> V = new HashSet<String>();
        Node s = new Node();
        s.word = start;
        s.next = null;
        V.add(start);
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(s);
        Stack<String> result = null;
        while (!Q.isEmpty()) {
            Node curr = Q.poll();
            if (curr.word.equals(end)) {
                result = new Stack<String>();
                while (curr != null) {
                    result.push(curr.word);
                    curr = curr.next;
                }
                return result;
            } else {
                char[] S = curr.word.toCharArray();
                char[] ref = curr.word.toCharArray();
                for (int i = 0; i < S.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        S[i] = (char) (j + 'a');
                        String h = new String(S);
                        if (S[i] != ref[i] && !V.contains(h)
                                && dictionary.contains(h)) {
                            V.add(h);
                            Node n = new Node();
                            n.word = h;
                            n.next = curr;
                            Q.add(n);
                        }
                    }
                    S[i] = ref[i];
                }
            }
        }
        return result;
    }
}