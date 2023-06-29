
import java.util.*;
public class CodeForces {
    public static void main(String[] args) {
        int T,N,X,A[],count = 0;
        HashMap<Integer, Integer> hash = new HashMap<>(); 
        boolean flag = true;
        Scanner o = new  Scanner(System.in);
        N = o.nextInt();
        A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = o.nextInt();
        }
        for(int i=0; i<N; i++){
            if(A[i] != 0)
                hash.put(A[i],i);
        }
        System.out.print(hash.size());
        
    } 
}
