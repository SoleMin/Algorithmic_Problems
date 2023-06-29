import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        while(t-->0){
            int n = Integer.parseInt(f.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(f.readLine());
            }
            int[] levels = new int[n];
            int curr_level = 0;
            for(int i = 0; i < n; i++){
                if(levels[curr_level] == arr[i]-1){
                    levels[curr_level]++;
                }else if(arr[i] == 1){
                    curr_level++;
                    levels[curr_level]++;
                }else if(arr[i] > 1){
                    while(curr_level > 0 && levels[curr_level] != arr[i]-1){
                        levels[curr_level] = 0;
                        curr_level--;
                    }
                    levels[curr_level]++;
                }
                StringBuilder ostring = new StringBuilder();
                for(int level = 0; level <= curr_level; level++){
                    ostring.append(levels[level]);
                    if(level != curr_level) ostring.append(".");
                }
                out.println(ostring);
            }

        }
        out.close();
    }
}
