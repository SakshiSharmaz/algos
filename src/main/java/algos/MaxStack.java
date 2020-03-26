package algos;


//Question 2 Practice Quiz Stack and queue.
public class MaxStack {

    private int size;
    private int[] stack;
    private int maxElement;


    public MaxStack() {
        stack = new int[1];
        size = 0;
    }


    void push(int num) {

        if (size == 0) maxElement = num;
        else if (num > maxElement) maxElement = num;

        stack[size++] = num;
        if (size == stack.length) {
            int[] tempStack = new int[size * 2];
            for (int i = 0; i < size; i++)
                tempStack[i] = stack[i];
            stack = tempStack;
        }
    }

    int pop() {

        int poppingElement = stack[size--];
        if (size <= stack.length / 4) {
            int[] tempStack = new int[stack.length / 2];
            for (int i = 0; i < size; i++)
                tempStack[i] = stack[i];
            stack = tempStack;
        }
        return poppingElement;
    }
}
