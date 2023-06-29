import java.util.Scanner;

public class code0 {

public static void main(String[] args){
	Scanner scr= new Scanner(System.in);
int c=0,e=0,d=0;
int a=scr.nextInt();
d=a/2;
if(a>=11 && a%2==1){
c=9;
e=a-9;
}
else{
c=a-4;e=4;
}

System.out.print(c+" "+e);
}

}
