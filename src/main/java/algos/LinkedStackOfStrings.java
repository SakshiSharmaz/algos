package algos;

public class LinkedStackOfStrings {

    Node first = null;
    private class Node{
        String item;
        Node next;
    }
    boolean isEmpty(){
        return first == null;
    }

    void push(String item ){

        first = new Node();
        first.item = item;
        first.next = first;

    }

    String pop(){
        String item = first.item;
        first = first.next;
        return item;
    }
}
