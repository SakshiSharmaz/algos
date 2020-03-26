package algos;

public class MergeSort {

    private int[] array;
    private int[] temp;

    public MergeSort(int[] unsortedArray) {
        this.array = unsortedArray;
        temp = new int[unsortedArray.length];
    }

    public int[] sort() {

        sort(0, array.length - 1);
        return array;
    }

    public void sort(int lo, int hi) {

        if (lo < hi) {
            sort(lo, (lo + hi) / 2);
            sort((lo + hi) / 2 + 1, hi);
            merge(lo, (lo + hi) / 2, hi);
        }

    }

    public void merge(int lo, int mid, int hi) {
        if (lo >= hi) return;

        int i = lo, j = mid + 1, k = lo;

        while (i <= mid && j <= hi) {
            if (array[i] < array[j])
                temp[k++] = array[i++];
            else if (array[i] > array[j])
                temp[k++] = array[j++];
            else{
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
