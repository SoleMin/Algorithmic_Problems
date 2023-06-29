import java.util.Scanner;


public class A {
  public static void main(String[] args){
	  Scanner in = new Scanner(System.in);
	  int n = in.nextInt();
	  int a[] = new int[100];
	  for (int i = 0;i<n;i++) a[i] = in.nextInt()%2;
	  if (a[0]==a[1] || a[0]==a[2]){
		  for (int i = 1;i<n;i++)
			  if (a[i] != a[0]) {
				  System.out.println(i+1);
				  break;
			  }
	  } else{
		  System.out.println(1);
	  }
  }
}
