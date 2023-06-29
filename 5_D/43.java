import java.util.Scanner;


public class D
{

    public static void main(String[] args)
    {
        new D();
    }
    
    D()
    {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double v = in.nextDouble();
        double l = in.nextDouble();
        double d = in.nextDouble();
        double w = in.nextDouble();
        
        if (w>v) w=v;
        
        double dx=(v*v-w*w)/(2*a);
        double d0=(w*w)/(2*a);
        
        double t=0;
        if (d0>d) // doesn't make it to speed w before reaching d
        {
            if (d0>=l) // never gets to speed w
            {
                t=Math.sqrt(2*a*l)/a;
            }
            else
            {
                t=w/a;
                if (d0+dx>=l) // never gets to speed v
                {
                    t+=(-w+Math.sqrt(w*w+2*a*(l-d0)))/a;
                }
                else // makes it to speed v
                {
                    t+=(v-w)/a;
                    t+=(l-(d0+dx))/v;
                }
            }
        }
        else // makes it to speed w before reachig d
        {
            t=w/a; // get up to speed w 
            
            // get time after reaching d
            if (d+dx>l) // never makes it back to v after reaching d
            {
                t+=(-w+Math.sqrt(w*w+2*a*(l-d)))/a;
            }
            else // makes it to speed v after reaching d
            {
                t+=(v-w)/a;
                t+=(l-(d+dx))/v;
            }
            
            // handle getting to d
            if (d0+2*dx>d) // can't get to v before reaching d
            {
                double half=(d-d0)/2;
                t+=2*(-w+Math.sqrt(w*w+2*a*half))/a;
            }
            else // can get to v before reaching d
            {
                t+=2*(v-w)/a;
                t+=(d-2*dx-d0)/v;
            }
        }
        
        System.out.printf("%.12f%n", t+1e-11);
    }

}
