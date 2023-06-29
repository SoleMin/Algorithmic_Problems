

/**
 *
 * @author ishani
 */
import java.util.*;
public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        TreeSet<Integer> set = new TreeSet<Integer>();

        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            set.add(a);
        }

        if(set.size()==1)System.out.println("NO");
        else{
            set.remove(set.first());
            System.out.println(set.first());
        }
    }
}
