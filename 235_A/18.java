import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
Scanner input = new Scanner(System.in);
long x = input.nextLong();

if(x==1||x==2){System.out.println(x);
    
}
else if(x%2==0&&x>2&&x%3!=0){
    System.out.println((x)*(x-1)*(x-3));
    
}else if(x%2==0&&x%3==0){
    System.out.println((x-1)*(x-2)*(x-3));
}

else {System.out.println(x*(x-1)*(x-2));}
    }
}
