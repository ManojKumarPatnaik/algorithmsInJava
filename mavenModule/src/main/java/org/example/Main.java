package org.example;

import com.epam.Demo.Epam;

import javax.swing.tree.TreeNode;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int clearBitsItoJ(int num,int i,int j){
        int a=(~0)<<j+1;//111110000000
        int b=(1<<i)-1;//0000000000111
        int mask = a|b;//1111100000111
        return num&mask;
    }
    static int replaceBits(int n,int i,int j,int b){
        n= clearBitsItoJ(n,i,j);
        int mask = (b<<i);
        return n|mask;
    }
    static void  powerOf2(int n){
        if((n&(n-1))==0){
            System.out.println("powerOf2");
        }else System.out.println("Nothing");
    }
    static int countBits(int n){
        int c=0;
        while (n>0){
            c+=(n&1);
            n>>=1;
        }return c;
    }
    static int countBitsHack(int n){
        int c=0;
        while (n>0){
            n=(n&n-1);
            c++;
        }return c;
    }
    static  int binaryToBits(int n){
        int ans=0,pow=1;
        while (n>0){
            ans=(ans+pow)*(n&1);
            pow*=10;
            n>>=1;
        }return ans;
    }
    static int unqie3(int A[]){
        int B[]=new int[32];
        for (int k : A) {
            for (int j = 0; j < 32; j++) {
                if ((k & (1 << j)) == 1) B[j]++;
            }
        }
        for (int i = 0; i < 32; i++) {
            B[i]=B[i]%3;
        }
        int ans=0;
        for (int i = 0; i < 32; i++) {
            ans+=(B[i]*(1<<i));
        }return ans;
    }
    static  int sumD(int n){
        if(n<10) return n;
        return n%10+sumD(n/10);
    }
    static  int countD(int n){
        if(n==0) return 0;
        return 1+countD(n/10);
    }
    static int mult(int m,int n){
        if(n==0)return 0;
        return m+mult(m,n-1);
    }
    static int countZeros(int n){
        if(n==0) return 0;
        return (n%10==0?1:0)+ countZeros(n / 10);
    }
    static double gsum(int j){
        if(j==0) return 1;
        return (1.0/Math.pow(2,j))+gsum(j-1);
    }
    static  int[] unique2(int A[]){
        int xor=0;
        for (int j : A) {
            xor ^= j;
        }
        int sec=xor,setA=0,setB=0,pos=0;
        while ((sec&1)==0){
            pos=sec&1;
            sec>>=1;
        }
        int mask=1<<pos;
        for (int j : A) {
            if ((j & mask) == 1)
                setA ^= j;
            else setB ^= j;
        }
        return new int[]{setA,setB};
    }
    static  int bst(int n){
        int s=1,e=n,ans=0;
        while (s<=e) {
            int mid = s + (e - s) / 2;
            if(mid==e/mid)return mid;
            else if(mid<e/mid){
                ans=mid;
                s=mid+1;
            }else e= mid-1;
        }return ans;
    }

    public int findJudge(int n, int[][] trust) {
        int frequency[] = new int[n + 1], judge = -1;
        for (int[] vertex : trust) frequency[vertex[1]]++;
        for (int index = 1; index <= n; index++) if (frequency[index] == n - 1) judge = index;
        for (int[] ints : trust) if (ints[0] == judge) return -1;//cycle is detected
        return judge;
    }
    static int window(int n, int[] trust){
        int l=trust.length;
        int winsum=0,max=0;
        for (int i = 0; i < n; i++) {
            winsum+=trust[i];
        }
        max=winsum;
        for (int i = 0; i < l-n; i++) {
            winsum=winsum-trust[i]+trust[i+n];
            max =Math.max(max,winsum);
        }return max;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) level.add(0);
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    int index = flag ? i : (size - 1 - i);
//                    level.set(index, currentNode.val);
//                    if (currentNode.left != null) queue.add(currentNode.left);
//                    if (currentNode.right != null) queue.add(currentNode.right);
                }
            }
            flag = !flag;
            answer.add(level);
        }
        return answer;
    }
    static int[] zeros(int A[]){
//        int Aa[]=new int[A.length];
        int j=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=0){
                A[j++]=A[i];
            }
        }while (j<A.length-1)A[j++]=0;
        return A;
    }
    static int boats(int A[],int level){
        int bo=0,s=0,e=A.length-1;
        Arrays.sort(A);
        while (s<=e) {
        if(  A[s]+A[e]<=level){
            bo++;
            s++;e--;
        }else if(A[e]<=level){
            e--;
            bo++;
//        }else{
//            s++;
//            bo++;
        }
        }return bo;
    }
    static boolean montain(int A[]){
        int L=A.length,i=1;
        while(i<L && A[i]>A[i-1])i++;
        if(i==1 || i==L) return false;
        while (i<L && A[i]<A[i-1])i++;
        return i==L;
    }
    static int trre(int A[]){
        var t= new TreeMap<Integer,Integer>();
        t.put(1,1);
        t.put(2,2);
        t.put(0,3);
        System.out.println(t);
return -1;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }

    }

        public static int[] md(int n,String s){
            int A[]=new int[n];
            int st=1,e=n,k=0,l=s.length();
            while(l-->0){
                if(s.charAt(k)=='D')A[k++]=e--;else A[k++]=st++;
            }
            A[k]=st;
            return A;
        }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null) return null;
        if(left!=null && right!=null) return root;
        if(left==null) return right;
        return left;
    }
    private int ans = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] F, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<F.length;i++) adj.get(F[i][0]).add(new int[]{F[i][1],F[i][2]});
        boolean V[]= new boolean[n];
        dfs(src,dst,k,0,V,adj);
        return (ans==Integer.MAX_VALUE)? -1 : ans;
    }
    private void dfs(int s,int d,int k,int cost,boolean V[],List<List<int[]>> adj){
        if(k<-1) return;
        if(s==d){
            ans = Math.min(cost,ans);
            return;
        }V[s]=true;
        for(int i=0;i<adj.get(s).size();i++){
            int p[]=adj.get(s).get(i);
            if(!V[p[0]] && cost+p[1]<=ans) dfs(p[0],d,k-1,cost+p[1],V,adj);
        }V[s]=false;
    }
    public static void main(String[] args) throws IOException {
        int a = 2;
        int b = 3;
        int c = 4;
        if (a < b)
        {
            if (b < c)
            {
                if (c < a) {
                    System.out.println(a + " " + b + " " + c);
                } else {
                    System.out.println(c + " " + b + " " + a);
                }
            }
            else {
                System.out.println(a + " " + c + " " + b);
            }
        }
        else {
            System.out.println(b + " " + a + " " + c);
        }
        int n = 123456789;
        int m = 0;
        while (n != 0)
        {
            m = (10 * m) + (n % 10);
            n = n / 10;
        }
        int i=0,j=0;
        for (i = 0, j = 0; i < 10; i++)
            j += i;
        System.out.println(j);
//        System.out.println(Arrays.toString(md(9,"DDIIDIID")));
//        int[] a1 = {1, 2, 3, 4, 5, 4, 3, 9, 1};
//        System.out.println(trre(a1));
//        System.out.println(montain(a1));
//        System.out.println(boats(new int[]{3,2,2,1,1},4));
//        System.out.println(window(2,new int[]{80,-50,90,100}));
//        System.out.println(Arrays.toString(zeros(new int[]{0,80,0,90,0})));;
////        System.out.println(bst(8));
////        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
////        list.clear();
////        Object[] objects = list.toArray();
//        var q=new LinkedList<Integer>();
//        q.poll();
//
//
//        System.out.println(gsum(3));
//        System.out.println(countZeros(102030));
//        System.out.println(mult(5,3));
//        System.out.println(countD(12345));
//        System.out.println(sumD(12345));
//        System.out.println(unqie3(new int[]{1,2,3,1,2,4,3}));
//        System.out.println(Arrays.toString(unique2(new int[]{1,1,2,2,4,3,3,5,5,6,6,7})));
//        System.out.println(binaryToBits(9));
//        powerOf2(14);
//        System.out.println(countBitsHack(9));
//        System.out.println(replaceBits(15,1,3,2));
//        Epam epam = new Epam();
////        Files.lines(Paths.get("src/main/resources/Demo.txt")).map(i->i.split(" "))
////                .flatMap(Arrays::stream).distinct()
////                .sorted().forEach(System.out::println);
//        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
//        List<String> stringList = List.of("madam", "a", "b", "c", "d", "e", "y");
//        boolean allMatch = stringList.parallelStream().allMatch(Main::isPalindrome);
//        System.out.println(allMatch);
//        integerList.parallelStream().collect(Collectors.groupingBy(Integer::intValue,
//                Collectors.mapping(Integer::intValue,
//                        Collectors.toList()))).forEach((a, c) -> System.out.println(a + "" + c));
//        Integer reduce = integerList.stream().reduce(1, (a,d)->a*d);
//        System.out.println(reduce);
//        print();
//        printNumbers(10);
//        Stack<int[]> stack = new Stack<>();
//        String a="ddaabbaaabcccadee";
//        int k=3;
//        for (int i = 0; i < a.length(); i++) {
//            int charAt = a.charAt(i);
//            if(stack.isEmpty()|| charAt !=stack.peek()[0]){
//                stack.push(new int[]{charAt,1});
//            }else{
//                int i1 = ++stack.peek()[1];
//                if(i1 == k) stack.pop();
//            }
//        }
//        String ans ="";
//        while (!stack.isEmpty()){
//            int cnt = stack.peek()[1];
//            while (cnt-->0) ans+=stack.peek()[0];
//            stack.pop();
//        }
//
//        System.out.println("Hello world!");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answerList = new ArrayList<>();
        int stringLength = s.length();
        String[][] storeValidPalindrome = storeValidPalindrome(s, stringLength, new String[stringLength][stringLength]);
        dfs(storeValidPalindrome, answerList, new ArrayList<>(), 0);
        return answerList;
    }

    private String[][] storeValidPalindrome(String s, int length, String[][] strings) {
        for (int i = 0; i < length; i++)//store all palindromes
            for (int j = i; j < length; j++)
                if (isPalindrome(s, i, j)) strings[i][j] = s.substring(i, j + 1);
        return strings;
    }

    private void dfs(String[][] storeValidPalindrome, List<List<String>> ans, List<String> step, int index) {
        int length = storeValidPalindrome.length;
        if (index >= length) {//add sub problem to the final ans
            ans.add(step);
            return;
        }
        for (int i = index; i < length; i++)
            if (storeValidPalindrome[index][i] != null) {//Do dfs for valid palandromes only
                List<String> tempList = new ArrayList<>(step);
                tempList.add(storeValidPalindrome[index][i]);
                dfs(storeValidPalindrome, ans, tempList, i + 1);
            }
    }

    private  boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }
    private static void print(){
        int n=3;
        int A[] = {1,4,5};
        int B[] = {5,4,1};
        int solve = solve(n, A, B);
        System.out.println(solve);
    }

    private static int  solve(int n, int[] A, int[] B) {
        long x=0;
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i ; j++) {
                long y = (long) A[j] * i + (long) B[j] * (n - i);
                x=x+ y;
                ans=Math.max(ans,(int)(x%10e9+7));
            }
        }
        return ans;
    }
    static void printNumbers(int n){
        if(n==0) return;
        System.out.println("Descing order "+n);
        printNumbers(n-1);
        System.out.println("Acending order "+n);
    }
}