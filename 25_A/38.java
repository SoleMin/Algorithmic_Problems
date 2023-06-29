import java.util.*;
public class Main { 
    public static void main(String[] args) {
        Main iq = new Main();
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] naturalNumbers = new int[n];
        for (int i = 0; i < naturalNumbers.length; i++) {
            naturalNumbers[i] = sc.nextInt();
        }
        System.out.println(iq.diffInEvenness(n, naturalNumbers));          
    }
    
    public int diffInEvenness(int n, int[] naturalNumbers) {       
        int even, odd, lastEvenIndex, lastOddIndex;
        even = odd = lastEvenIndex = lastOddIndex = 0;
        for (int i = 0; i < naturalNumbers.length; i++) {
            if((naturalNumbers[i] % 2) == 0) {
                even++;
                lastEvenIndex = i + 1;
            }
            else {
                odd++;
                lastOddIndex = i + 1;
            }
        }
        return (even > odd ? lastOddIndex : lastEvenIndex);     
    }

}