import java.util.*; 
 
public class Main 
{ 
 public static void main(String[] args) 
 { 
  Scanner keyboard = new Scanner(System.in); 
  int size = keyboard.nextInt(); 
  int[] arr = new int[size]; 
  int i = 0; 
  while( size != 0 ) 
  {  
   arr[i] = keyboard.nextInt(); 
   size--;  
   i++; 
  } 
   //System.out.print("size " + arr.length );
   Arrays.sort(arr); 
 
   int index = 0; 
   boolean val = false; 
   int ans = 0; 
   for ( i = 0; i< arr.length-1 ; i++ ) 
   { 
    //System.out.print(" arr[i] " + arr[i] + " arr[i+1] " + arr[i+1] + "\n" );
    if( arr[i] != arr[i+1] ) 
    { 
     val = true; 
     //System.out.print("Changed val to true");
     index = i+1; 
      System.out.println(arr[index]); 
      return; 
    } 
   } 
     
    if (size == 1 || ( val == false))
    { 
        System.out.println("NO");    
    } 
 
    
 } 
  
}