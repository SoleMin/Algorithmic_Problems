import java.util.Scanner;

public class DigitalSequence {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        long k = new Scanner(System.in).nextLong();
        long i = 1,t=0, c = 9,digits = 0,l=0,k2=k;
        while(t<k){
            l = t;
            t += i*c;
            i++;
            c*=10;
            digits++;
        }
        k = k-l;
        long lastNumber = (long)Math.pow(10,digits-1)-1;
        long p = k/digits,q=k%digits;
        long finalNumber =lastNumber+p;
        if(q!=0){
            finalNumber++;
        }
            k = k-digits*p;
            if(k<=0)
                k+=digits;
        String ans = ""+finalNumber;
        int index = (int)(k-1);
        print(""+ans.charAt(index));
    }   
}