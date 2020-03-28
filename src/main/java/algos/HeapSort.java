package algos;

import java.util.Arrays;
import java.util.Scanner;


public class HeapSort {
    int[] array;
    private int N;

    public HeapSort(int[] array) {
        this.array = array;
        N = array.length - 1;
        maxHeapify();
    }

    void sink(int n) {
        if (n >(N-1)/2) return;
        int largest = n;
        int left = n * 2 + 1, right = n * 2 + 2;
        if (left <= N && array[largest] < array[left])
            largest = left;
        if (right <= N && array[largest] < array[right])
            largest = right;

        if (largest != n) {
            int temp = array[n];
            array[n] = array[largest];
            array[largest] = temp;
            sink(largest);

        }
    }

    void swim(int n) {
        if (n == 0) return;
            int parent = (n-1) /2;
        if (array[n] > array[parent]) {
            int temp = array[n];
            array[n] = array[parent];
            array[parent] = temp;
            sink(n);
            swim(parent);
        }
    }

    private void maxHeapify() {
        int n = array.length - 1;
        while (n != 0) {
            swim(n--);
        }
    }


    int[] sort() {

        while (N != 0) {

            int temp = array[0];
            array[0] = array[N];
            array[N--] = temp;
            maxHeapify(N);
        }
        return array;
    }

    private void maxHeapify(int n) {
        while (n != 0) {
            swim(n--);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }
        HeapSort heapSort = new HeapSort(array1);
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
