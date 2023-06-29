
import java.util.*;
import java.io.*;
public class Main {

    static Scanner cin = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter cout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] agrs) throws IOException{
        
        String line = cin.nextLine();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int ans = 0;
        for (int i = 0; i < line.length(); ++i) {
            StringBuffer str = new StringBuffer("");
            for (int j = i; j < line.length(); ++j) {
                str.append(line.charAt(j));
                
                if (!map.containsKey(str.toString())) {
                    //cout.println(str.toString());
                    map.put(str.toString(), 1);
                } else {
                    ans = str.length() > ans ? str.length() : ans;
                }
            }
        }
        
        cout.println(ans);
        
        cin.close();
        cout.close();
    }
}