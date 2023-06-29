import java.io.*;
import java.util.*;

public class q3 {

    public static void main(String[] args) throws Exception {
        // String[] parts=br.readLine().split(" ");
        // int n=Integer.parseInt(parts[0]);
        // int k=Integer.parseInt(parts[1]);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        for (int test = 1;test <= tests;test++) {
            String[] parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            
            StringBuilder temp = new StringBuilder();

            int curr = Integer.parseInt(br.readLine());
            temp.append("1");
            System.out.println(1);
            for(int i = 0;i < n - 1;i++){
                curr = Integer.parseInt(br.readLine());
                if(curr == 1){
                    temp.append('.').append('1');
                    System.out.println(temp);
                }else{
                    while(temp.length() > 0){
                        int idx = temp.length() - 1;
                        while(idx >= 0 && temp.charAt(idx) != '.') idx--;
                        idx++;

                        int val = Integer.parseInt(temp.substring(idx));
                        temp.delete(idx,temp.length());
                        if(curr == val + 1){
                            temp.append(String.valueOf(curr));
                            break;
                        }
                        temp.deleteCharAt(temp.length() - 1);
                    }
                    System.out.println(temp);
                }
            }
        }
    }
}
