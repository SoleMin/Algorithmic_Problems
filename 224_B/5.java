import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Array {

    void run() {
        try {
            BufferedReader bfd = new BufferedReader(new InputStreamReader(
                    System.in));
            StringTokenizer tk = new StringTokenizer(bfd.readLine());
            int n = Integer.parseInt(tk.nextToken());
            int k = Integer.parseInt(tk.nextToken()), i;
            int arr[] = new int[n];
            tk = new StringTokenizer(bfd.readLine());
            for(i=0;i<n;++i)
                arr[i] = Integer.parseInt(tk.nextToken());
            int dist=0,l=0,r=0;
            HashSet<Integer> hs = new HashSet<Integer>();
            for(i=0; i<n; ++i) {
                if(!hs.contains(arr[i])){
                    hs.add(arr[i]);
                    dist++;
                }
                if(dist==k) break;
                r++;
            }
            int freq[] = new int[100010];
            if(hs.size()<k) System.out.println("-1 -1");
            else {
                while(l<arr.length-1 && l<r && arr[l]==arr[l+1])
                    ++l;
                while(r>=1 && r>l && arr[r]==arr[r-1])
                    --r;
                for(i=l;i<=r;++i)
                    freq[arr[i]]++;
                while(freq[arr[l]]>1){
                    freq[arr[l]]--;
                    l++;
                }
                while(freq[arr[r]]>1){
                    freq[arr[r]]--;
                    r--;
                }
                System.out.println((l+1)+" " +(r+1));
            }
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        new Array().run();
    }

}
