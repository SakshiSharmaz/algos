package algos;

import java.util.Scanner;

public class QuickSort {

    int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public int[] sort(){
        sort(0,array.length-1);
         return array;
    }

    private void sort(int lo, int hi) {

        if(lo>=hi) return;
        int partition = partition(lo,hi);
        sort(lo,partition-1);
        sort(partition+1,hi);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i<n;i++){
            array1[i] = scanner.nextInt();
        }
        QuickSort quickSort = new QuickSort(array1);
        int[] array =  quickSort.sortLastPivot();
        for(int p = 0;p<array.length; p++) System.out.print(array[p] + " ");
    }

    int partition(int lo,int hi){
        int i = lo, j = hi+1;

        while(true){

            while (array[++i]<array[lo]){
                    if(i==hi) break;
            }

            while(array[--j]>array[lo]){
                if(j==lo) break;
            }
            if(i>=j) break;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }

        int temp = array[lo];
        array[lo] =array[j];
        array[j] = temp;

        return j;
    }


    // Sort using last element as pivot

    int[] sortLastPivot(){

        sortLastPivot(0,array.length-1);
        return  array;
    }

    private void sortLastPivot(int lo, int hi) {

        if(lo>=hi) return;

        int partition = partitionLastPivot(lo,hi);
//        for(int p = 0;p<array.length; p++) System.out.print(array[p] + " ");
//        System.out.println();
        if(partition-1 != lo)
        sortLastPivot(lo,partition-1);
        if(partition+1 != hi)
        sortLastPivot(partition+1, hi);


    }

    private int partitionLastPivot(int lo, int hi) {
        int i = lo-1, j = hi, pivot = hi;
        while (true){

            while (array[++i]<array[pivot])
                if(i == hi) break;

            while (array[--j]>array[pivot])
                if(j == lo) break;

                if(i>=j) break;


                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;

        }

        int temp = array[hi];
        array[hi] = array[i];
        array[i] = temp;

        return i;

    }


}

