import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
/** Oct 21, 2012 **/
import java.util.InputMismatchException;
import java.util.LinkedList;

/**
 * @author DOAN Minh Quy
 * @email mquy.doan@gmail.com
 */
public class C236 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new C236().run();
    }
    void run() {
        InputScanner scanner = new InputScanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        int n = scanner.nextInt();
        long answer;
        if ( n == 1 ){
            answer = 1;
        }else if ( n == 2 ){
            answer = 2;
        }else{
            if ( (n & 1) != 0 ){
                answer = (long)n * (long)(n-1) * (long)(n-2);
            }else{
                if ( n % 3 == 0 ){
                    answer = (long)(n-1) * (long)(n-2) * (long)(n-3);
                }else{
                    answer = (long)(n) * (long)(n-1) * (long)(n-3);
                }
            }
        }
        printer.println(answer);
    }
    class InputScanner{
        BufferedInputStream bis;
        byte[] buffer = new byte[1024]; 
        int currentChar;
        int charCount;
        public InputScanner(InputStream stream){
            bis = new BufferedInputStream(stream);
        }
        public byte read() {
            if (charCount == -1)
                throw new InputMismatchException();
            if (currentChar >= charCount) {
                currentChar = 0;
                try {
                    charCount = bis.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (charCount <= 0)
                    return -1;
            }
            return buffer[currentChar++];
        }
        public int nextInt(){
            int c = read();
            while (isSpaceChar(c)){
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int rep = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                rep *= 10;
                rep += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return rep * sign;
        }
        public long nextLong(){
            int c = read();
            while (isSpaceChar(c)){
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long rep = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                rep *= 10;
                rep += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return rep * (long)sign;
        }
        public String next(){
            char c = (char)read();
            while (isSpaceChar(c)){
                c = (char)read();
            }
            StringBuilder build = new StringBuilder();
            do{
                build.append(c);
                c = (char)read();
            }while(!isSpaceChar(c));
            return build.toString();
        }
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        public void close(){
            try {
                bis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
