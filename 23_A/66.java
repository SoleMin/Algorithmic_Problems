import java.util.Scanner;

public class GivenString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String s = input.nextLine();
        
        int max = 0;
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                int match = 0;
                for(int k = 0; k + tmp.length() <= s.length(); k++) {
                    if(tmp.equals(s.substring(k, k + tmp.length()))) {
                        match++;                        
                    }
                }
                if(match >= 2) {
                    max = Math.max(max, tmp.length());
                }
            }
        }
        System.out.println(max);
        System.exit(0);
    }
}
