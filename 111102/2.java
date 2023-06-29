import java.io.*;

class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int testCase = -1;
    static char [] Z, C;
    static bigNumber [][] map;
    public static void main(String[] args) throws Exception {
        init();
        for (int i = 0; i < testCase; i++) {
            input();
            solve();
            print();
        }
    }
    public static void init() throws IOException {
        String buf;
        buf = input.readLine();
        testCase = Integer.parseInt(buf);
    }
    public static void input() throws IOException {
        String buf;
        buf = input.readLine();
        Z = buf.toCharArray();
        buf = input.readLine();
        C = buf.toCharArray();
    }
    public static void solve() {
        map = new bigNumber[C.length][Z.length];
        if (C[0] == Z[0])
            map[0][0] = new bigNumber(1);
        else
            map[0][0] = new bigNumber(0);

        for (int i = 0; i < C.length; i++) {
            if (i == 0) {
                for (int j = 1; j < Z.length; j++) {
                    bigNumber buf = new bigNumber();
                    if (C[i] == Z[j])
                        buf.addOne(map[i][j - 1]);
                    else
                        buf.copy(map[i][j - 1]);
                    map[i][j] = buf;
                }
            } else {
                for (int j = 0; j < i; j++){
                    map[i][j] = new bigNumber();
                }
                for (int j = i; j < Z.length; j++) {
                    bigNumber buf = new bigNumber();
                    if (C[i] == Z[j])
                        buf.add(map[i - 1][j - 1], map[i][j - 1]);
                    else
                        buf.copy(map[i][j - 1]);
                    map[i][j] = buf;
                }
            }
        }
    }
    public static void print(){
        map[C.length-1][Z.length-1].print();
    }
}
class bigNumber{
    int [] number;
    int digit;

    public bigNumber() {
        this.number = new int [32];
    }
    public bigNumber(int i) {
        this.number = new int [32];
        this.assign(i);
    }

    public void setNumber(int index, int number) {
        this.number[index] = number;
    }

    public int getNumber(int n) {
        return number[n];
    }
    public void assign(int n){
        for (int i = 0; i < 32; i++){
            number[i] = n % 10000;
            n /= 10000;
        }
    }
    public void addOne (bigNumber a){
        this.number[0] = a.getNumber(0) + 1;
    }
    public void add(bigNumber a, bigNumber b){
        if (a == null){
            this.copy(b);
            return;
        }
        if (b == null){
            this.copy(a);
            return;
        }
        int carry;
        carry = 0;
        for (int i = 0; i < 32; i++){
            this.number[i] = a.getNumber(i) + b.getNumber(i) + carry;
            carry = this.number[i] /10000;
            this.number[i] %= 10000;
        }
    }
    public void copy(bigNumber a){
        for (int i =0 ; i < 32; i++)
            this.number[i] = a.getNumber(i);
    }
    public void print(){
        for (int i = 31; i >= 0; i--){
            if (number[i] != 0){
                digit = i;
                break;
            }
        }
        if (digit == 0)
            System.out.print(number[0]);
        else{
					System.out.print(number[digit]);
            for (int i = digit-1; i >= 0; i--)
                System.out.printf("%04d", number[i]);
				}
			System.out.println();
    }
}