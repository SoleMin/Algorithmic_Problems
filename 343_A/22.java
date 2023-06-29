import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Soal3 {
    public static void main(String[] args) throws IOException{
        BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
        String[] masukan = baca.readLine().split(" ");
        BigInteger a = new BigInteger(masukan[0]);
        BigInteger b = new BigInteger(masukan[1]);
        
        
        
        BigInteger i=new BigInteger("0");
        while(a.compareTo(new BigInteger("1"))!=0){
            if(a.compareTo(b)==1){
                i=i.add(a.divide(b));
                if(a.mod(b)==new BigInteger("0")){
                    a=new BigInteger("1");
                    b=new BigInteger("0");
                }
                else{
                    a=a.mod(b);
                }
                
            }
            else{
                BigInteger temp =a;
                a=b;
                b=temp;             
            }
        }
        if(a.compareTo(new BigInteger("1"))==0){
            i=i.add(b);
        }
        System.out.println(i.toString());
    }
}