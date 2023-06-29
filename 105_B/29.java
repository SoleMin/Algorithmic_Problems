import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.OutputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Alex
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
    static class TaskB {
        double special(int[] loyalties, int[] levels, int playerlevelsum) {
            int poss = 1 << loyalties.length;
            double res = 0;
            for(int pos = 0; pos < poss; pos++) {
                double occurs = 1;
                int happy = 0;
                int badlevelssum = 0;
                for(int i = 0; i < loyalties.length; i++) {
                    if(((pos >> i) & 1) == 1) { //happy senator
                        happy++;
                        occurs *= (double) loyalties[i] / 100;
                    } else { //unhappy senator
                        badlevelssum += levels[i];
                        occurs *= (double) (100 - loyalties[i]) / 100;
                    }
                }
                double winprob = (happy <= levels.length / 2) ? (double) playerlevelsum / (playerlevelsum + badlevelssum) :
                        1;
//            System.err.println(pos + " " + (happy <= levels.length / 2) + " " + playerlevelsum + " " + (playerlevelsum + badlevelssum) + " " + occurs + " " + winprob + " " + occurs * winprob);
                res += occurs * winprob;
            }
            return res;
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int senators = in.readInt(); // n, [1, 8]
            int sweets = in.readInt(); // k, [1, 8]
            int playerlevelsum = in.readInt(); // A, [1, 9999]
            int[] levels = new int[senators]; // [1, 9999]
            int[] loyalties = new int[senators]; // [0, 100] divisible by 10
            IOUtils.readIntArrays(in, levels, loyalties);
            ArrayList<ArrayList<Integer>> possibilities = new ArrayList<>(Arrays.asList(new ArrayList<>()));
            for(int senator = 0; senator < senators; senator++) {
                ArrayList<ArrayList<Integer>> newpossibilities = new ArrayList<>();
                for(ArrayList<Integer> al : possibilities) {
                    int sumsofar = 0;
                    for(int val : al) sumsofar += val;
                    int minadd = senator == senators - 1 ? sweets - sumsofar : 0;
                    for(int moar = minadd; moar <= sweets - sumsofar; moar++) {
                        ArrayList<Integer> copy = new ArrayList<>(al);
                        copy.add(moar);
                        newpossibilities.add(copy);
                    }
                }
                possibilities = newpossibilities;
            }
            double res = 0;
//        out.printLine(possibilities.size());
            for(ArrayList<Integer> al : possibilities) {
                int[] newloyalties = new int[senators];
                for(int i = 0; i < senators; i++) newloyalties[i] = Math.min(100, loyalties[i] + 10 * al.get(i));
//            out.printLine(al);
//            out.printLine(newloyalties);
//            double works = dp(0, 0, newloyalties);
                double special = special(newloyalties, levels, playerlevelsum);
                double tot = special;
                res = Math.max(res, tot);
            }
            out.printLine(res);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while(!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if(filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for(int i = 0; i < objects.length; i++) {
                if(i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class IOUtils {
        public static void readIntArrays(InputReader in, int[]... arrays) {
            for(int i = 0; i < arrays[0].length; i++) {
                for(int j = 0; j < arrays.length; j++)
                    arrays[j][i] = in.readInt();
            }
        }

    }
}

