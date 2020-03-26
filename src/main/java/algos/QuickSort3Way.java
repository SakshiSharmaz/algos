package algos;

import java.util.Scanner;

public class QuickSort3Way {

    private int[] array;

    public QuickSort3Way(int[] array) {
        this.array = array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }
        QuickSort3Way quickSort = new QuickSort3Way(array1);
        int[] array = quickSort.sort3Way();
        for (int p = 0; p < array.length; p++) System.out.print(array[p] + " ");
    }


    public int[] sort3Way() {
        sort3Way(0, array.length - 1);
        return array;
    }

    private void sort3Way(int lo, int hi) {
            if(lo>=hi) return;
        int[] partitions = partition3Way(lo, hi);
        if(partitions[0] !=0)
        sort3Way(lo, partitions[0] - 1);
        if(partitions[1] != hi)
        sort3Way(partitions[1] + 1, hi);

    }

    private int[] partition3Way(int lo, int hi) {

        int lt = lo, i = lo + 1, j = hi;


            while (i <= j && i<=hi && j>=lt) {
                if (array[i] < array[lo]) {
                    int temp = array[lo];
                    array[lo++] = array[i];
                    array[i++] = temp;
                } else if (array[i] == array[lo])
                    i++;
                else{
                        int temp = array[i];
                        array[i] = array[j];
                        array[j--]= temp;
                }

            }
        return new int[]{lo, j};
    }


}
