import java.util.*;

public class C {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] s = new char[n];
        String line = in.next();
        int ct=0,ht=0;
        for(int i=0;i<n;i++) //count animals
            if(line.charAt(i)=='T')
                ct++;
            else
                ht++;
        
        int cnt = 1000000000;
        int[] c = new int[2];
        char[] cc = new char[2];
        if(ct<ht)
        {
            c[0] = ct;
            c[1] = ht;
            cc[0] = 'T';
            cc[1] = 'H';
        }else{
            c[0] = ht;
            c[1] = ct;
            cc[0] = 'H';
            cc[1] = 'T';
        }
        
        for(int i=0;i<n;i++)
        {
            int ptr = i;
            for(int j=0;j<c[0];j++) //fill First
            {
                s[ptr] = cc[0];
                ptr = (ptr+1)%n;
            }
            for(int j=0;j<c[1];j++) //fill Second
            {
                s[ptr] = cc[1];
                ptr = (ptr+1)%n;
            }
            //check
            int ch = 0;
            for(int j=0;j<n;j++) //difference
                if(s[j]!=line.charAt(j)&&s[j]==cc[0])
                    ch++;
            cnt = Math.min(cnt,ch);
        }
        
        System.out.print(cnt);
    }
}

