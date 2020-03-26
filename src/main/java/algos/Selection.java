package algos;

import java.nio.channels.Selector;
import java.util.Scanner;

/**
 * Selection of kth element using quick sort
 */

public class Selection {

    int[] array;
    int k;

    public Selection(int[] array, int k ) {
        this.array = array;
        this.k = k;
    }

//    int select(){
//
//     return  select(0,array.length);
//
//    }

//    private int select(int lo, int hi) {
//        int partition = partition(0, array.length-1);
//        if(partition == k) return array[k];
//        else if(k>partition) return select(partition+1,hi );
//        else return select(lo, partition-1);
//    }
    int partition(){
        return partition(0, array.length-1);
    }

    private int partition(int lo, int hi) {
        int i = lo, j = hi+1;

        while(true){

            while (array[++i]<array[lo]){
                if(i==hi) break;
            }

            while(array[--j]>array[lo]){
                if(j==lo) break;
            }
            if(i>=j) break;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }

        int temp = array[lo];
        array[lo] =array[j];
        array[j] = temp;

        if(j == k-1 ) return array[j];
        else if(k-1>j) return partition(j+1,hi );
        else return partition(lo,j-1 );

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for(int i = 0; i<n;i++){
            array1[i] = scanner.nextInt();
        }
        Selection selection = new Selection(array1,1);
        int array =  selection.partition();
        System.out.println(array);
//        for(int p = 0;p<array.length; p++) System.out.print(array[p] + " ");
    }


}
