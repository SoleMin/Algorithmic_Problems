import java.util.Scanner;


public class R113A {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] ind = new int[n];
        int[] p = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++){
            ind[i] = i;
            p[i] = in.nextInt();
            t[i] = in.nextInt();
        }
        //System.out.println("erwer");
        for (int i = 0; i < n - 1; i++)
         for (int j = i + 1; j < n; j++){
             if (p[i] < p[j] || (p[i] == p[j] && t[i] > t[j])){
                 int tmp = p[i];
                 p[i] = p[j];
                 p[j] = tmp;
                 tmp = t[i];
                 t[i] = t[j];
                 t[j] = tmp;
             }
         }
        
        int i = k - 1;
//      System.out.println(i+" "+p[i]);
        while (i > 0 && p[i] == p[i - 1] && t[i] == t[i - 1]) i--;
    //  System.out.println(i);
        int j = 0;
        while (i < n - 1 && p[i] == p[i + 1] && t[i] == t[i + 1]) {
            i++;
            j++;
        }
//      System.out.println(i);
        System.out.println(j + 1);
        
        
    }
}
