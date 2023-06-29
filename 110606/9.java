import java.io.*;
import java.util.*;
import java.math.*;

class Main {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
	    ArrayList<BigInteger> hanoi3 = new ArrayList<>();
        BigInteger one = new BigInteger("1");
        BigInteger zero = new BigInteger("0");
        hanoi3.add(zero);
        hanoi3.add(one);
        
        for (int i = 2; i <= 10000; i++) {
            BigInteger a = new BigInteger("0");
            a = hanoi3.get(i - 1);
            hanoi3.add(one.add(a.add(a)));
        }
        
        ArrayList<BigInteger> hanoi4 = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            hanoi4.add(zero);
        }
        int k = 0;
        hanoi4.set(1, one);
        for (int i = 2; i <= 10000; i++) {
            hanoi4.set(i, hanoi4.get(i - 1).add(hanoi4.get(i - 1)));
            hanoi4.set(i, hanoi4.get(i).add(hanoi3.get(1)));
            for (k = i - 2; k > 0; k--) {
                BigInteger temp;
                temp = hanoi4.get(k).add(hanoi4.get(k));
                temp = temp.add(hanoi3.get(i-k));
                if (hanoi4.get(i).compareTo(temp) == 1)
                    hanoi4.set(i, temp);
                else
                    break;
            }
        }
        
        while (sc.hasNextInt()) {
            int a = sc.nextInt();

            System.out.println(hanoi4.get(a));
        }
	}	
}