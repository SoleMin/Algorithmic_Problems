import java.util.*;
import java.io.*;
public class CF911D {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int[] array = new int[n];
      for(int i = 0; i < n; i++){
         array[i] = sc.nextInt();
      }
      int count = 0;
      for(int i = 0; i < array.length; i++){
         for(int j = i+1; j < array.length; j++){
            if(array[i] > array[j]){
               count++;
            }
         }
      }
      count%=2;
      int q = sc.nextInt();
      for(int i = 0; i < q; i++){
         int l = sc.nextInt();
         int r = sc.nextInt();
         int sz = r - l + 1;
         count += (sz*(sz-1))/2;
         count %= 2;
         if(count == 1) 
            System.out.println("odd");
         else 
            System.out.println("even");
      }
   }
}