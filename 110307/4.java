import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Main {
    static HashSet<String> hashset = new HashSet<String>();
 
    public static Stack<String> solve(String first, String last) {
        HashSet<String> hash = new HashSet<String>();
    
        node n = new node();
        n.c = first;
        n.parent = null;
        hash.add(first);
        Queue<node> Que = new LinkedList<node>();
        Que.add(n);
        Stack<String> res = null;
        while (!Que.isEmpty()) {
            node cur = Que.poll();
            if (cur.c.equals(last)) {
                res = new Stack<String>();
                while (cur != null) {
                    res.push(cur.c);
                    cur = cur.parent;
                }
                return res;
            } else {
                char[] S = cur.c.toCharArray();
                char[] S1 = cur.c.toCharArray();
                for (int i = 0; i < S.length; i++) {
                    for (int j = 0; j < 26; j++) {
                        S[i] = (char) (j + 'a');
                        String h = new String(S);
                        if (S[i] != S1[i] && !hash.contains(h)
                                && hashset.contains(h)) {
                            hash.add(h);
                            node n1 = new node();
                            n1.c = h;
                            n1.parent = cur;
                            Que.add(n1);
                        }
                    }
                    S[i] = S1[i];
                }
            }
        }
        return res;
 
    }
 
    static class node {
        String c;
        node parent;
    }
 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        while (!s.equals("")) {
           hashset.add(s);
            s = input.nextLine();
        }
        boolean first = true;
        while (input.hasNext()) {
            if (!first) {
                System.out.println();
            }
            first = false;
            StringTokenizer stk = new StringTokenizer(input.nextLine());
            String s1 = stk.nextToken();
            String s2 = stk.nextToken();
            Stack<String> sta = solve(s1, s2);
            if (sta != null) {
                while (!sta.isEmpty()) {
                    System.out.println(sta.pop());
                }
            } else 
                System.out.println("No solution.");
           
        }
 
    }
}