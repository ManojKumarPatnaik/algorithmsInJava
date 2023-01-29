package org.example;

import java.util.*;

public class Solution {
     public static List<List<Integer>> permute1(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> ds = new ArrayList<>();
         int l= nums.length;
         boolean v[] = new boolean[l];
         rev(nums,ds,ans,v,l);
         return ans;
     }


     private static void rev(int nums[], List<Integer> ds, List<List<Integer>> ans, boolean v[], int l){
         if(l==ds.size()){
             ans.add(new ArrayList<>(ds));
             return;
         }
         for(int i=0;i<l;i++){
             if(!v[i]){
                 v[i]=true;
                 ds.add(nums[i]);
                 rev(nums,ds,ans,v,l);
                 ds.remove(ds.size()-1);
                 v[i]=false;
             }
         }
     }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rev(nums,0,nums.length,ans);
        return ans;
    }
    private static void rev(int nums[],int j,int n,List<List<Integer>> ans){
        if(j>=n){
            var l= new ArrayList<Integer>();
            for(var v:nums) {
                l.add(v);
            }
            ans.add(l);
            return;
        }
        for(int i=j;i<n;i++){
            swap(nums,i,j);
            rev(nums,j+1,n,ans);
            swap(nums,i,j);
        }
    }
    private static void swap(int A[],int i,int j){
        int t= A[i];
        A[i]=A[j];
        A[j]=t;
    }
    static void permuattion(int A[], int k, int l, HashSet<Integer> a, int start){
         if(a.size()==k){
             System.out.println(a);
             return;
         }
         if(start==l) {
             return;
         }
        for (int i = start; i < l; i++) {
                a.add(A[i]);
                permuattion(A,k,l,a,i+1);
                a.remove(A[i]);
            }

    }

    static int maximize(int day,int task,int[][] A,int dp[][]){
        if(day==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=task){
                    max=Math.max(max,A[0][i]);
                }
            }
            return max;
        }
        if(dp[day][task]!=0) {
            return dp[day][task];
        }
        int max=0;
        for (int i = 0; i < 3; i++) {
            if(i!=task){
                int point = A[day][i]+maximize(day-1,task,A,dp);
                max = Math.max(max, point);
            }
        }
        dp[day][task] = max;
        return  dp[day][task];
    }
    static int binomialCooffectient(int n,int k){
         int dp[][] = new int[n+1][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0]=1;
            if(i<=k){
                dp[i][i]=1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1 ; j <= k; j++) {
                dp[i][j]= dp[i-1][j]+dp[i-1][j-1];
            }

        }return dp[n][k];

    }
    static int knapsack(int weights[],int values[],int weight,int index,int dp[][]){
         if(index==-1 || weight==0 ) {
             return 0;
         }
         if(dp[weight][index]!=0){
             return dp[weight][index];
         }
         if(weights[index]<=weight){
             int include = weights[index]+knapsack(weights, values, weight-weights[index], index-1,dp);
             int exclude = knapsack(weights, values, weight, index-1,dp);
             return dp[weight][index]=Math.max(include,exclude);
         }else{
             return dp[weight][index]=knapsack(weights, values, weight, index-1,dp);
         }
    }
    static int knapsackDp(int[] weights, int[] values, int weight){
         int l= values.length;
        int[][] dp = new int[l+1][weight+1];
        for (int i = 1; i <=l ; i++) {
            for (int j = 1; j <=weight ; j++) {
                if(weights[i-1]<=weight){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][weight-weights[i-1]]+values[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }


        }}return dp[l][weight];
    }

    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }
        public V getValue() {
            return this.value;
        }
    }
    class LFUCache {
        // key: original key, value: frequency and original value.
        private Map<Integer, Pair<Integer, Integer>> cache;
        // key: frequency, value: All keys that have the same frequency.
        private Map<Integer, LinkedHashSet<Integer>> frequencies;
        private int minf;
        private int capacity;

        private void insert(int key, int frequency, int value) {
            cache.put(key, new Pair<>(frequency, value));
            frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
            frequencies.get(frequency).add(key);
        }

        public LFUCache(int capacity) {
            cache = new HashMap<>();
            frequencies = new HashMap<>();
            minf = 0;
            this.capacity = capacity;
        }

        public int get(int key) {
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue == null) {
                return -1;
            }
            final int frequency = frequencyAndValue.getKey();
            final Set<Integer> keys = frequencies.get(frequency);
            keys.remove(key);
            if (minf == frequency && keys.isEmpty()) {
                ++minf;
            }
            final int value = frequencyAndValue.getValue();
            insert(key, frequency + 1, value);
            return value;
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            Pair<Integer, Integer> frequencyAndValue = cache.get(key);
            if (frequencyAndValue != null) {
                cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
                get(key);
                return;
            }
            if (capacity == cache.size()) {
                final Set<Integer> keys = frequencies.get(minf);
                final int keyToDelete = keys.iterator().next();
                cache.remove(keyToDelete);
                keys.remove(keyToDelete);
            }
            minf = 1;
            insert(key, 1, value);
        }
    }


