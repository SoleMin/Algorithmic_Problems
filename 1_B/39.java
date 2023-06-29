// by kotb
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SpreadSheet {

    public void run() {
        try {
            Scanner s = new Scanner(System.in);
            int tests = s.nextInt();
            for (int i = 0; i < tests; i++) {
                String line = s.next();
                String regex = "R[\\d]+C[\\d]+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);
                
                if (matcher.matches()){
                    int r = Integer.parseInt(line.substring(1, line.indexOf("C")));
                    int c = Integer.parseInt(line.substring(line.indexOf("C") +1));
                    System.out.println(toFormula(r, c));
                }
                else {
                    int index = -1;
                    for (int j = 0; j < line.length(); j++) {
                        if (line.charAt(j) >= '0' && line.charAt(j) <= '9') {
                            index = j;
                            break;
                        }
                    }
                    String c = line.substring(0, index);
                    int r = Integer.parseInt(line.substring(index));
                    System.out.println(fromFormula(c, r));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String toFormula(int r, int c) {
        StringBuffer buff = new StringBuffer();
        char ch;
        while (c != 0) {
            int m = c%26;
            if(m==0)
            {
                ch = 'Z';
                c = c/26 - 1;
            }
            else
            {
                ch = (char)(m+'A'-1);
                c /= 26;
            }
            buff.append(ch);            
        }
        return buff.reverse().toString() + r;
    }
    
    private String fromFormula(String c, int r) {
        int ret = 0;
        int power = 1;
        for (int i = c.length()-1; i >= 0; i--) {
            ret += ((c.charAt(i) - 'A' + 1) * power);
            power *= 26;
        }
        return "R" + r + "C" + ret;
    }
    
    public static void main(String[] args) {
        new SpreadSheet().run();
    }
}
