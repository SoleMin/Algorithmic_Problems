/*
 * The MIT License
 *
 * Copyright 2016 Mouad NACIRI <mouadnaciri1@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author NACIRI Mouad <mouadnaciri1@gmail.com>
 * @version 1.5.1
 */

public class MainA {
    /* VIP, DON'T TOUCH!! */
    static StringTokenizer ST;
    static BufferedReader IN;
    static BufferedWriter OUT;
    static {
        IN = new BufferedReader(new InputStreamReader(System.in));
        OUT = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    
    public static void main(String[] args) throws IOException {
        
        pl("25");
        cAll();
    }
    
    //IO stuff...
    static void ll() throws IOException { ST = new StringTokenizer(nlnt()); }
    static void ll(String del) throws IOException { ST = new StringTokenizer(nlnt(), del); }
    static void ll(String s, String del) throws IOException { ST = new StringTokenizer(s, del); }
    static void ll(String s, char c) throws IOException { ST = new StringTokenizer(s); }
    
    static int tlen() { return ST.countTokens(); }
    static boolean hn() { return ST.hasMoreTokens(); }
    static String n() throws IOException { return ST.nextToken(); }
    static String nln() throws IOException {
        String l;
        while((l = IN.readLine()) != null && l.trim().length() == 0) {}
        return l;
    }
    static String nlnt() throws IOException {
        String l;
        while((l = IN.readLine()) != null && (l = l.trim()).length() == 0) {}
        return l;
    }
    static boolean nbl() throws IOException { return Boolean.parseBoolean(ST.nextToken()); }
    static byte nb() throws IOException { return Byte.parseByte(ST.nextToken()); }
    static byte nb(int radix) throws IOException { return Byte.parseByte(ST.nextToken(), radix); }
    static double nd() throws IOException { return Double.parseDouble(ST.nextToken()); }
    static float nf() throws IOException { return Float.parseFloat(ST.nextToken()); }
    static int ni() throws IOException { return Integer.parseInt(ST.nextToken()); }
    static int ni(int radix) throws IOException { return Integer.parseInt(ST.nextToken(), radix); }
    static long nl() throws IOException { return Long.parseLong(ST.nextToken()); }
    static long nl(int radix) throws IOException { return Long.parseLong(ST.nextToken(), radix); }
    static short ns() throws IOException { return Short.parseShort(ST.nextToken()); }
    static short ns(int radix) throws IOException { return Short.parseShort(ST.nextToken(), radix); }
    
    static void p(String s) throws IOException { OUT.write(s); }
    static void p(char c) throws IOException { OUT.write(c); }
    static void p(char s[]) throws IOException { OUT.write(s); }
    static void pl(String s) throws IOException { OUT.write(s); OUT.newLine(); }
    static void pl(char c) throws IOException { OUT.write(c); OUT.newLine(); }
    static void pl(char s[]) throws IOException { OUT.write(s); OUT.newLine(); }
    static void pl() throws IOException { OUT.newLine(); }
    static void cAll() throws IOException { IN.close(); OUT.close(); }
    
}