//      Definition for singly-linked list.

    static boolean isPalandreome(String w,int i,int j) {
         if(i>j) {
             return true;
         }
         if(w.charAt(i)!=w.charAt(j)){
             return false;
         }return isPalandreome(w,i+1,j-1);
    }
    static int minDeletion(String w, int i, int j, int[][] dp) {
        if(i>=j) {
            return 0;
        }
        if(dp[i][j]!=-1) {
            return dp[i][j];
        }
        if(w.charAt(i)!=w.charAt(j)){
            return dp[i][j] = Math.min(minDeletion(w,i+1,j,dp),minDeletion(w,i,j-1,dp));
        } else {
            return dp[i][j]=minDeletion(w,i+1,j-1,dp)+1;
        }
    }
    static int minManulOfTwoString(int i,int j, String A,String B,int dp[][]){
         if(i==-1) {
             return i+1;
         }
         if(j==-1) {
             return j+1;
         }
         if(dp[i][j]!=-1){
             return dp[i][j];
         }
         if(A.charAt(i)==B.charAt(j)) {
             return dp[i][j]=minManulOfTwoString(i-1,j-1,A,B,dp);
         } else {
             return dp[i][j]=1+Math.min(minManulOfTwoString(i,j-1,A,B,dp),
                     Math.min(minManulOfTwoString(i-1,j-1,A,B,dp)
                     ,minManulOfTwoString(i-1,j,A,B,dp)));
         }
    }

    static int minManulOfTwoStringTabulation(String A, String B) {
        int m = A.length(), n = B.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j - 1]
                                    , dp[i - 1][j]));
                }
            }
        }

        for(var v: dp){
            System.out.println(Arrays.toString(v));
        }
        return dp[m][n];
    }
    static boolean memomatches(int m, int n,String A,String B,Boolean dp[][]){
        if (( m==-1 && n==-1) || B.substring(0,n+1).equals("*")) {
            return true;
        } else if (m==-1 || n==-1) {
            return false;
        }
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        if(A.charAt(m)==B.charAt(n)){
            return dp[m][n]=memomatches(m-1,n-1,A,B,dp);
        } else if (B.charAt(n)=='.') {
            return dp[m][n]=memomatches(m-1,n-1,A,B,dp);
        }else if (B.charAt(n)=='*'){
            return dp[m][n]=memomatches(m-1,n,A,B,dp) || memomatches(m,n-1,A,B,dp);
        }return false;

    }

    static boolean memomatchesTableation(String A, String B) {
        int r = A.length(), c = B.length();
        boolean[][] dp = new boolean[r + 1][c + 1];
        dp[0][0] = true;
        for (int m = 1; m <= r; m++) {
            for (int n = 1; n <= c; n++) {
                if (A.charAt(m - 1) == B.charAt(n - 1)) {
                    dp[m][n] = dp[m - 1][n - 1];
                } else if (B.charAt(n - 1) == '.') {
                    dp[m][n] = dp[m - 1][n - 1];
                } else if (B.charAt(n - 1) == '*') {
                    dp[m][n] = dp[m - 1][n] || dp[m][n - 1];
                }
            }
        }
        return dp[r][c];
    }

    static int bottomUpOrTabulation(String w) {
        int l = w.length();
        int[][] dp = new int[l][l];
        for(var v: dp){
            Arrays.fill(v,-1);
        }
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j <= l - i; j++) {
                int k = i + j - 1;
                if (j == k) {
                    dp[j][k]=0;
                    continue;
                }
                if (w.charAt(j) == w.charAt(k)) {
                    dp[j][k] = dp[j + 1][k - 1];
                } else {
                    dp[j][k] = Math.min(dp[j + 1][k], dp[j][k - 1]) + 1;
                }
            }
        }
        return dp[0][l - 1];
    }

    public static void main(String[] args) {
        System.out.println(memomatches(4,3,"ABBAD",".BA*",new Boolean[5][4]));
        System.out.println(memomatchesTableation("ABBAD",".*A*"));

        String maddrdam = "maddrddam";
        int l= maddrdam.length();
        int dp[][] = new int[l][l];
        for(var v: dp){
            Arrays.fill(v,-1);
        }
        System.out.println(minManulOfTwoString(2,3,"GET","GOAT",dp));
        System.out.println(minManulOfTwoStringTabulation("GET","GOAT"));
        for(var v:dp){
            System.out.println(Arrays.toString(v));
        }
        System.out.println(bottomUpOrTabulation(maddrdam));
        System.out.println(Arrays.deepToString(dp));
//        System.out.println(binomialCooffectient(5,3));
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2,new ListNode(4));
        ListNode listNode1 = new ListNode(3);
        listNode1.next = new ListNode(5,new ListNode(6));
        Solution1 solution1=new Solution1();
        ListNode listNode2 = solution1.mergeTwoLists(listNode1, listNode);
