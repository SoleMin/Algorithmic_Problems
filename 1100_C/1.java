/*
    Draw a triangle with vertices at the centre of the
    inner triangle, and centres of two adjacent outer
    triangles.

    Interior angle of a regular N-gon = 180(N-2)/2
    Central angle can be obtained using interior angles,
    or it's also simply 360/N

    Use sin rule: sinA/a = sinB/b = sinC/c
    sin(central angle)/2R = sin(interior/2)/(r+R)

    alpha = interior angle of polygon
    beta = central angle of the triangle (vertex inside circle)
 */


//created by Whiplash99
import java.io.*;
import java.util.*;
public class A
{
    private static double interiorAngle(int N)
    {
        return (double)180*(N-2)/(double)N;
    }
    private static double centralAngle(int N)
    {
        return (double)360/(double)N;
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        String[] s=br.readLine().trim().split(" ");
        N=Integer.parseInt(s[0]);
        int r=Integer.parseInt(s[1]);

        double alpha=Math.toRadians(interiorAngle(N));
        double beta=Math.toRadians(centralAngle(N));

        double num=Math.sin(beta)/Math.sin(alpha/2);
        double ans=r*num/(2-num);

        System.out.println(ans);
    }
}