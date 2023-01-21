package com.epam;

import java.util.*;

public class PrimsLazyAlgo {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;
    private PriorityQueue<Edge> edgePriorityQueue;
    private Set<Vertex> unvistedEdges;
    private double fullWeight;


    public PrimsLazyAlgo(List<Edge> edgeList, List<Vertex> vertex) {
        this.edgeList = edgeList;
        this.vertexList = vertex;
        this.edgePriorityQueue = new PriorityQueue<>();
        this.unvistedEdges = new HashSet<>(vertexList);
    }
    public PrimsLazyAlgo(){}



    public void solve(Vertex vertex) {
        unvistedEdges.remove(vertex);
        while (!unvistedEdges.isEmpty()) {

            for (Edge edge : vertex.getAdjacentEdges()) {
                if (unvistedEdges.contains(edge.getTargetVertex())) {
                    edgePriorityQueue.add(edge);
                }
            }
            Edge minEdge = edgePriorityQueue.remove();

            if (!unvistedEdges.contains(minEdge.getTargetVertex())) continue;
            edgeList.add(minEdge);
            fullWeight += minEdge.getWeight();
            vertex = minEdge.getTargetVertex();
            unvistedEdges.remove(vertex);
        }
    }

    public void show() {
        System.out.println(fullWeight);
        for (Edge edge : edgeList) {
            System.out.println(edge.getSourceVertex() + " " + edge.getTargetVertex());
        }
    }

    public static void main(String[] args) {

        String source1 = "paypalishiring";
        int row = 3, i = 0, t = row, step = 1;
        String[] list = new String[row];
        Arrays.fill(list, "");
        for (int j = 0; j < source1.length(); j++) {
            list[i] += source1.charAt(j);
            if (i == 0) step = 1;
            else if (i == row - 1) step = -1;
            i += step;
        }
        var set=new HashSet<Integer>();
        var Ab = new int[]{1, 2, 4, 5, 5, 4, 7};
        for(int ab:Ab){
            set.add(ab);
        }
        int sum = Arrays.stream(Ab).distinct().sum();
        System.out.println(sum);
        StringBuilder answer = new StringBuilder();
        float a=1.33645f;
        float b = 2.34534f;
        System.out.println("Float  = "+a*b);
        double c=a;
        double d=b;
        System.out.println("Double = "+c*d);
        for (var ad : list) {
            answer.append(ad);
        }
//        System.out.println(answer);

//        while (t > 0) {
//            t--;
//            StringBuilder deo = new StringBuilder();
//            int j = i;
//            for (; j < source1.length(); j += (2 * row - 2))
//                deo.append(source1.charAt(j));
//            Ad[i++] = deo.toString();
//        }
//        StringBuilder ans = new StringBuilder();
//        for (String s : Ad) {
//            ans.append(s);
//        }
//        System.out.println(ans);

//        System.out.println(Optional.of(source).orElse("n"));
//        Vertex v = new Vertex();
//        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
//        integerList.stream().filter(i->i%2==0).map(i->{
//            i=i*i;
//            v.setPredecessor(new Vertex());
//            return v;
//        }).forEach(System.out::println);
//        System.out.println("Quote Cost CAD BUF UAT data set up 2022-12-14.csv".length());
//        int i=0;
//        inner: while(i<5){
//
//            System.out.println(i++);
//            outer: switch (i) {
//                case 1:
//                    PrimsLazyAlgo algo = new PrimsLazyAlgo(new ArrayList<Edge>(), new ArrayList<Vertex>());
//                    algo.solve(v);
//                    break outer;
//                case 2:
//                    i+=3;
//                    break inner;
//
//                case 3:
//                    i+=9;
//
//
//            }
//        }
//        var A = new int[]{1, -2, -3, 3, -4, 87, 9};
//        var b = new int[5];
//        var k = 3;
//        for (int j = 0; j <= A.length - k; j++) {
//            for (int l = j; l < j + k; l++) {
//                if (A[l] < 0) {
//                    b[j] = (A[l]);
//                    break;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(b));
//        System.out.println(maxSubArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 3));

    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int[] counts = new int[n];
        Arrays.sort(edges, (a, b) -> (a[1] == b[0]) ? -1 : (a[0] == b[1]) ? 1 : 0);
        for (int edgePos = edges.length - 1; edgePos >= 0; --edgePos) { // walk backwards
            int[] edge = edges[edgePos];
            if (hasApple.get(edge[1]) || counts[edge[1]] > 0)  // forward and back + from previous node
                counts[edge[0]] += 2 + counts[edge[1]];
            else if (hasApple.get(edge[0]) || counts[edge[0]] > 0)  // forward and back + from previous node
                counts[edge[1]] += 2 + counts[edge[0]];
        }
        return counts[0];
    }


    public static int maxSubArray(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < a.length; i++) {
            cur += a[i];//add current element
            if (i >= (k - 1)) {
                max = Math.max(max, cur);
                cur -= a[i - (k - 1)];//remove previous element
            }

        }
        return max;
    }
}

class  Demmy{
    public static void main(String[] args) {
        String a= "abcd",b="bcad";
        int ans=1;
        for (int i = 0; i < a.length(); i++) {
            char charAt = a.charAt(i);
            int j= b.indexOf(""+charAt);
            if((i+j)%2!=0){
                ans=2;
                break;
            }
        }
        System.out.println(ans);
    }
}