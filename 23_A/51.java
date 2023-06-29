import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Main20 {

    static ArrayList<Integer> primes = new ArrayList<Integer>();
    static boolean[] prime = new boolean[1001];
    public static void gen(){
        Arrays.fill(prime, true);
        prime[0] = prime[1]  = false; 
        for (int i = 2; i < 1001; i++) {
            if (prime[i]){
                primes.add(i);
                for (int j = i*2; j < 1001; j+=i)
                    prime[j] = false;
            }
        }
    }
    public static boolean isVowel(char c){
        Character r = Character.toLowerCase(c);
        return (r == 'e' || r == 'a' || r == 'i' || r == 'o' ||  r == 'u'||  r == 'y');
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new InputStreamReader(System.in));
        String str = s.next();
        int x;
        int max= 0;
        
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                x = str.indexOf(str.substring(i,j),i+1) ;
                if (x != -1){
                    if (j-i > max) max = j-i;
                }
            }
        }
        System.out.println(max);
    }

}
