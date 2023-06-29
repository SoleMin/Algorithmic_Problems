//package Demo;

//import java.io.Console;
import java.util.Scanner;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

    /**
     * @param args
     */ 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-->0){
            int m , n , count=0;
            m = scanner.nextInt();
            n = scanner.nextInt();
            while(m!=0&&n!=0){
                int tmp;
                if(m<n) {
                    tmp = n;
                    n = m;
                    m = tmp;
                }
                count+=m/n;
                m = m%n;
            } 
            if(T!=0)System.out.println(count);
            else System.out.print(count);
        }
    }

}
