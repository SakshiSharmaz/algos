package algos;

import java.util.Scanner;

public class ShellInsertionSort {

    int[] array;


    public ShellInsertionSort(int[] array) {
        this.array = array;
    }

    void subSort(int k ) {
        int i = k, j;
        while (i < array.length) {
            j = i;
            for (; j-k >= 0 ; j= j -k) {
                if ( array[j - k] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - k];
                    array[j - k] = temp;
                } else break;
            }
            i++;
        }
    }
    int[] sort(){

        int i = (array.length -1) /3;
        while( 3*i+1 > 0){
            subSort(3*i+1);
            i--;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i<n;i++){
            array1[i] = scanner.nextInt();
        }
        ShellInsertionSort insertionSort = new ShellInsertionSort(array1);
        array1 = insertionSort.sort();
        for(int p = 0; p< array1.length;p++) System.out.print(array1[p] + " ");

    }
}
