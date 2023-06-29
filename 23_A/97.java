import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);

        String ins = in.nextLine();
        HashMap <String,Integer> sub = new HashMap<String,Integer>();
        for (int i=0;i<ins.length();i++){
            for (int j=i+1;j<=ins.length();j++){
                String key = ins.substring(i,j);
                if (sub.containsKey(key)){
                    sub.put(key,sub.get(key)+1);
                } else {
                    sub.put(key,1);
                }
            }
        }

        int max = 0;
        for (String key:sub.keySet()){
            if (sub.get(key) >= 2 && key.length() > max){
                max = key.length();
            }
        }

        System.out.print(max);
    }
}
