package algos;

import java.util.Arrays;

public class ThreeSumProblem {
    private BinarySearch binarySearch = new BinarySearch();

    public void threeSum(int[] arr) {
        Arrays.sort(arr);
        boolean hasDuplicate = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                hasDuplicate = true;
        }
        if (hasDuplicate) throw new IllegalArgumentException("array contains duplicate elements");
        else {
            for (int i = 0; i < arr.length; i++)
                for (int j = i + 1; j < arr.length; j++) {
                    int k = binarySearch.binarySearchAscending(arr,-(arr[i] + arr[j]));
                    if(k>j) {
                        System.out.println(i + " : " + j + " : " + k);
                    }
                }
        }
    }
}
