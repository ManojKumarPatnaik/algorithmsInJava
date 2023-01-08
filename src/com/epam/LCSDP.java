package com.epam;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LCSDP {

    public static void main(String[] args) {
        int A[][]= {{1,23},{2,42},{3,44},{4,45},{5,46},{6,47},{7,12},{8,13},{9,13},{10,15},{11,16},{12,17}};
        Arrays.sort(A,(a,b)->(b[1]>a[1])?1:(a[1]==b[1])?b[0]-a[0]:-1);
        var pq = new PriorityQueue<>(new Comp());
        for(var v:A){
            pq.offer(v);
        }
        pq.forEach((var v) -> System.out.println(Arrays.toString(v)));
        System.out.println(Arrays.deepToString(A));
        AtomicLong counter = new AtomicLong();
        counter.set(253402232400000L);
        System.out.println(253402232400000L);
        System.out.println(counter.get());
        String abcde = "abcde", abst="dbvhjcjdhjfdhiudje";

        System.out.println(new LCSDP().bottomUpRecursive(abcde,abst,abcde.length(),abst.length()));
//        System.out.println(new LCSDP().lcsDp("abcde","dbvh",));
        int i=0;
        var ac=new AtomicInteger(0);
        for (var v:"ansc".toCharArray()) {
            ++i;
            ac.incrementAndGet();
        }
        System.out.println(i==ac.get());
    }

    public String lcsDp(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//        topDownIterative(s1, s2, dp);
//        bottomUpRecursive(s1,s2,s1.length(),s2.length(),dp);
        String answer = "";
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                answer += s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return new StringBuilder(answer).reverse().toString();

    }
    private int  bottomUpRecursive(String s1, String s2, int m,int n){
        if(m==0 || n==0) return 0;
        if(s1.charAt(m-1) == s2.charAt(n-1)) return 1+bottomUpRecursive(s1, s2, m-1,n-1);
        else return Math.max(bottomUpRecursive(s1, s2, m-1,n),bottomUpRecursive(s1, s2,m,n-1));
    }

    private static void topDownIterative(String s1, String s2, int[][] dp) {
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }
}
