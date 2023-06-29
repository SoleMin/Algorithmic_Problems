import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class ProblemA {
    public static class Team {
        int solved;
        int penalty;
        Team(int s, int p) {
            solved = s;
            penalty = p;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String[] data = s.readLine().split(" ");
        int n =  Integer.valueOf(data[0]);
        int k =  Integer.valueOf(data[1]);

        
        Team[] t = new Team[n];
        for (int i = 0 ; i < n ; i++) {
            String[] line = s.readLine().split(" ");
            t[i] = new Team(Integer.valueOf(line[0]), Integer.valueOf(line[1]));
        }
        Arrays.sort(t, new Comparator<Team>(){
            public int compare(Team arg0, Team arg1) {
                if (arg0.solved != arg1.solved) {
                    return arg1.solved - arg0.solved;
                }
                return arg0.penalty - arg1.penalty;
            }
        });
        
        
        int idx = k - 1;
        int ksol = t[idx].solved;
        int kpen = t[idx].penalty;
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            if (t[i].solved == ksol && t[i].penalty == kpen) {
                count++;
            }
        }
        System.out.println(count);
    }
}