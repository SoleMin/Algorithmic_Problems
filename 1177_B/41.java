import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       long n = sc.nextLong();
       long itrIdx = 0;
       long itr = 0;
       long num = 0;
       while(itrIdx < n){
           itrIdx += (itr+1)*(Math.pow(10,itr+1) - Math.pow(10,itr));
           num+= (Math.pow(10,itr+1) - Math.pow(10,itr));
           itr++;
       }

        itrIdx -= itr*(Math.pow(10,itr)-Math.pow(10,itr-1));
        num -= (Math.pow(10,itr)-Math.pow(10,itr-1));
        long lastNum = num + ((n-itrIdx)/itr);
        long lastNumIndex = itrIdx + (itr* (lastNum-num));

        if(lastNumIndex == n){
            lastNumIndex = lastNumIndex-itr;
            lastNum -=1;
        }

        String nextNum = String.valueOf(lastNum+=1);
        System.out.println(nextNum.charAt((int) (n-lastNumIndex-1)));

    }
}


