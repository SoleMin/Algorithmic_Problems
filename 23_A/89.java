


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    
    public static void main(String[] args)throws java.lang.Exception {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String s = br.readLine();
     int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.substring(i+1).contains(s.substring(i,j)))
                    max = Math.max(max, j-i);

            }}
            System.out.println(max);



    
    }

}
