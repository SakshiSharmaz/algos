package algos;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    int[] array;

    public InsertionSort(int[] array) {
        this.array = array;
    }

    int[] sort(){

        int n = array.length;
        int i =1, j ;
        while(i<n){
            j = i;
            while(j>0){
                if(array[j-1]> array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;

                }else
                    break;

            }
            i++;
            for(int p = 0; p< array.length;p++) System.out.print(array[p] + " ");
            System.out.println();
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
        InsertionSort insertionSort = new InsertionSort(array1);
        insertionSort.sort();

    }


}
