import java.util.*;

public class A{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> v = new TreeSet<Integer>();
        for(int i=0;i<n;i++) v.add(sc.nextInt());
        Iterator<Integer> it = v.iterator();
        it.next();
        it.remove();
        System.out.println(v.isEmpty() ? "NO" : v.iterator().next());
    }
}