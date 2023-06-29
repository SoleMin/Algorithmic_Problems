import java.util.*;   
   
public class Main   
{   
 public static void main(String[] args)   
 {   
  Scanner keyboard = new Scanner(System.in);   
  int size = Integer.parseInt(keyboard.nextLine());   
  int[] arr = new int[size];   
  int i = 0;   
  while( size != 0 )   
  {    
   arr[i] = keyboard.nextInt();   
   size--;    
   i++;   
  }   
   
  if( arr.length == 1 )    
  {   
   System.out.println("NO");   
  }   
  else   
  {   
   Arrays.sort(arr);   
   boolean val = false;   
   int ans = 0;   
   for ( i = 0; i< arr.length-1 ; i++ )   
   {   
    if( arr[i] != arr[i+1] )   
    {   
     val = true;   
     ans = arr[i+1];   
     System.out.println(ans);   
     i = arr.length;   
    }    
    else if( i == arr.length-2 ) //val == false  
    {   
     System.out.println("NO");      
    }   
   }   
  }
 }
}