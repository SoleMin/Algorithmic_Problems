import java.util.*;
import java.io.*;

public class A {

    ArrayList<Integer> list = new ArrayList<Integer>();
    
    
    boolean valid(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(4);
        q.add(7);
        int crnt;
        while(!q.isEmpty()) {
            crnt = q.poll();
            if(n%crnt == 0) return true;
            if ( crnt*10 + 4 <= 1000 ) q.add(crnt*10 + 4);
            if ( crnt*10 + 7 <= 1000 ) q.add(crnt*10 + 7);
        }
        return false;
    }
    
    void dfs(int n){
        if(n>1000)return;
        if(n!=0)list.add(n);
        n = n*10;
        dfs(n+4);
        dfs(n+7);
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (valid(n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        new A().run();
    }

}
