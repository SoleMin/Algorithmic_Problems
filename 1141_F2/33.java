import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.Point;

public final class Solution {
    BufferedReader br;
    StringTokenizer st;
    
    {
        st = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
    
    void run() throws Exception {
        int n = ni();
        int[] a = new int[n];
        for(int i=0; i<n; i++) a[i] = ni();
        for(int i=1; i<n; i++) a[i] += a[i-1];
        
        HashMap<Integer, List<Point>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int sum = getSum(a, i, j);
                if(!map.containsKey(sum)) map.put(sum, new ArrayList<>());
                map.get(sum).add(new Point(i+1, j+1));
            }
        }
        
        for(int key : map.keySet()) {
            Collections.sort(map.get(key), new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    if(p1.x == p2.x) return p1.y - p2.y;
                    return p1.x - p2.x;
                }
            });
        }
        
        Stack<Point> stack = new Stack<>();
        for(int key : map.keySet()) {
            Stack<Point> st = getPairs(map.get(key));
            if(st.size() > stack.size()) stack = st;
        }
        
        pl(stack.size());
        while(!stack.isEmpty()) {
            Point p = stack.pop();
            pl(p.x + " " + p.y);
        }
    }
    
    Stack<Point> getPairs(List<Point> list) {
        Stack<Point> stack = new Stack<>();
        stack.push(list.get(0));
        for(int i=1; i<list.size(); i++) {
            Point p = list.get(i);
            if(p.x >= stack.peek().x && p.x <= stack.peek().y) {
                Point p2 = stack.pop();
                if(p2.y < p.y) {
                    stack.push(p2);
                } else {
                    stack.push(p );
                }
            } else {
                stack.push(p);
            }
        }
        return stack;
    }
    
    int getSum(int[] a, int l, int r) {
        return (l == 0) ? a[r] : a[r] - a[l-1];
    }
    
    class Node {
        HashSet<Integer> adj;
        public Node() {
            adj = new HashSet<>();
        }
    }
    
    // I/O
    String nt() throws Exception {
        if(st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine(), " ");
        }
        return st.nextToken();
    }
    
    int ni() throws Exception {
        return Integer.parseInt(nt());
    }
    
    long nl() throws Exception {
        return Long.parseLong(nt());
    }
    
    void p(Object o) {
        System.out.print(o);
    }
    
    void pl(Object o) {
        System.out.println(o);
    }
}