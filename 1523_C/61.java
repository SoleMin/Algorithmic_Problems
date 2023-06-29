import java.util.*;
import java.io.*;

public class C{

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main (String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int prev = 1;
            ArrayList<Integer> nums = new ArrayList<>();
            nums.add(1);
            String till = "1";
            for(int i=0;i<n;i++) {
                int ln = Integer.parseInt(br.readLine());
                if(i == 0) {
                    bw.write("1\n");
                    continue;
                }
                if(ln == 1) {
                    nums.add(1);
                }else if(ln == prev + 1) {
                    nums.set(nums.size()-1, ln);
                }else {
                    int idx = -1;
                    for(int j=nums.size()-1;j>=0;j--) {
                        if(nums.get(j) == ln-1) {
                            idx = j;
                            break;
                        }
                    }
                    ArrayList<Integer> temp = new ArrayList<>();
                    for(int j=0;j<idx;j++) {
                        temp.add(nums.get(j));
                    }
                    temp.add(ln);
                    nums.clear();
                    nums = temp;
                }
                for(int j=0;j<nums.size()-1;j++) {
                    bw.write(nums.get(j) + ".");
                }
                bw.write(nums.get(nums.size()-1) + "\n");
                prev = ln;
            }
            
        }
        bw.flush();
    }
}