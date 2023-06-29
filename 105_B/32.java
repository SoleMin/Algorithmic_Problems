import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Main {
    static double max = 0.0;
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int n = r.nextInt();
        int k = r.nextInt();
        int A = r.nextInt();
        
        Person[] p = new Person[n];
        
        for(int i = 0; i < n; i++){         
            int l = r.nextInt();
            int prob = r.nextInt();
            
            p[i] = new Person(l, prob);
        }
        
        int[] add = new int[n];
        
        double res = dfs(0, k, p, add, n, A);
        
        System.out.println(res);
        
    }
    private static double dfs(int ptr, int k, Person[] p, int[] add, int n, int A) {
        if(k < 0)return 0;
        
        double res1 = 0;
        for(int m = 0; m < 1<<n; m++){
            double win = 1;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if((m & (1 << i)) == 0){
                    win *= (100-(p[i].p+add[i]))*1.0/100;
                }else{
                    win *= (add[i]+p[i].p)*1.0/100;                 
                    cnt++;
                }
            }

            if(cnt > n/2){
                res1 += win; 
            }else{
                int B = 0;
                for(int i = 0; i < n; i++){
                    if((m & (1 << i)) == 0){
                        B += p[i].l;
                    }
                }
                
                win *= A*1.0/(A+B);
                                
                res1 += win; 
            }
        }
        
        double res2 = 0, res3 = 0;
        
        if(add[ptr]+p[ptr].p < 100){
            add[ptr] += 10;
            res2 = dfs(ptr, k-1, p, add, n, A);
            add[ptr] -= 10;
        }
        if(ptr+1 < n){
            res3 = dfs(ptr+1, k, p, add, n, A);
        }
        
        return Math.max(res1, Math.max(res2, res3));
    }
}
class Person{
    int l, p;
    public Person(int li, int pi){
        l = li;
        p = pi;
    }
    public String toString(){
        return String.format("[%d, %d]", l, p);
    }
}