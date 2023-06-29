
/**
 * Write a description of class VK2A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class VK2A
{
    public static void main(String args[])
    {
        Scanner S = new Scanner(System.in);
        int n = S.nextInt();
        int a = S.nextInt();
        int b = S.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++)
            A[i] = S.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n - i - 1; j++)
            {
                if(A[j] < A[j + 1])
                {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        
            System.out.println(A[a - 1] - A[a]);
        }
 
}
