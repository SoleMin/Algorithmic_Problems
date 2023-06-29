import java.util.*;
import java.io.*;
import java.math.*;
public class Main{
  public static void main(String[] args) {
    long  n,k;
    Scanner s= new Scanner(System.in);
	n=s.nextInt();
	k=s.nextInt();
	System.out.println((int)(n-((-3+Math.sqrt(9+8*(n+k)))/2)));  
  }
}
