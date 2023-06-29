import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.nextLine();
        while(s.hasNext()) {
            int first = s.nextInt();
            int second = s.nextInt();
            System.out.println(calculate(first,second));
        }
    }
    
    public static int calculate(int first, int second) {
        int operations = 0;
        while(first != 0 && second != 0) {
            int temp;
            if(first < second) {
                temp = second/first;
                operations += temp;
                second -= (first*temp);
            }
            else {
                temp = first/second;
                operations += temp;
                first -= (second*temp);
            }
        }
        return operations;
    }
}