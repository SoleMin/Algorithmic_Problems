
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        
        for ( int i = 0 ; i < n ; ++i ) {
            set.add(sc.nextInt());
        } // for i
        
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        if(list.size() > 1)
        System.out.println(list.get(1));
        else
            System.out.println("NO");
    }
}