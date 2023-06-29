
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class YouAreGivenAString {

    void run() {
        try {
            BufferedReader bfd = new BufferedReader(new InputStreamReader(
                    System.in));
            int i, j, k, mxLen = 0;
            String s= bfd.readLine();
            for(i=0; i<s.length(); ++i){
                for(j=i+1; j<s.length()+1; ++j){
                    String s2 = s.substring(i, j);
                    if(s2.length()<=mxLen) continue;
                    int cnt=0;
                    for(k=0; k<s.length(); ++k){
                        if(s.length()>=k+s2.length())
                        if(s2.equals(s.substring(k,k+s2.length()))){
                            cnt++;
                            if(cnt>1)mxLen = Math.max(mxLen, s2.length());
                        }
                    }
                }
            }
            System.out.println(mxLen);
        } catch (Exception e) {

        }
    }
    public static void main(String[] args) {
        new YouAreGivenAString().run();
    }

}
