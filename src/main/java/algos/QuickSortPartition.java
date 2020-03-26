package algos;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortPartition {

    int[] array;


    public QuickSortPartition(int[] array) {
        this.array = array;
    }

    int[] partition() {
        int lt = 0;
        int i = 1;
        int j = array.length - 1;

        while (i <= j) {

            while (i < array.length - 1) {
                if (array[i] < array[lt]) {
                    int temp = array[i];
                    array[i] = array[lt];
                    array[lt] = temp;
                    lt++;
                }
                else if(array[i] > array[lt])
                    break;
                i++;
            }

            while (j > lt) {

                if (array[j] < array[lt])
                    break;
                j--;

            }
            if(i<=j) {
                int temp = array[i];
                array[i++] = array[j];
                array[j--] = temp;
            }


        }
        int temp = array[lt];
        array[lt] = array[j];
        array[j] = temp;
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i<n;i++){
            array1[i] = scanner.nextInt();
        }
        QuickSortPartition quickSort = new QuickSortPartition(array1);
        int[] array = quickSort.partition();
        for (int i :array
             ) {
            System.out.print(i+ " ");
        }

    }


}
