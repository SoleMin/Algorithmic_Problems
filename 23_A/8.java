import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        String a = r.next();
        char[] c = a.toCharArray();
        
        for(int l = a.length()-1; l >= 1; l--){
            for(int i = 0; i <= a.length()-l; i++){
                int j = i+l-1;
                
                for(int s = 0; s <= a.length()-l; s++){
                    if(i == s)continue;
                    if(a.substring(i, i+l).equals(a.subSequence(s, s+l))){
                        System.out.println(l);
                        System.exit(0);
                    }
                        
                }
            }
        }
        
        System.out.println(0);
        
    }
}
