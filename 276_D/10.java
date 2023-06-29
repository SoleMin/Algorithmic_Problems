import java.util.Scanner;


public class Main3 {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        long l = s.nextLong();
        long r = s.nextLong();
        
        String a = Long.toBinaryString(l);
        String b = Long.toBinaryString(r);
        while(a.length() < b.length()) a = "0" + a;
        while(b.length() < a.length()) b = "0" + b;
        
        String ans = "";
        
        int ix = -1;
        for (int i = 0; i < a.length(); i++) {
            
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
            ans += a.charAt(i);
            ix++;
        }
//      System.out.println(a);
//      System.out.println(b);
        for (int i = ix + 1; i < a.length(); i++) {
            int c1 = a.charAt(i) - '0';
            int c2 = b.charAt(i) - '0';
            if(c1 == 0 && c2 == 0) ans += "1";
            else if(c1 == 1 && c2 == 1) ans += "0";
            else ans += (char)(c1 + '0');
        }
        long a1 = Long.parseLong(ans, 2);
        long a2 = Long.parseLong(b,2);
//      System.out.println(ans);
//      System.out.println(b);
//      System.out.println();
        long xor = a1 ^ a2;
        System.out.println(xor);
    }

}
