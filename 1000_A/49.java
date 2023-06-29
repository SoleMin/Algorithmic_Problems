import java.util.*;
import java.io.*;
public final class CF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> a = new ArrayList<>();
        for(int i = 0; i<n; i++)
            a.add(sc.next());
        int count = 0;
        for(int i = 0; i<n; i++) {
            String b = sc.next();
            int idx = a.indexOf(b);
            if(idx!=-1)
                a.remove(idx);
            else
                count++;
        }
        System.out.println(count);
    }
}