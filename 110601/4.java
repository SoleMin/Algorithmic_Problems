import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		     Scanner input = new Scanner(System.in);
        ArrayList<Long> countlist = new ArrayList<>();
        while(true){
            long count;
            long i=2;
            long first;
            long second;
            BigInteger a= input.nextBigInteger();
            BigInteger b= input.nextBigInteger();
            if(a.compareTo(b)==1) {
                BigInteger temp = a;
                a=b;
                b=temp;
            }
            BigInteger one = new BigInteger("1");
            BigInteger zero = new BigInteger("0");


            if(a.equals(zero)&&b.equals(zero)) break;


             for(; a.compareTo(fib(i))>0; i++);
             first=i;
            for(; b.compareTo(fib(i))>=0; i++);
            second=i;
            count = second-first;
            if(a.equals(zero)&&!b.equals(one)) count++;

             countlist.add(count);
            input.nextLine();
        }

        for(long count :countlist){
            System.out.println(count);
        }

    }

    public static BigInteger fib(Long i){
        BigInteger an = BigDecimal.valueOf(1/Math.sqrt(5)*(Math.pow((1+Math.sqrt(5))/2,i)-Math.pow((1-Math.sqrt(5))/2,i))).toBigInteger();
    return an;
	}
}