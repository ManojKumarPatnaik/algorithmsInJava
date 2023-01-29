package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    static List<String> subseq(String in, String out, List<String> ans) {
        if (in.isEmpty()) {
            ans.add(out);
            return ans;
        }
        subseq(in.substring(1), out, ans);
        subseq(in.substring(1), out + in.charAt(0), ans);
        return ans;
    }


    class SummaryRanges {


        private ArrayList<int[]> intervals;
        public SummaryRanges() {
            intervals = new ArrayList<>();
        }
        private void addValueToRange(int value, int index) {
            int[] interval = intervals.get(index);
            int lowRange = interval[0], highRange = interval[1];
            if (index > 0 && value == lowRange - 1 && intervals.get(index - 1)[1] + 1 >= value) {
                // ex. 3-3 5-6 [insert 4] - merge with left one
                intervals.get(index - 1)[1] = highRange;
                intervals.remove(index);
                return;
            } else if (index + 1 < intervals.size() && value == highRange + 1 && intervals.get(index + 1)[0] - 1 <= value) {
                // ex. 3-3 [insert 4] 5-6 - merge with right
                intervals.get(index)[1] = intervals.get(index + 1)[1];
                intervals.remove(index + 1);
                return;
            }
            if (value == lowRange - 1) {
                intervals.get(index)[0] = value;
            } else if (value == highRange + 1) {
                intervals.get(index)[1] = value;
            }
        }
        public void addNum(int value) {
            if (intervals.isEmpty()) {
                intervals.add(new int[]{value, value});
                return;
            }

            int start = 0, end = intervals.size() - 1;
            while (start < end) {
                int middle = (start + end) / 2;
                int[] currentInterval = intervals.get(middle);
                int currentLowRange = currentInterval[0], currentHighRange = currentInterval[1];
                if (value < currentLowRange - 1) {
                    end = middle - 1;
                    continue;
                }
                if (value > currentHighRange + 1) {
                    start = middle + 1;
                    continue;
                }
                // value >= currentLowRange - 1 && value <= currentHighRange + 1, so it's in range
                addValueToRange(value, middle);
                return;
            }
            if (start == end && value >= intervals.get(start)[0] - 1 && value <= intervals.get(start)[1] + 1) {
                addValueToRange(value, start);
                return;
            }
            int index = Math.max(start, end);
            while (index >= 0 && intervals.get(index)[0] > value) {
                index--;
            }
            intervals.add(index + 1, new int[]{value, value});
        }

        public int[][] getIntervals() {
            int[][] results = new int[intervals.size()][];
            for (int i = 0; i < intervals.size(); i++) {
                results[i] = intervals.get(i);
            } return results;
        }
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(value);
     * int[][] param_2 = obj.getIntervals();
     */
    static int getMin(int n){
        if(n<=1){
            return 0;
        }
        int x=getMin(n-1);
        int y=Integer.MAX_VALUE,z=Integer.MAX_VALUE;
        if(n%3==0){
            y=getMin(n/3);
        }
        if((n&1)==0){
            z=getMin(n/2);
        }
        return 1+(Math.min(x,Math.min(y,z)));
    }
    static int topDownDP(int n,int A[]){
        if(n<=1){
            return 0;
        }
        if(A[n]!=-1){
            return A[n];
        }
        int x=topDownDP(n-1,A);
        int y=Integer.MAX_VALUE,z=Integer.MAX_VALUE;
        if(n%3==0){
            y=topDownDP(n/3,A);
        }
        if((n&1)==0){
            z=topDownDP(n/2,A);
        }
        A[n] = Math.min(x, Math.min(y, z))+1;
        return  A[n];
    }
    static int bottomUpDP(int n){
        int dp[]=new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+1;
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            if((i&1)==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
        }return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(subseq("abc","",new ArrayList<>()));
        // TODO Auto-generated method stub
        int i=256;
        int A[] = new int[i+1];
        Arrays.fill(A,-1);
        System.out.println(getMin(i));
        System.out.println(topDownDP(i,A));
        System.out.println(bottomUpDP(i));

    }
}