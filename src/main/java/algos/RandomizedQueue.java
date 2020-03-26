package algos;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

     public  Item[] items ;
    private int currentSize;


    // construct an empty randomized queue
    public RandomizedQueue(){

        items = (Item[]) new Object[1];
        currentSize = 0;

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
            return currentSize == 0 ;
    }

    // return the number of tempItems on the randomized queue
    public int size(){
        return currentSize;
    }

    // add the item
    public void enqueue(Item item){

        if(item == null)
             throw new  IllegalArgumentException("item cannot be null");

        if(currentSize == items.length){
            Item[] tempArray = (Item[]) new Object[items.length *2];
            for(int i = 0;i< items.length;i++)
                tempArray[i] = items[i];
            items = tempArray;
        }

        items[currentSize++] = item;

    }

    // remove and return a random item
    public Item dequeue(){
        if(currentSize == 0 )
            throw new NoSuchElementException("Queue is empty");

        if(currentSize == items.length/4){
            Item[] tempArray = (Item[]) new Object[items.length /2];
            for(int i = 0;i< currentSize ;i++)
                tempArray[i] = items[i];
            items = tempArray;
        }

        int randomIndex = StdRandom.uniform(currentSize);
        System.out.println(randomIndex);
        Item item =  items[randomIndex];

        if(randomIndex == currentSize -1 )
            items[currentSize-1 ] =  null;
          else {
            items[randomIndex] = items[currentSize - 1];
            items[currentSize-1] = null;
        }
          currentSize--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample(){
        return items[StdRandom.uniform(currentSize)];
    }

    // return an independent iterator over tempItems in random order
    public Iterator<Item> iterator(){
        return new CustomQueueIterator();

    }

    // unit testing (required)
    public static void main(String[] args){

        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        for (String item : randomizedQueue){
            System.out.println(item);
        }
        randomizedQueue.enqueue("Apple");
        randomizedQueue.enqueue("Mango");
        randomizedQueue.enqueue("Banana");
        randomizedQueue.enqueue("Orange");
        randomizedQueue.enqueue("Grapes");

        System.out.println( "IsEmpty " + randomizedQueue.isEmpty());
        System.out.println("Size: " +  randomizedQueue.size());
        System.out.println("DeQueing elements");
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        System.out.println(randomizedQueue.dequeue());
        randomizedQueue.enqueue("Weird Apple");
        randomizedQueue.enqueue("Weird Mango");
        randomizedQueue.enqueue("Weird Banana");
        randomizedQueue.enqueue("Weird Orange");
        randomizedQueue.enqueue("Weird Grapes");
        System.out.println("Getting a sample value out: " + randomizedQueue.sample());

        System.out.println("is empty: " + randomizedQueue.isEmpty());
        System.out.println("size " + randomizedQueue.size());

        for (String item : randomizedQueue){
            System.out.println(item);
        }


    }

   private  class CustomQueueIterator implements Iterator<Item>{


        private Item[] tempItems;
        private int elementsRemaining;

        CustomQueueIterator() {
            this.tempItems = items;
            elementsRemaining = currentSize;
        }

        @Override
        public boolean hasNext() {
            return elementsRemaining != 0;
        }

        @Override
        public Item next() {
            if(elementsRemaining == 0 )
                throw new NoSuchElementException("No more elements in queue");

            int randomIndex = StdRandom.uniform(elementsRemaining);
            Item item =  tempItems[randomIndex];
            if(randomIndex == elementsRemaining -1 )
                tempItems[elementsRemaining-1 ] =  null;
            else {
                tempItems[randomIndex] = tempItems[elementsRemaining - 1];
                tempItems[elementsRemaining-1] = null;
            }
            elementsRemaining--;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("this operation is not supported");
        }
    }
}
