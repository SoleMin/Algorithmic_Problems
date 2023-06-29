//package com.example.programming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class CodeforcesProblems {


    static class Pair {
        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
        int key;
        int val;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(br.readLine());

        String[] strings = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }


        HashMap<Integer, ArrayList<Pair>> segments = new HashMap<>();
        for(int r = 0; r<arr.length; r++) {
            int sum = 0;
            for(int l = r; l>=0; l--) {
                sum += arr[l];
                ArrayList<Pair> pairs = segments.get(sum);
                if(pairs == null) {
                    pairs = new ArrayList<>();
                    segments.put(sum, pairs);
                }
                pairs.add(new Pair(l, r));
            }
        }

        int res = 0;
        ArrayList<Pair> result = new ArrayList<>();
        for(ArrayList<Pair> pairs: segments.values()) {
            ArrayList<Pair> temp = new ArrayList<>();
            int count = 0;
            int r = -1;
            for(Pair p : pairs) {
                if(p.key>r) {
                    count++;
                    temp.add(p);
                    r = p.val;
                }
            }
            if(count>res) {
                res = count;
                result = temp;
            }
        }
        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        for(Pair p : result){
            sb.append(p.key+1).append(' ').append(p.val+1).append('\n');
        }
        System.out.print(sb);
    }
}
