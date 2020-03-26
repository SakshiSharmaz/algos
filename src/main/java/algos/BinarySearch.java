package algos;

public class BinarySearch {

    public int binarySearchAscending(int[] array , int key ){

      return  binarySearchAscending(array,0,array.length-1,key);

    }

    public int binarySearchAscending(int[] array , int low, int high , int key){
        int  mid = (low + high) / 2;
        if(low<=high) {
            if (array[mid] == key) return mid;
            else if (key > array[mid]) return binarySearchAscending(array, mid + 1, high, key);
            else if (key < array[mid]) return binarySearchAscending(array, low, mid - 1, key);
        }
        return  -1;
    }

    public int binarySearchDescending(int[] array , int low, int high , int key){
        int  mid = (low + high) / 2;
        if(low<=high) {
            if (array[mid] == key) return mid;
            else if (key < array[mid]) return binarySearchAscending(array, mid + 1, high, key);
            else if (key > array[mid]) return binarySearchAscending(array, low, mid - 1, key);
        }
        return  -1;
    }
}
