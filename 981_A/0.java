// https://codeforces.com/problemset/problem/981/A

// https://codeforces.com/problemset/problem/1428/C

//logic: keep taking away stuff under the condition that the length is > 0
//prioritize AB first, then BB
//use the string builder class and the subtract function

import java.util.*;
import java.io.*;

public class AntiPal{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        String input = scan.next();
        
        StringBuilder rev = new StringBuilder(input);
        rev.reverse();
        
        // System.out.println(rev); // TESTING 
        
        if(!input.equals(rev.toString())){
            System.out.println(input.length());
        }
        else{
            boolean allSame = true;
            for(int j=1; j<input.length(); j++) {
                if(input.charAt(j)!=input.charAt(j-1)){
                    allSame = false;
                    break;
                }
            }
            if(allSame == true){
                System.out.println(0);
            }
            else{
                System.out.println(input.length()-1);
            }
            
        }
        
        
    }
    
}
