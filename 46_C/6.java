/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.* ;
import java.io.* ;
import java.math.* ;
/************************
 *                      *
 *    Lord Klotski      *
 *                      *
 ***********************/
public class C
{
    static int[] arr ; static int L ;
    public static void rotate()
    {
        int tmp = arr[0] ;
        for (int i = 1 ; i < L ; i ++)
            arr[i-1] = arr[i] ;
        arr[L-1] = tmp ;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in) ;

        L = input.nextInt() ; String s = input.next() ;
        arr = new int[L]; for (int i = 0 ; i < L ; i ++) {arr[i] = s.charAt(i) == 'H' ? 1 : 0 ;}

        // want to find longest sequence of 1s
        // then rotate to head
        int count = 99999 ;
        for (int A = 0; A < L ; A ++)
        {
            int[] tmp = new int[L] ; System.arraycopy(arr, 0, tmp, 0, arr.length);
            int ans = 0 ;
            for (int i = 0 ; i < L ; i ++)
            {
                if (tmp[i] == 1) continue ;
                for (int j = L-1 ; j > i ; j --)
                {
                    if (tmp[j] == 0) continue ;
                    ans ++ ;
                    tmp[i] = 1 ; tmp[j] = 0 ;
                    //System.out.println("SWAP " + i + " " + j);
                    //for (int k = 0 ; k < L ; k ++)
                    //    System.out.print(arr[k]);
                    //System.out.println("");
                    break;
                }
            }
            count = Math.min(count,ans) ;
            rotate() ;
        }
        // rotate until j is at the front
        System.out.println(count);

    }
}
