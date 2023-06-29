import java.util.Arrays;
import java.util.Scanner;

public class Main{
    
    private static int[] T;
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        char[] input =  in.nextLine().toCharArray();
        int length = input.length;
        int max = 0;
        for(int i=0; i<length; i++){
            char[] subString = Arrays.copyOfRange(input, 1, input.length);
            int temp = solve(input, subString);
            if(temp > max) max = temp;
            input = Arrays.copyOfRange(input, 1, input.length);
        }
        System.out.println(max);
        
    }

    private static int solve(char[] P, char[] S) {
        
        T = new int[P.length+1];
        
        preKmp(P, P.length, T);
        int max = 0;

        int i = 0, j = 0;
        while (j < S.length) {
            while (i > -1 && (P[i] != S[j]))
                i = T[i];
            i++;
            j++;
            if ( i > max) max = i;
            if (i >= P.length) {
                i = T[i];
            }
        }
        
        return max;
        
        
    }

    private static void preKmp(char[] x, int m, int[] kmpNext) {
           int i = 0, j = kmpNext[0] = -1;
           
           while (i < m-1) {
              while (j > -1 && x[i] != x[j])
                 j = kmpNext[j];
              i++;
              j++;
              if (x[i] == x[j])
                 kmpNext[i] = kmpNext[j];
              else
                 kmpNext[i] = j;
           }

        
    }
} 