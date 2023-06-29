
import java.util.Scanner;


public class Contest25_A {
    
    static int[] parity;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numberEntries = scan.nextInt();
        scan.nextLine();
        String[] numbers = scan.nextLine().split(" ");
        numbers = parity(numbers);
        int evenOdd = evenOdd(parity);
       
        for (int i = 0; i < parity.length; i++) {
            if (parity[i] == evenOdd) {
                System.out.println(i + 1);
                System.exit(0);
            }
        }
            
        
    }

    public static int evenOdd(int[] parity) {
        /*
         * Determines what I should be looking for
         * Return 0 if even
         * Return 1 if odd
         */
        int numberOnes = 0;
        int numberZeroes = 0;
        
        int one = parity[0];
        int two = parity[1];
        int three = parity[2];
        
        if (one == 1) 
            numberOnes++;
        else
            numberZeroes++;
        
        if (two == 1) 
            numberOnes++;
        else
            numberZeroes++;
        
        if (three == 1) 
            numberOnes++;
        else
            numberZeroes++;
        
        if (numberOnes >= 2)
            return 0;
        else
            return 1;
        
    }

    public static String[] parity(String[] numbers) {
        parity = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            parity[i] = Integer.parseInt(numbers[i]) % 2;
            numbers[i] = Integer.toString(parity[i]);
        }
        return numbers;
    }
    
}
