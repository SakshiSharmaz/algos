package algos;

public class QueueOfStrings {

    public QueueOfStrings() {
    }

    Node first;
    Node last;
    int N;

    class Node{
        String item ;
        Node next;

        public Node(String item) {
            this.item = item;
        }
    }
     void enqueue( String item ){
        Node newNode = new Node(item);
        if(N == 0) {
            first = newNode;
        }else {
            last.next = newNode;
        }
         last = newNode;
        N++;
        printQueue();
    }
    String deque(){
        if(N!=0) {
            String item = first.item;
            first = first.next;
            N--;
            printQueue();
            return item;
        }
        else throw new IllegalStateException("No items in queue");
    }
    int size(){
        return N;
    }

    boolean isEmpty(){
        return N==0;
    }

    public void printQueue(){

        if(first != null)
        printQueue(first);

    }
    public void printQueue(Node node){
        System.out.println(node.item);
        if(node.next != null)
             printQueue(node.next);

    }
}
