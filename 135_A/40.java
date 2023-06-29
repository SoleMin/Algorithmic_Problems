import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class A{
    public static void main(String[] args) throws Exception{
        new A().run();
    }

    void run() throws Exception{
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        ArrayList<Integer> a = new ArrayList<Integer>();
        //a.add(1);
        StringTokenizer st = new StringTokenizer(sc.readLine(), " ");
        boolean allOne = true;
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(st.nextToken());
            if(val!=1)allOne = false;
            a.add(val);
        }
        if(allOne){a.remove(n-1); a.add(2);}
        else a.add(1);
        Collections.sort(a);
        System.out.print(a.get(0));
        for(int i = 1; i < n; i++)
            System.out.print(" " + a.get(i));
        System.out.println();
    }
}
