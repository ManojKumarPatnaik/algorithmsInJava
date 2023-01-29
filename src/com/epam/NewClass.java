package com.epam;

public class NewClass {
    static int getMin(int n){
        if(n<=1){
            return 0;
        }
        int x=n-1;
        int y=Integer.MAX_VALUE,z=Integer.MAX_VALUE;
        if(n%3==0){
            y=n/3;
        }
        if((n&1)==0){
            z=n/2;
        }
        return 1+Math.min(x,Math.min(y,z));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 11; i++) {

            System.out.println(getMin(i));
        }

    }
}
