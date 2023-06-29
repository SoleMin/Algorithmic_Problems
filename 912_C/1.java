import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.OpenOption;
import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ConsoleIO io = new ConsoleIO(new InputStreamReader(System.in), new PrintWriter(System.out));
        //String test = "C-large";
        //ConsoleIO io = new ConsoleIO(new FileReader("D:\\Dropbox\\code\\practice\\jb\\src\\" + test + ".in"), new PrintWriter(new File("D:\\Dropbox\\code\\practice\\jb\\src\\" + test + "-out.txt")));

       new Main(io).solve();

        io.close();
    }

    ConsoleIO io;
    Main(ConsoleIO io) {
        this.io = io;
    }

    List<List<Integer>> gr = new ArrayList<>();
    long MOD = 1_000_000_007;

    public void solve() {
        int n = io.ri(), m = io.ri();
        long bounty = io.ri(), increase = io.ri(), damage = io.ri();
        int active = 0;
        long[] reg = new long[n];
        long[] max = new long[n];
        boolean[] inside = new boolean[n];
        PriorityQueue<Event> pq = new PriorityQueue<>((Event e1, Event e2) -> e1.time > e2.time ? 1 : (e1.time < e2.time ? -1 : (e1.val>e2.val?1:(e1.val<e2.val?-1:0))));
        long res = 0;
        long[] nextJump = new long[n];

        for (int i = 0; i < n; i++) {
            long maxh = io.ri(), starth = io.ri(), regen = io.ri();
            if (maxh <= damage || starth <= damage && regen == 0) {
                if(increase>0) {
                    io.writeLine("-1");
                    return;
                }
            }
            max[i] = maxh;
            reg[i] = regen;
            if (starth <= damage) {
                res += bounty;
                inside[i] = true;
                active++;
                if(maxh>damage && regen>0) {
                    long interTime = (damage - starth) / regen;
                    pq.add(new Event(interTime, -1, i));
                    nextJump[i] = interTime;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            long time = io.ri();
            int enemy = io.ri() - 1;
            long health = io.ri();
            if (reg[enemy] == 0 && health <= damage) {
                if(increase>0) {
                    io.writeLine("-1");
                    return;
                }
            }

            pq.add(new Event(time - 1, health, enemy));
        }


        while (pq.size() > 0) {
            Event event = pq.poll();

            long health = event.val;
            int enemy = event.enemy;
            long time = event.time;

            long p = (bounty + time * increase) * active;
            res = Math.max(res, p);

            if (health == -1) {
                if(nextJump[enemy] != time)
                    continue;

                inside[enemy] = false;
                active--;
            } else {
                nextJump[enemy] = -1;
                if (health <= damage) {
                    if (!inside[enemy]) {
                        active++;
                        inside[enemy] = true;
                    }

                    if (reg[enemy] > 0 && max[enemy] > damage) {
                        long interTime = (damage - health) / reg[enemy] + time + 1;
                        nextJump[enemy] = interTime;
                        pq.add(new Event(interTime, -1, enemy));
                    }
                } else {
                    if (inside[enemy]) {
                        inside[enemy] = false;
                        active--;
                    }
                }
            }
        }
        if (active > 0) {
            if(increase>0) {
                io.writeLine("-1");
            }else{
                res = Math.max(res, (bounty) * active);
                io.writeLine(res + "");
            }
        } else {
            io.writeLine(res + "");
        }
    }

    class Event{
        public Event(long t, long v, int e){
            time = t;
            val = v;
            enemy = e;
        }
        public long time;
        public long val;
        public int enemy;
    }

}

class ConsoleIO {

    BufferedReader br;
    PrintWriter out;
    public ConsoleIO(Reader reader, PrintWriter writer){br = new BufferedReader(reader);out = writer;}
    public void flush(){this.out.flush();}
    public void close(){this.out.close();}
    public void writeLine(String s) {this.out.println(s);}
    public void writeInt(int a) {this.out.print(a);this.out.print(' ');}
    public void writeWord(String s){
        this.out.print(s);
    }
    public void writeIntArray(int[] a, int k, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) sb.append(separator);
            sb.append(a[i]);
        }
        this.writeLine(sb.toString());
    }
    public int read(char[] buf, int len){try {return br.read(buf,0,len);}catch (Exception ex){ return -1; }}
    public String readLine() {try {return br.readLine();}catch (Exception ex){ return "";}}
    public long[] readLongArray() {
        String[]n=this.readLine().trim().split("\\s+");long[]r=new long[n.length];
        for(int i=0;i<n.length;i++)r[i]=Long.parseLong(n[i]);
        return r;
    }
    public int[] readIntArray() {
        String[]n=this.readLine().trim().split("\\s+");int[]r=new int[n.length];
        for(int i=0;i<n.length;i++)r[i]=Integer.parseInt(n[i]);
        return r;
    }
    public int[] readIntArray(int n) {
        int[] res = new int[n];
        char[] all = this.readLine().toCharArray();
        int cur = 0;boolean have = false;
        int k = 0;
        boolean neg = false;
        for(int i = 0;i<all.length;i++){
            if(all[i]>='0' && all[i]<='9'){
                cur = cur*10+all[i]-'0';
                have = true;
            }else if(all[i]=='-') {
                neg = true;
            }
            else if(have){
                res[k++] = neg?-cur:cur;
                cur = 0;
                have = false;
                neg = false;
            }
        }
        if(have)res[k++] = neg?-cur:cur;
        return res;
    }
    public int ri() {
        try {
            int r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public long readLong() {
        try {
            long r = 0;
            boolean start = false;
            boolean neg = false;
            while (true) {
                int c = br.read();
                if (c >= '0' && c <= '9') {
                    r = r * 10 + c - '0';
                    start = true;
                } else if (!start && c == '-') {
                    start = true;
                    neg = true;
                } else if (start || c == -1) return neg ? -r : r;
            }
        } catch (Exception ex) {
            return -1;
        }
    }
    public String readWord() {
        try {
            boolean start = false;
            StringBuilder sb = new StringBuilder();
            while (true) {
                int c = br.read();
                if (c!= ' ' && c!= '\r' && c!='\n' && c!='\t') {
                    sb.append((char)c);
                    start = true;
                } else if (start || c == -1) return sb.toString();
            }
        } catch (Exception ex) {
            return "";
        }
    }
    public char readSymbol() {
        try {
            while (true) {
                int c = br.read();
                if (c != ' ' && c != '\r' && c != '\n' && c != '\t') {
                    return (char) c;
                }
            }
        } catch (Exception ex) {
            return 0;
        }
    }
    //public char readChar(){try {return (char)br.read();}catch (Exception ex){ return 0; }}
}
class Pair {
    public Pair(int a, int b) {this.a = a;this.b = b;}
    public int a;
    public int b;
}
class PairLL {
    public PairLL(long a, long b) {this.a = a;this.b = b;}
    public long a;
    public long b;
}
class Triple {
    public Triple(int a, int b, int c) {this.a = a;this.b = b;this.c = c;}
    public int a;
    public int b;
    public int c;
}