import java.io.*;
import java.util.*;

public class A274 {

    /**
     * @param args
     */
    public static void main(String[] args) {
    
        Scanner in= new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        
        Long a[] =new Long[n];
        Hashtable<Long, Boolean> hash= new Hashtable<Long, Boolean>();
        
        
        for (int i=0;i< n;i++){
            a[i]=in.nextLong();
            
        }
        Arrays.sort(a);
        
        for (int i=0;i<n;i++){
            if (!hash.containsKey(a[i]) ){
                hash.put(a[i]*k, true);
            }
            
        }
        System.out.println(hash.size());
        
        
    }

}
