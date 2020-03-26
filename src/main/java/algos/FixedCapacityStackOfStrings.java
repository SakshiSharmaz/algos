package algos;

public class FixedCapacityStackOfStrings {

    int[] stack;
    int N;

    public FixedCapacityStackOfStrings(int capacity) {
        stack = new int[capacity];
    }

    boolean isEmpty(){
        return N == 0;
    }

    void push(int item ){

        stack[N++] = item;

    }

    int pop(){
        int item = stack[--N];
        return  item;

    }
}
