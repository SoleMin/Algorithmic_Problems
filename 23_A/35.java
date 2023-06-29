import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class A {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        for (int i = n; i >= 1; i--) {
            Set<String> set = new HashSet<String>();
            for (int j = 0; j < n-i+1; j++) {
                String t = s.substring(j, j+i);
                if (set.contains(t)) {
                    System.out.println(i);
                    return;
                }
                set.add(t);
            }
        }
        System.out.println(0);
    }
    
}
