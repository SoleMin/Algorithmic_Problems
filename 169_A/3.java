import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        A problem = new A();
        problem.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
            
        int n = sc.nextInt();
        
        int p = sc.nextInt();
        int v = sc.nextInt();
        
        long a[] = new long[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        
        long aux;
        for(int i = 0; i < n -1; i++){  
            for(int j = i + 1; j < n; j++){  

                if((a[i]) > (a[j])){  
                    aux = a[j];  
                    a[j] = a[i];  
                    a[i] = aux;

                }  
            }  
        }
        
        System.out.println(a[v]-a[v-1]);
        
        
    }
}