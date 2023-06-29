import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class A_135 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        
        int n=in.nextInt();
        
        int[] mas=new int[n];
        
        for(int i=0;i<n;i++){
            mas[i]=in.nextInt();
        }
        
        Arrays.sort(mas);
        
        PrintWriter out=new PrintWriter(System.out);
        
        boolean isEd=true;
        for(int i=0;i<n;i++)
            if(mas[i]!=1){
                isEd=false;
                break;
            }
        
        if(!isEd)
            out.print('1');
        
        for(int i=0;i<n-1;i++){
            out.print(' ');
            out.print(mas[i]);
        }
        
        if(isEd)
            out.print(" 2");
        
        out.flush();
    }

}
