import java.util.Scanner;


public class YouReGivenAString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String str = in.next();
        
        int max = 0;
        for(int i=0;i<str.length() && max < (str.length()-i);i++){
            int[] zalgo = zalgo(str.substring(i));
            for(int j=0;j<zalgo.length;j++){
                if(max < zalgo[j]){
                    max = zalgo[j];
                }
            }
        }
        
        System.out.println(max);
        

    }
    
    public static int[] zalgo(String str){
        int n = str.length();
        int[] z = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
          if (i > R) {
            L = R = i;
            while (R < n && str.charAt(R-L) == str.charAt(R)) R++;
            z[i] = R-L; R--;
          } else {
            int k = i-L;
            if (z[k] < R-i+1) z[i] = z[k];
            else {
              L = i;
              while (R < n && str.charAt(R-L) == str.charAt(R)) R++;
              z[i] = R-L; R--;
            }
          }
        }
        return z;
    }
    
}
