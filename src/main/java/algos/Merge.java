package algos;

/**
 * this implementation of merge two sorted arrays and  uses half size of auxiallary array.
 */
public class Merge {

    private int[] array;

    private int[] tempArray;


    public Merge(int[] array) {
        this.array = array;
        tempArray = new int[array.length / 2];
        for (int i = 0; i < array.length / 2; i++) {
            tempArray[i] = array[i];
        }
    }

    int[] merge() {
        int lo = 0, hi = array.length - 1, mid = ((lo + hi) / 2) + 1;
        int k = 0;
        while (lo <= hi / 2 && mid <= hi) {
            if (array[mid] < tempArray[lo])
                array[k++] = array[mid++];
            else if (array[mid] > tempArray[lo])
                array[k++] = tempArray[lo++];
            else {
                array[k++] = array[mid++];
                array[k++] = tempArray[lo++];
            }
        }
        while (lo <= hi / 2)
            array[k++] = tempArray[lo++];

        while (mid <= hi)
            array[k++] = array[mid++];

        return array;

    }
}
