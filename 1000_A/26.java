import java.io.*;
import java.util.*;

public class n2{
    public static void main(String[] args) throws Exception{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[] S=new int[4];
        int[] L=new int[4];
        int m=0;
        for(int i=0;i<n;i++){
            String s=in.readLine();
            if(s.charAt(s.length()-1)=='L'){
                L[s.length()-1]++;
            }
            if(s.charAt(s.length()-1)=='S'){
                S[s.length()-1]++;
            }
            if(s.charAt(s.length()-1)=='M'){
                m++;
            }
        }
        for(int i=0;i<n;i++){
            String s=in.readLine();
            if(s.charAt(s.length()-1)=='L'){
                L[s.length()-1]--;
            }
            if(s.charAt(s.length()-1)=='S'){
                S[s.length()-1]--;
            }
            if(s.charAt(s.length()-1)=='M'){
                m--;
            }
        }
        int count=0;
        for(int i=0;i<=3;i++){
            if(S[i]>0){
                count+=S[i];
            }
            if(L[i]>0){
                count+=L[i];
            }
        }
        if(m>0){
            count+=m;
        }
        System.out.println(count);
    }
}