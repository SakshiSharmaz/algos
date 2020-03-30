package algos;

/**
 * Max Heapify takes log n times, total heap sort takes n log n time as
 * max heapify is called n times.
 */

import java.util.Scanner;

public class HeapSortOptimized {

    int[] array;
    int N;



    public HeapSortOptimized(int[] array) {
        this.array = array;
        N = array.length-1;
    }

    int[] sort(){
        maxHeapify();
        while (N != 0) {
            int temp = array[0];
            array[0] = array[N];
            array[N--] = temp;
            maxHeapify();
        }
        return array;

    }

    private void maxHeapify(){
        for(int i = (N-1) /2 ; i>=0; i--){
            maxHeapify(i);
        }

    }

    private void maxHeapify(int n) {
        if(n>array.length/2 -1) return;
        int largest = n;
        int left = 2*n+1, right = left+1;
        if(left<=N &&  array[largest]<array[left])
            largest = left;
        if( right<= N &&  array[largest]<array[right])
            largest = right;

        if(largest != n){
            int temp = array[largest];
            array[largest] = array [n];
            array[n] = temp;
            maxHeapify(largest);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }

        HeapSortOptimized heapSort =new  HeapSortOptimized(array1);
        System.out.println(printArray(heapSort.sort()));

    }

    private static String printArray(int[] a) {

        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(",");

        }
    }


}