//        while(listNode2!=null){
//            System.out.println(listNode2.val);
//            listNode2=listNode2.next;
//        }
        String a1="acdefrds",a2="acdefrddff";
        System.out.println(Solution1.lcs(a1.length()-1,a2.length()-1,a1,a2));
        System.out.println(Solution1.memo(a1.length()-1,a2.length()-1,a1,a2,new int[a1.length()][a2.length()]));
        int n = 3;
        int A1[][] = {
                {10, 11, 19},
                {4, 13, 7},
                {1, 8, 13}
        };
//        int dp[][] = new int[n][4];
//        System.out.println(maximize(n-1,3,A1,dp));
        var A = new int[]{1, 2, 3,4,5,6,7,8,9,10,11,12};
        cominationSum(A,0,10,new ArrayList<>(),0);
//        permuattion(A,3,A.length,new HashSet<>(),0);
        System.out.println("A = ");
//        System.out.println(permute1(A));
    }
    static void cominationSum(int[] A, int sum, int target,List<Integer> partial,int start){
         if(sum==target){
             System.out.println(Arrays.toString(partial.toArray()));
             return;
         }
        for (int i = start; i < A.length; i++) {
            int c= A[i];
            if(sum+c>target || i>start && A[i]==A[i-1]){
                continue;
            }
            partial.add(c);
            cominationSum(A,sum+c,target,partial,i+1);
            partial.remove(partial.size()-1);
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 class Solution1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }
        if(l2==null) {
            return l1;
        }
        ListNode head = null;
        if(l1.val<l2.val){
            head=l1;
            // l1=l1.next;
            head.next = mergeTwoLists(l1.next,l2);
        }else {
            head=l2;
            head.next = mergeTwoLists(l1,l2.next);
            // l2=l2.next;
        }
        // ListNode pre = head;
        // while(l1!=null && l2!=null){
        //     if(l1.val<l2.val){
        //         pre.next=l1;
        //         l1=l1.next;
        //     }else {
        //         pre.next=l2;
        //         l2=l2.next;
        //     }pre=pre.next;
        // }
        // pre.next = (l1!=null)? l1: l2;
        return head;

    }

     static int lcs(int i,int j,String s,String t){
        if(i==-1 || j==-1){
            return 0;
        }
        if(s.charAt(i)==t.charAt(j)){
            return lcs(i-1,j-1,s,t)+1;
        }else {
            return Math.max(lcs(i-1,j,s,t),lcs(i,j-1,s,t));
        }
     }
     static int memo(int i,int j,String s,String t,int dp[][]){
         if(i==-1 || j==-1){
             return 0;
         }
         if(dp[i][j]!=0){
             return dp[i][j];
         }
         if(s.charAt(i)==t.charAt(j)){
             return dp[i][j]=lcs(i-1,j-1,s,t)+1;
         }else {
             return dp[i][j]=Math.max(lcs(i-1,j,s,t),lcs(i,j-1,s,t));
         }
     }
}
