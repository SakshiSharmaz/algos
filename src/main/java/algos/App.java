package algos;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        //  BinarySearch binarySearch = new BinarySearch();
        int[] arr = {-3, 9, 11, 20, 17, 5, 1, 0};
        int[] arr1 = {-3, -2, -1, 0, 1, -1, -2, -3};
        int[] arr2 = {50, 23, 95, 86, 2, 101, 90, 5};

        /**
         * Testing binary search
         */
//        System.out.println(binarySearch.binarySearchAscending(arr, 1 ));

        /**
         * Testing Three sum problem
         */
//        ThreeSumProblem threeSumProblem = new ThreeSumProblem();
//        threeSumProblem.threeSum(arr);

        /**
         * Testing search in bitonic array
         */
//        SearchBitonicArray searchBitonicArray = new SearchBitonicArray();
//        System.out.println(searchBitonicArray.search(arr1,1));

        /**
         * Testing resizing array implementation of stack
         */

        /**
         Scanner scanner = new Scanner(System.in);
         ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
         boolean flag = true;
         while (flag) {
         System.out.println("select 1 for push , 2 for pop, 3 for exit ");
         int choice = scanner.nextInt();
         if (choice == 1) {
         System.out.println("Enter item to be pushed");
         String item = scanner.next();
         stack.push(item);
         }else if (choice == 2) {
         System.out.println(stack.pop());
         }
         else {
         break;
         }
         }
         */

        /**
         * Testing linked list implementation of queue.
         */
/*
        Scanner scanner = new Scanner(System.in);
        QueueOfStrings queue = new QueueOfStrings();
        boolean flag = true;
        while (flag) {
            System.out.println("select 1 for enqueue , 2 for dequeue, 3 for exit ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter item to be pushed");
                String item = scanner.next();
                queue.enqueue(item);
            }else if (choice == 2) {
                System.out.println(queue.deque());
            }
            else {
                break;
            }
        }

*/

        /**
         * Testing Merge sort
         */

        /**
         MergeSort mergeSort = new MergeSort(arr1);
         System.out.println(Arrays.toString(mergeSort.sort()));
         */

        /**
         * Testing Shell  sort
         */

//        ShellSort shellSort = new ShellSort(arr);
//        System.out.println(Arrays.toString(shellSort.sort()));


        /**
         * Testing Merge of two sorted Arrays
         */

//        int[] midSortedArray = {-8,-5,-5,0,2,-9,-9,-3,3,15};
//        Merge merge = new Merge(midSortedArray);
//        System.out.println(Arrays.toString(merge.merge()));


        /**
         * Testing Inversion Control
         */
        int[] array = {1,1,1,2,2};
//        int[] largeArray ;
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\Sakshi\\Desktop\\manyNumbers")));
//        int n = Integer.parseInt(bufferedReader.readLine());
//        largeArray = new int[n];
//        String[] arrItems = bufferedReader.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            largeArray[i] = arrItem;
//        }
//        InversionCount count = new InversionCount();
//        System.out.println(count.count(array));
////        System.out.println(Arrays.toString(InversionCount.sort()));

        /**
         * Testing Insertion sort
         */


//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] array1 = new int[n];
//        for(int i = 0; i<n;i++){
//            array1[i] = scanner.nextInt();
//        }
//        InsertionSort insertionSort = new InsertionSort(array1);
//        array1 = insertionSort.sort();
//        for(int p = 0; p< array.length;p++) System.out.print(array1[p] + " ");
    }
}
