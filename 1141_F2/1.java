import java.io.*;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class Main {
    private static InputReader reader = new InputReader(System.in);
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = readInt();
        long[] a = readLongArray(n);
        HashMap<Long, List<Block>> blocks = new HashMap<>();
        for (int j = 0; j < n; j++) {
            long sum = 0;
            for (int i = j; i >= 0; i--) {
                sum += a[i];
                if (!blocks.containsKey(sum))
                    blocks.put(sum, new LinkedList<>());
                List<Block> blockList = blocks.get(sum);
                if (blockList.size() > 0 && blockList.get(blockList.size() - 1).r == j) continue;
                blockList.add(new Block(i, j));
            }
        }

        List<Block> bestBlocks = new LinkedList<>();
        for(long sum : blocks.keySet()) {
            List<Block> blockList = blocks.get(sum);
            List<Block> curBest = new LinkedList<>();
            int lastR = -1;
            for(Block block : blockList) {
                if (block.l > lastR) {
                    curBest.add(block);
                    lastR = block.r;
                }
            }
            if (curBest.size() > bestBlocks.size()) {
                bestBlocks = curBest;
            }
        }

        writer.println(bestBlocks.size());
        for(Block block : bestBlocks) {
            writer.printf("%d %d\n", block.l + 1, block.r + 1);
        }

        writer.flush();
    }

    private static int readInt() {
        return reader.nextInt();
    }

    private static long readLong() {
        return Long.parseLong(reader.next());
    }

    private static int[] readIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }

    private static long[] readLongArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = readLong();
        }
        return array;
    }

    private static void reverseIntArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
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

    private static class Block {
        int l, r;
        Block(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}