package algos;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Shuffling {

    int array[];

    public Shuffling(int[] array) {
        this.array = array;
    }

    int[] shuffle() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            int rand = random.nextInt(i + 1);
            int temp = array[rand];
            array[rand] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
       int[] array = {1,2,3,4,5,6,7,8,9};
       Shuffling shuffle = new Shuffling(array);
        System.out.println(Arrays.toString(shuffle.shuffle()));
    }


}
