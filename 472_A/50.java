import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    
    public static boolean isPrime(long num){
        int divisor = 2;
        boolean bandera = true;
        while(bandera && divisor<num) //ponemos el while con su condicion en este caso si bandera 
        { 
        if (num%divisor==0) {
            bandera=false;
            break;
        }else{
            divisor++; //igual si el divisor llego al numero q se capturo este sera primo 
        }
        }
        return bandera;
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int uno = 4;
        int dos = n-4;

        while(isPrime(dos) || isPrime(uno)){
            dos--;
            uno++;
        }

        System.out.println(uno+" "+dos);
        
    }
    
}
