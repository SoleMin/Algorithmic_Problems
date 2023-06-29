import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class r114 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        ArrayList<Integer> l = new ArrayList<Integer>();
        for (int i = 0 ; i < n; i++) {
            l.add(sc.nextInt());
        }
        Collections.sort(l);
        
        int pet = l.get(n - a);
        int vas = l.get(b - 1);
        
        if (pet <= vas) {
            System.out.println(0);
        }
        else System.out.println(pet - vas);     
        
        sc.close();
    }
}
