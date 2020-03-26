package algos;

/**
 * An inversion in an array a[] is a pair of entries a[i] and a[j]
 * such that i < j but a[i] > a[j]. Given an array,
 * design a linearithmic algorithm to count the number of inversions.
 * WIP
 */

public class InversionCount {

    static private int[] array;
    static private int[] temp;
    static private long inversions;

    long count(int[] arr) {
        array = arr;
        inversions = 0;
        temp = new int[array.length];
        sort();
        return inversions;

    }

    public int[] sort() {
        sort(0, array.length - 1);
        return array;
    }

    public void sort(int lo, int hi) {
        int mid = lo + (hi-lo)/2;
        if (lo < hi) {
            sort(lo, mid);
            sort(mid+1, hi);
            merge(lo, mid, hi);
        }

    }

    public void merge(int lo, int mid, int hi) {
        if (lo >= hi) return;

        int i = lo, j = mid + 1, k = lo;

        while (i <= mid && j <= hi) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];

            } else if (array[i] > array[j]) {
                temp[k++] = array[j++];
                inversions+= (mid -i)+1;
            } else {
                if( i<mid && array[i+1] > array[i])
                    inversions+=(mid-i);
                temp[k++] = array[i++];
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= hi) {
            temp[k++] = array[j++];
        }

        for (int m = lo; m <= hi; m++) {

            array[m] = temp[m];

        }

    }

}
