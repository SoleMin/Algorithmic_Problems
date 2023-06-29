import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class problemA {
    public  static long GCD(long number1, long number2) {
        //base case
        if(number2 == 0){
            return number1;
        }
        return GCD(number2, number1%number2);
    }
  

public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long b =  Long.parseLong(st.nextToken());
        long c =  Long.parseLong(st.nextToken());
        if(c-b<2 ||((c-b==2)&& GCD(c,b)==1) ){
            System.out.println("-1");
        }else{
                if(b%2==0 ){
                    System.out.println(b+" "+(b+1)+" "+(b+2));
            }else
                System.out.println((b+1)+" "+(b+2)+" "+(b+3));
        
    
    
}
        

        

}
}
