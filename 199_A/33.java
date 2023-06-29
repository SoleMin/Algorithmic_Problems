import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> fibs = new ArrayList<Integer>();
        int fib0 = 0;
        int fib1 = 1;
        int fibN = fib0+fib1;
        fibs.add(fib0);
        fibs.add(fib1);
        while(fibN < 1000000000){
            fibs.add(fibN);
            fib0 = fib1;
            fib1 = fibN;
            fibN = fib0+fib1;
        }
        int n = Integer.parseInt(br.readLine());
        
        if(n == 0){System.out.println(0+" "+0+" "+0);}
        else{
            if(n == 1){System.out.println(0+" "+0+" "+1);}
            else{
                if(n == 2){System.out.println(0+" "+1+" "+1);}
                else{
        int i = fibs.indexOf(n);
        System.out.println(fibs.get(i-4)+" "+fibs.get(i-3)+" "+fibs.get(i-1));
    }}
        }
}
}