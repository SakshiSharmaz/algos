package algos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {


    private Node first,last;
    private int size;

    class Node{

        Item item ;
        Node next;
        Node previous;

    }


    // construct an empty deque
    public Deque(){

        size = 0;

    }

    // is the deque empty?
    public boolean isEmpty(){

       return first == null;
    }

    // return the number of items on the deque
    public int size(){
       return size;
    }

    // add the item to the front
    public void addFirst(Item item){

        if(item == null)
            throw new IllegalArgumentException("Illegal arguments");


        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
        if(size == 0)
            last = first;
            size++;

    }

    // add the item to the back
    public void addLast(Item item){

        if(item == null)
            throw new IllegalArgumentException("Illegal arguments");
        Node node = new Node();
        node.item = item;
        last.next = node;
        node.previous = last;
        last = node;
        if(size ==0 )
            first = last;
        size++;

    }

    // remove and return the item from the front
    public Item removeFirst(){

        if(size == 0 )
            throw new NoSuchElementException("Empty Queue");

        Item item = first.item;
        first = first.next;
        first.previous = null;
        size--;
        return item;

    }

    // remove and return the item from the back
    public Item removeLast(){

        Item item = last.item;
        last = last.previous;
        last.next = null;
        size--;
        return item;

    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){

        return new CustomIterator(first);
    }

    // unit testing (required)
    public static void main(String[] args){

        Deque<String> deque = new Deque<>();
        for (String item : deque){
            System.out.println(item);
        }
        deque.addFirst("Apple");
        deque.addLast("Mango");
        deque.addFirst("Banana");
        deque.addFirst("Orange");
        deque.addLast("Grapes");

        System.out.println( "IsEmpty " + deque.isEmpty());
        System.out.println("Iterating list");

        for (String item : deque){
            System.out.println(item);
        }
        System.out.println("Size" +  deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        System.out.println("is empty: " + deque.isEmpty());
        System.out.println("size " + deque.size());

    }


  private class CustomIterator implements Iterator<Item> {

        private Node currentNode;

        CustomIterator(Node node) {
            currentNode = node;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if(currentNode == null )
                throw new NoSuchElementException("Empty Queue");

            Item item = currentNode.item;
            currentNode = currentNode.next;
            return item ;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation not supported");
        }
    }
}

