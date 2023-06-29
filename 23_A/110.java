
/**
 * Mx NINJA 04:06:52 ص 14/01/2014
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder line = new StringBuilder(reader.readLine());
        int length = 0;
        for (int head = 0; head < line.length(); head++) {
            for (int tail = line.length() - 1; tail > head; tail--) {
                String subString = line.substring(head, tail);
                if(line.indexOf(subString,head+1)>-1){
                    length = Math.max(subString.length(), length);
                }
            }
        }
        System.out.println(length);
    }
}