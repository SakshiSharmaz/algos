package algos;

import java.util.Scanner;

public class Sort2Distinct {

    int[] array;


    public Sort2Distinct(int[] array) {
        this.array = array;
    }

    int[] sort(){
        int lt = 0 ;
        int i = 1, j = array.length-1;

        while(true) {

            while (array[i] < array[lt]) {
                if (i == array.length - 1) break;
                i++;
            }

            while (array[j] >= array[lt]) {
                if (j == 0) break;
                j--;
            }

            if (i >= j) break;

            int temp = array[i];
            array[i++] = array[j];
            array[j--] = temp;

        }

            int temp = array[j];
            array[j] = array[lt];
            array[lt] = temp;

            return  array;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i<n;i++){
            array1[i] = scanner.nextInt();
        }
        Sort2Distinct sort2Distinct = new Sort2Distinct(array1);
        int[] array =  sort2Distinct.sort();

        for (int i : array) System.out.print(i + " ");


    }


}
