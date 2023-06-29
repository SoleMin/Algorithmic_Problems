import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.BufferedWriter;
import java.util.Random;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jialin Ouyang (Jialin.Ouyang@gmail.com)
 */
public class Main {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    QuickScanner in = new QuickScanner(inputStream);
    QuickWriter out = new QuickWriter(outputStream);
    TaskB solver = new TaskB();
    solver.solve(1, in, out);
    out.close();
  }

  static class TaskB {
    static boolean LOCAL = false;
    static int TEST_CASE = 10000;
    QuickScanner in;
    QuickWriter out;
    int n;
    Server server;

    public void solve(int testNumber, QuickScanner in, QuickWriter out) {
      this.in = in;
      this.out = out;
      n = LOCAL ? 1 << 16 : in.nextInt();
      server = new Server();
      for (int remCases = LOCAL ? TEST_CASE : 1; remCases > 0; --remCases) {
        server.init(n);
        Rect[] rects = split(0);
        if (rects == null) {
          rects = split(1);
        }
        rects[0] = shrink(rects[0]);
        rects[1] = shrink(rects[1]);
        server.answer(rects[0], rects[1]);
      }
    }

    Rect[] split(int dim) {
      int lower = 1, upper = n - 1, res = 0;
      Rect fullRect = new Rect(1, 1, n, n);
      while (lower <= upper) {
        int medium = (lower + upper) >> 1;
        if (server.ask(fullRect.update(1, dim, medium)) == 0) {
          res = medium;
          lower = medium + 1;
        } else {
          upper = medium - 1;
        }
      }
      Rect[] rects = new Rect[]{
          fullRect.update(1, dim, res + 1),
          fullRect.update(0, dim, res + 2)};
      return server.ask(rects[0]) == 1
          && server.ask(rects[1]) == 1
          ? rects : null;
    }

    Rect shrink(Rect rect) {
      rect = shrink(rect, 0);
      rect = shrink(rect, 1);
      return rect;
    }

    Rect shrink(Rect rect, int dim) {
      int lower, upper, res;
      // lower
      lower = rect.getValue(0, dim) + 1;
      upper = rect.getValue(1, dim);
      res = lower - 1;
      while (lower <= upper) {
        int medium = (lower + upper) >> 1;
        if (server.ask(rect.update(0, dim, medium)) == 1) {
          res = medium;
          lower = medium + 1;
        } else {
          upper = medium - 1;
        }
      }
      rect = rect.update(0, dim, res);
      // upper
      lower = rect.getValue(0, dim);
      upper = rect.getValue(1, dim) - 1;
      res = upper + 1;
      while (lower <= upper) {
        int medium = (lower + upper) >> 1;
        if (server.ask(rect.update(1, dim, medium)) == 1) {
          res = medium;
          upper = medium - 1;
        } else {
          lower = medium + 1;
        }
      }
      return rect.update(1, dim, res);
    }

    class Server {
      Rect rect1;
      Rect rect2;

      Server() {
        rect1 = new Rect();
        rect2 = new Rect();
      }

      void init(int n) {
        if (LOCAL) {
          do {
            rect1.initRandom(n);
            rect2.initRandom(n);
          } while (!rect1.valid(rect2));
          //rect1 = new Rect(2, 2, 2, 2);
          //rect2 = new Rect(3, 4, 3, 5);
        }
      }

      int ask(Rect rect) {
        out.print("? ");
        rect.print();
        out.println();
        out.flush();
        if (LOCAL) {
          return (rect1.in(rect) ? 1 : 0)
              + (rect2.in(rect) ? 1 : 0);
        } else {
          return in.nextInt();
        }
      }

      void answer(Rect rect1, Rect rect2) {
        out.print("! ");
        rect1.print();
        out.print(' ');
        rect2.print();
        out.println();
        out.flush();
        if (LOCAL) {
          if ((rect1.equals(this.rect1) && rect2.equals(this.rect2))
              || (rect2.equals(this.rect1) && rect1.equals(this.rect2))) {
            System.out.println("AC!");
          } else {
            System.out.println("WA!");
            throw new IllegalArgumentException();
          }
        }
      }

    }

    class Rect {
      final Random random = new Random();
      int x1;
      int y1;
      int x2;
      int y2;

      Rect() {
      }

      Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
      }

      void initRandom(int n) {
        x1 = random.nextInt(n);
        x2 = random.nextInt(n - x1) + x1 + 1;
        ++x1;
        y1 = random.nextInt(n);
        y2 = random.nextInt(n - y1) + y1 + 1;
        ++y1;
      }

      int getValue(int idx1, int idx2) {
        switch ((idx1 << 1) | idx2) {
          case 0:
            return x1;
          case 1:
            return y1;
          case 2:
            return x2;
          case 3:
            return y2;
        }
        throw new IllegalArgumentException();
      }

      Rect update(int idx1, int idx2, int value) {
        switch ((idx1 << 1) | idx2) {
          case 0:
            return new Rect(value, y1, x2, y2);
          case 1:
            return new Rect(x1, value, x2, y2);
          case 2:
            return new Rect(x1, y1, value, y2);
          case 3:
            return new Rect(x1, y1, x2, value);
        }
        return null;
      }

      boolean valid(Rect o) {
        if (x2 < o.x1) return true;
        if (y2 < o.y1) return true;
        if (o.x2 < x1) return true;
        if (o.y2 < y1) return true;
        return false;
      }

      boolean in(Rect o) {
        return o.x1 <= x1 && x2 <= o.x2
            && o.y1 <= y1 && y2 <= o.y2;
      }

      boolean equals(Rect o) {
        return x1 == o.x1 && y1 == o.y1
            && x2 == o.x2 && y2 == o.y2;
      }

      void print() {
        out.printf("%d %d %d %d", x1, y1, x2, y2);
      }

    }

  }

  static class QuickScanner {
    private static final int BUFFER_SIZE = 1024;
    private InputStream stream;
    private byte[] buffer;
    private int currentPostion;
    private int numberOfChars;

    public QuickScanner(InputStream stream) {
      this.stream = stream;
      this.buffer = new byte[BUFFER_SIZE];
      this.currentPostion = 0;
      this.numberOfChars = 0;
    }

    public int nextInt() {
      int c = nextNonSpaceChar();
      boolean positive = true;
      if (c == '-') {
        positive = false;
        c = nextChar();
      }
      int res = 0;
      do {
        if (c < '0' || '9' < c) throw new RuntimeException();
        res = res * 10 + c - '0';
        c = nextChar();
      } while (!isSpaceChar(c));
      return positive ? res : -res;
    }

    public int nextNonSpaceChar() {
      int res = nextChar();
      for (; isSpaceChar(res) || res < 0; res = nextChar()) ;
      return res;
    }

    public int nextChar() {
      if (numberOfChars == -1) {
        throw new RuntimeException();
      }
      if (currentPostion >= numberOfChars) {
        currentPostion = 0;
        try {
          numberOfChars = stream.read(buffer);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
        if (numberOfChars <= 0) {
          return -1;
        }
      }
      return buffer[currentPostion++];
    }

    public boolean isSpaceChar(int c) {
      return c == ' '
          || c == '\n'
          || c == '\r'
          || c == '\t'
          || c < 0;
    }

  }

  static class QuickWriter {
    private final PrintWriter writer;

    public QuickWriter(OutputStream outputStream) {
      this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public QuickWriter(Writer writer) {
      this.writer = new PrintWriter(writer);
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; ++i) {
        if (i > 0) {
          writer.print(' ');
        }
        writer.print(objects[i]);
      }
    }

    public void println(Object... objects) {
      print(objects);
      writer.print('\n');
    }

    public void printf(String format, Object... objects) {
      writer.printf(format, objects);
    }

    public void close() {
      writer.close();
    }

    public void flush() {
      writer.flush();
    }

  }
}

