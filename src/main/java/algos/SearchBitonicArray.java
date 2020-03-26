package algos;

public class SearchBitonicArray {

    BinarySearch binarySearch = new BinarySearch();

    int search(int[] arr, int key) {
        //Step 1: search for peak point in bitonic array
        int peakPoint = peakPoint(arr);
        if (peakPoint == -1)
            throw new IllegalStateException("Array is not Bitonic");
        System.out.println("peak point : " +  peakPoint);

        //Step 2: do binary search on the part that will have the element.
        if (arr[peakPoint] == key) return peakPoint;
        int index = binarySearch.binarySearchAscending(arr, 0, peakPoint - 1, key);
        if (index == -1)
            index = binarySearch.binarySearchDescending(arr, peakPoint + 1, arr.length - 1, key);
        return index;
    }

    int peakPoint(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (mid > 0 && mid < arr.length - 2) {
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid + 1]) peakPoint(arr, arr[mid + 1], hi);
            else if (arr[mid] < arr[mid - 1]) peakPoint(arr, lo, arr[mid - 1]);
        }
        return -1;
    }

    int peakPoint(int[] arr) {
        return peakPoint(arr, 0, arr.length - 1);
    }
}
