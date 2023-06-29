import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        G1PlaylistForPolycarpEasyVersion solver = new G1PlaylistForPolycarpEasyVersion();
        solver.solve(1, in, out);
        out.close();
    }

    static class G1PlaylistForPolycarpEasyVersion {
        public static final int GENRES_COUNT = 3;
        private int songsCount;
        private int totalDuration;
        private Song[] songs;
        private int[][][] mem;
        static final int mod = 1000000007;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            songsCount = in.nextInt();
            totalDuration = in.nextInt();

            songs = new Song[songsCount];

            for (int i = 0; i < songsCount; i++) {
                songs[i] = new Song(in.nextInt(), in.nextInt() - 1);
            }

            long ret = 0;
            int chosenSongs = 0;

            mem = new int[GENRES_COUNT + 1][][];
            for (int i = 0; i < GENRES_COUNT; i++) {
                mem[i] = new int[totalDuration + 1][];

                for (int j = 0; j <= totalDuration; j++) {
                    mem[i][j] = new int[1 << songsCount];

                    for (int k = 0; k < 1 << songsCount; k++) {
                        mem[i][j][k] = -1;
                    }
                }
            }

            for (int i = 0; i < songsCount; i++) {
                chosenSongs = 1 << i;
                ret += search(totalDuration - songs[i].duration, songs[i].genre, chosenSongs);
            }

            out.println(ret % mod);
        }

        private long search(int timeLeft, int lastGenre, int chosen) {
            if (timeLeft < 0) {
                return 0;
            }

            if (timeLeft == 0) {
                return 1;
            }

            if (mem[lastGenre][timeLeft][chosen] != -1) {
                return mem[lastGenre][timeLeft][chosen];
            }

            long ret = 0;

            for (int i = 0; i < songsCount; i++) {
                if (((1 << i) & chosen) == 0 && songs[i].genre != lastGenre) {
                    ret += search(timeLeft - songs[i].duration, songs[i].genre, chosen | 1 << i);
                    if (ret > mod) {
                        ret = ret % mod;
                    }
                }
            }
            mem[lastGenre][timeLeft][chosen] = (int) (ret % mod);

            return mem[lastGenre][timeLeft][chosen];
        }

        class Song {
            public int duration;
            public int genre;

            public Song(int duration, int genre) {
                this.duration = duration;
                this.genre = genre;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

