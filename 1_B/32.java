import java.util.Scanner;
public class MSpreadSheet {
    
    public int toNum(String x)
    {
        int result = 0;
        int pow = 0;
        for (int i = x.length()-1; i >=0; i--)
        {
            result+=(x.charAt(i)-'A'+1)*Math.pow(26, pow);
            pow++;
        }
        return result;
    }
    
    public String toString(int x)
    {
        if(x<=26) return String.valueOf((char)(x+'A'-1));
        String result = "";
        while(x!=0)
        {
            if(x%26==0) 
            {
                result = 'Z' + result;
                x = x/26 - 1;
            }
            else
            {
                result = (char)((x%26)+'A'-1) + result;
                x = x/26;
            }           
        }
        return result;
    }
    
    public  boolean check(String x)
    {
        if(x.charAt(0)!='R') return false;  //first rep
        int in = x.indexOf('C');
        if(in==-1) return false;
        if(Character.isDigit(x.charAt(in-1))&&Character.isDigit(x.charAt(in+1))) return true;
        return false;
    }
    
    public void solve(String x)
    {
        String r="";
        String c="";
        if(check(x))
        {
            int in = x.indexOf('C');
            r = x.substring(1,in);
            c = x.substring(in+1);
            System.out.println(toString(Integer.parseInt(c))+r);
        }
        else
        {
            int i =0;
            while(!Character.isDigit(x.charAt(i)))
                    c+=x.charAt(i++);
            while(i<x.length())
                r+=x.charAt(i++);
            System.out.println("R"+r+"C"+toNum(c));
        }
    }
    
    public static void main(String[] args) {
        MSpreadSheet sh = new MSpreadSheet();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        while(i<n)
        {
            sh.solve(s.next());
            i++;
        }
    }

}
