import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0, t = sc.nextInt(); i < t; i++) {
            int n = sc.nextInt();
            LinkedList<Set<Integer>> stack = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                printStack(stack);
                int val = sc.nextInt();
                if (val == 1) {
                    Set<Integer> branch = new HashSet<>();
                    branch.add(val);
                    stack.push(branch);
                    continue;
                }
                Set<Integer> branch = stack.peek();
                assert branch != null;
                while (branch.contains(val) || branch.stream().max(Integer::compareTo).get() + 1 != val) {
                    stack.pop();
                    branch = stack.peek();
                }
                branch.add(val);
            }
            printStack(stack);
        }
    }

    public static void printStack(LinkedList<Set<Integer>> stack) {
        if (stack.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i).stream().max(Integer::compareTo).get()).append(".");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
