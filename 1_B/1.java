import java.io.*;
import java.util.*;
public class Solution{

    String numberToString(String s){
        int n = Integer.valueOf(s);
        StringBuilder sb = new StringBuilder();
        while (n> 0){
            int q = (n%26);
            if (q == 0) q = 26;
            n = (n-q)/26;
            sb.append( (char)('A' -1 + q));
        }
        return sb.reverse().toString();
    }

    String stringToNumber(String s){
        long n = 0;
        for (char c: s.toCharArray()){
            n = n*26 + (c-'A'+1);
        }
        return String.valueOf(n);
    }


    String convert(String s){
        int pos = s.indexOf("C");
        if (pos > 0 && s.charAt(pos-1)-'0' <= 9 && s.charAt(pos-1)>='0'){
            return numberToString(s.substring(pos+1)) + s.substring(1,pos);
        } else{
            int i = 0;
            for (i = 0; i< s.length(); i++){
                if (s.charAt(i)-'0' <= 9 && s.charAt(i)>='0'){
                    break;
                }
            }
            return "R" + s.substring(i) + "C" + stringToNumber(s.substring(0,i));
        }
    }

    static Scanner sc = new Scanner(System.in);
    static public void main(String[] args){
        int cases = sc.nextInt();
        
        
        for (int i = 0; i< cases; i++){
            String s = sc.next();
            Solution sol = new Solution();
            System.out.println(sol.convert(s));
        }
        
    }
}