import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class A{
    Scanner sc=new Scanner(System.in);

    void run(){
        String s=sc.nextLine();
        int n=s.length();
        int ans=0;
        for(int len=1; len<n; len++){
            for(int i=0; i+len<=n; i++){
                String t=s.substring(i, i+len);
//              println(t);
                if(s.indexOf(t,i+1)!=-1){
                    ans=len;
                    break;
                }
            }
        }
        println(ans+"");
    }

    void println(String s){
        System.out.println(s);
    }

    void print(String s){
        System.out.print(s);
    }

    public static void main(String[] args){
        new A().run();
    }

}
