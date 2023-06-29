
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Natasha
 */
public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int produzeni = in.nextInt();
        int devices = in.nextInt();
        int stekovi = in.nextInt();
        int [] filter = new int[produzeni];
        for(int i = 0; i<produzeni; i++){
            filter[i] = in.nextInt();
        }
        Arrays.sort(filter);
        int filt_no = filter.length-1;
        if(devices<=stekovi) {
            System.out.println("0");
            return;
        }
        int used = 0;
        while(devices>stekovi){
            try{
            stekovi+=filter[filt_no--]-1;
            }
            catch(Exception e){
                System.out.println("-1");
                return;
            }
        }
        
        System.out.println(filter.length - filt_no-1);
        
        
        
    }
}
