

import java.util.Scanner;

public class A_YoureGivenAString {

    //1:11
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        
        for (int l = str.length()-1; l >= 1; l--) {
            for (int i = 0; i < str.length()-l+1; i++) {
                String subs = str.substring(i, i+l);
                if(str.lastIndexOf(subs) != i){
                    System.out.println(l);
                    return;
                }
            }
        }
        System.out.println(0);
    }

}
