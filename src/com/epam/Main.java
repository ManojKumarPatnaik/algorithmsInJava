package com.epam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


public class Main {

    public static int fib(int x, int y){
        if(x==0||x==1) return x;
        return fib(x-1, x+y)+fib(x-2,y+x);
    }
    public static int russianMultiply(int a,int b) {
        int re=0;
        while (b>0){
            if((b^1)==b-1)re+=a;
            a<<=1;
            b>>=1;
        }return re;
    }
    public static int bist(int x[], int t,int l,int r){
        if(l>r) return -1;
        int m=(l+r)/2;
        if(x[m]==t) return m;
        else if(x[m]>t) return bist(x,t,l,m-1);
        else return bist(x,t,m+1,r);
    }
    public static void main(String[] args) throws URISyntaxException {
        int nums2[]={0,1,9,8,7,6,5,4,3,2,1,2};
        MergeSort mergeSort = new MergeSort(nums2);
        mergeSort.sort();
        mergeSort.show();

        System.out.println(russianMultiply(10,20));
        System.out.println(bist(new int[]{1,2,3,4,5,6,7,8,9,10,11,12},0,0,11));
        System.out.println(fib(10,0));
        System.out.println((88720.0%100)/100);
        System.out.println((102^1)==103);
//        cosmosPatchOperation.patchRecordBasedOnIdAndKey(itemId,
//                vendorId, containerName);
//        var result = new HashSet<String>();
        String d="d";
//        result.
        boolean matches = "Alic3".matches("A-Za-z1-9");
        System.out.println(matches);
//        int A[]={1,2};
//        boolean equals = Arrays.equals(A, new int[]{1, 2});
//        var max=new PriorityQueue<Integer>(Collections.reverseOrder());
//        max.offer(1);
//        max.isEmpty();
        int[][] g ={
                {1,2,4},{3,3,1}
        };

        int a=0;
        int c=0;
        int m=g.length;
        int n=g[0].length;
        int[] A =new int[m+n+1];
        for (int[] ints : g) {
            for (int anInt : ints) {
                A[c] = anInt;
                c++;
            }
        }
        Arrays.sort(A);
        for(int i=A.length-1;i>0;i-=2){
            a+=Math.max(A[i],A[i-1]);
        }
        System.out.println(a);

//        System.out.println(equals);
        double value = calculateQuoteCostCAD();
        URI uri = new URI("https://devsystemecsccst.blob.core.windows.net/cattdutyrate/InvalidRecords/CATT_Invalid_2022-12-23T184127.4936246Z.csv");
        String[] names = uri.getPath().split("/");
        System.out.println(Arrays.toString(names));
        String containerName = names[1];
        int lastIndex = uri.getPath().lastIndexOf("/");
        String blobName = uri.getPath().substring(lastIndex+1);
        int firstDotIndex = uri.getHost().indexOf(".");
        System.out.println(containerName+" "+blobName+" "+firstDotIndex);
        System.out.println("Actual precision value = "+value);
        System.out.println(uri.getHost().substring(0,firstDotIndex));
        blobName = names[2] +
                "/" + names[3];
        var mp=new HashMap<String,Integer>();
//        mp.
//        System.out.println(blobName);
    }
    public static  double calculateQuoteCostCAD() {
        return (8.65 / 1.0 *(1.0 - (5.0/100))) *0.98;
    }
    public static double limitDecimals(double value, int noOfDecimals) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(noOfDecimals, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
