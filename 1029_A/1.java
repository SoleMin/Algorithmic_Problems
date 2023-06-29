import java.util.Scanner;

public class A {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String str=sc.next();
        boolean b=false;
        int ind=-1;
        for(int i=1;i<n;i++){
            if(str.substring(i).equals(str.substring(0,n-i))){
                b=true;
                ind=i;
                break;
            }
        }
        if(ind==-1)
        {
            String ss=str;
            for(int i=1;i<k;i++){
                str+=ss;
            }
        }else{
            String ss=str.substring(n-ind);
            for(int i=1;i<k;i++){
                str+=ss;
            }
        }
        System.out.println(str);
    }
}
