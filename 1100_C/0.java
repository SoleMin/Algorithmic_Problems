import java.util.*;
import java.lang.*;

public class myClass{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        double n = sc.nextDouble();
        double r = sc.nextDouble();

        double angle = (n-2)*180;
        angle = angle/(2*n);
        angle = Math.cos(angle*Math.PI/180);
        double ans = r*angle;
        ans = ans/(1-angle);
        System.out.println(ans);
    }
}