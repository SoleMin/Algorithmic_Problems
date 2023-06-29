/**
 * ******* Created by bla on 14/9/19 6:17 PM*******
 */

import java.io.*;
import java.util.*;

public class A1209 {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            int n = input.nextInt();
            int[] arr = input.readIntArray(n);

            Arrays.sort(arr);
            int ans =0;
            boolean[] vis = new boolean[n];
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    vis[i]=true;
                    for(int j=i+1;j<n;j++){
                        if(!vis[j] && arr[j]%arr[i]==0){
                            vis[j]=true;                    }
                    }
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        default double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        default int[] readIntArray() throws IOException {
            return readIntArray(nextInt());
        }

        default int[] readIntArray(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        default long[] readLongArray(int size) throws IOException {
            long[] array = new long[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = nextLong();
            }
            return array;
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}
