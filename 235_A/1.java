import java.util.Scanner;

public class Main {
  public long LCM(long n) {
    if(n== 1){
        return 1;
    }
    else if(n==2){
        return 2;
    }
    else if(n%2==0){
        if(n%3==0){
            return (n-1)*(n-2)*(n-3);
        }
        else{
            return n*(n-1)*(n-3);
        }
    }
    else{
        return n*(n-1)*(n-2);
    }
   
  }

  public static void main(String[] args) {
    Main m = new Main();
    Scanner s = new Scanner(System.in);
    long input = s.nextInt();
    long output = m.LCM(input);
    System.out.println(output);
  }
}