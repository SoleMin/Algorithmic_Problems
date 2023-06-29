
import java.util.Scanner;

public class P23A {
    public P23A() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        
        String maxStr = "";
        for (int i = 0; i < str.length() - 1; i++){
            for (int j = i + 1; j < str.length(); j++){
                String pattern = str.substring(i, j);
                if (str.substring(i+1).contains(pattern) && pattern.length() > maxStr.length()){
                    maxStr = pattern;
                }
            }
        }
        System.out.println(maxStr.length());
    }
    
    public static void main (String []args){
        new P23A();
    }
}
