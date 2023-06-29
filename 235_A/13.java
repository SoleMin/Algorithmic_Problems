import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long num = input.nextLong();
        if(num==0){
            System.out.println(num);
        }else if(num==1||num==2){
            System.out.println(num);}
        else if(num%2==0&&num>2&&num%3!=0){
            System.out.println(num*(num-1)*(num-3));
        }
        else if(num%2==0&&num%3==0){
            System.out.println((num-1)*(num-2)*(num-3));
        }
        else{
        System.out.println(num*(num-1)*(num-2));}
    }
   
}
