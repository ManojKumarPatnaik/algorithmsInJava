package com.epam;


import java.util.HashMap;

public class MergeSort {
    private int[] nums;
    private int[] temp;
    public int size;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.size = nums.length;
        this.temp = new int[size];
    }

    public void sort() {
        mergeSort(0, size - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        if (high + 1 - low >= 0) System.arraycopy(nums, low, temp, low, high + 1 - low);
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                nums[k++] = temp[j++];
            } else {
                nums[k++] = temp[i++];
            }
        }
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        while (j <= high) {
            nums[k++] = temp[j++];
        }
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort(new int[]{1, 2, 3, 4, 5});
        mergeSort.sort();
        mergeSort.show();
        System.out.println();
        int twoEggs = mergeSort.twoEggs(2, 100);
        System.out.println(twoEggs);
        System.out.println(mergeSort.anagrams("absd","abdsd"));
        System.out.println(mergeSort.largestSubarray(new int[]{1,-2,3,4,-5,8}));
    }

    public  int largestSubarray(int A[]){
        int mG=A[0],mc=A[0];
        for (int i = 0; i < A.length; i++) {
            mc=Math.max(A[i],mc+A[i]);
            mG=Math.max(mG,mc);
        }return mG;
    }

    public int minHeightShelves(int[][] B, int S) {
        int L = B.length, dp[] = new int[L + 1];
        for (int i = 1; i <= L; i++) {
            int ht = B[i - 1][1];
            dp[i] = dp[i - 1] + ht;
            int j = i - 1, wt = B[i - 1][0];
            while (j > 0 && wt + B[j - 1][0] <= S) {
                ht = Math.max(ht, B[j - 1][1]);
                wt += B[j - 1][0];
                dp[i] = Math.min(dp[i], dp[j-- - 1] + ht);
            }
        } return dp[L];
    }
    public boolean anagrams(String a,String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int A[]= new int[26];

        for (int i = 0; i < a.length(); i++)
        A[a.charAt(i)-'a']++;
        for (int i = 0; i < a.length(); i++) {
            if(A[b.charAt(i)-'a']>0)A[b.charAt(i)-'a']--;
            else return false;
        }
return true;
    }

    public int twoEggs(int x, int y){
        int dp[][]=new int[x+1][y+1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 0; i <= y; i++) {
            dp[1][i]=i;
        }
        for (int i = 2; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int maxDrop = 1+ Math.max(dp[i-1][k-1],dp[i][j-k]);
                    dp[i][j] = Math.min(dp[i][j], maxDrop);
                }
            }
        }
        for (int i  = 0; i <=x ; i++) {
            for (int j = 0; j <= y; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[x][y];
    }

}
