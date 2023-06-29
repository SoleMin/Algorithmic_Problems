import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class p1523C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t ; i++) {
            int n = sc.nextInt();
            ArrayList<Stack<Integer>> ar = new ArrayList<Stack<Integer>>();
            for (int j = 0; j < n + 1; j++) {
                ar.add(new Stack<Integer>());
            }
            HashMap <Integer , Integer> hm = new HashMap<Integer, Integer>();
            StringBuilder cur = new StringBuilder();
            int l = 0;
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if( a == 1)
                {
                    if(cur.length() == 0)
                        cur.append("1");
                    else
                        cur.append(".1");
                    l++;
                    ar.get(1).add(l);
                    hm.put(l , 1);
                }
                else
                {
                    int newl = ar.get( a - 1).pop();
                    for (int k = newl + 1; k <= l ; k++) {
                        ar.get(hm.get(k)).pop();
                        hm.remove(k);
                        cur.delete(cur.lastIndexOf(".")  + 1, cur.length());
                        cur.delete(cur.length() - 1 , cur.length());
                    }
                    cur.delete(cur.lastIndexOf(".")  + 1, cur.length());
                    cur.append(a);
                    ar.get(a).add(newl);
                    hm.put(newl , a);
                    l = newl;
                }
                System.out.println(cur);
            }

        }
    }
}
