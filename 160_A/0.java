//package Codeforces.EducationalRound70;

import java.util.*;

public class A {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        ArrayList<Integer> arlist = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            arlist.add(sc.nextInt());
            sum += arlist.get(i);
        }
        
        Collections.sort(arlist, Collections.reverseOrder());
        
        int s = 0;
        int th = sum /2 + 1;
        int i;
        
        for(i=0;i<n;i++)
        {
            s += arlist.get(i);
            if(s>=th)
                break;
        }
        
        
        System.out.println(i+1);
    }
}
