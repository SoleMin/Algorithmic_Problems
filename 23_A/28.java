
import java.util.*;
import java.lang.*;
import java.math.*;

public class A {
    
    Scanner sc = new Scanner(System.in);
    
    void run(){
        
        String s = sc.next();
        String subS;
        int max = 0;
        
        for (int i=0;i<s.length();i++) {
            for (int j=i+1;j<s.length()+1;j++) {
                
                
                subS = s.substring(i, j);
                
                for (int k=i+1;k<s.length();k++) {
                    
                
                    if ( s.startsWith(subS,k) ){
                        if ( max < subS.length() )
                            max = subS.length();
                    }
                }
                
            }
        }
        
        System.out.println(max);
        return;
        
    }
    
    public static void main(String[] args){
        
        new A().run();
        
    }

}
