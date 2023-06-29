import java.util.Scanner;

public class LuckySubstring {
    
    static int[] luck;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int i = -1;
        boolean ehLuck = false;
        preencheLucky();
        while (n >= luck[++i]) {
            if (i > 13) {
                break;
            }
            if (n % luck[i] == 0) {
                ehLuck = true;
                break;
            }
        }
        if (ehLuck) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    static void preencheLucky() {
        luck = new int[15];
        luck[0] = 4;
        luck[1] = 7;
        luck[2] = 44;
        luck[3] = 47;
        luck[4] = 74;
        luck[5] = 77;
        luck[6] = 444;
        luck[7] = 447;
        luck[8] = 474;
        luck[9] = 477;
        luck[10] = 744;
        luck[11] = 747;
        luck[12] = 774;
        luck[13] = 777;
    }
    
}
