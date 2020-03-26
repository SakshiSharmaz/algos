package algos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ResizingArrayStackOfStrings {

    String[] stack;
    int N;

    public ResizingArrayStackOfStrings() {
        stack = new String[1];
        N = 0;
    }

    void push(String item) {
        resize();
        stack[N] = item;
        N++;
    }

    String pop() {
        if(N>0) {
            resize();
            System.out.println(N);
            String item = stack[N-1];
            stack[N-1] = null;
            N--;
            return item;
        }
        else throw new IllegalStateException("Empty stack");
    }

    void resize() {

        String[] newStack;
        if(N>0) {
            if (N == stack.length) {
                newStack = new String[stack.length * 2];
                System.arraycopy(stack, 0, newStack, 0, stack.length);
                stack = newStack;
            } else if (N == stack.length / 4) {
                newStack = new String[stack.length / 2];
                System.arraycopy(stack, 0, newStack, 0, N);
                stack = newStack;
            }
        }
    }

    void printStack(){
        System.out.println(Arrays.toString(stack));
    }
}
