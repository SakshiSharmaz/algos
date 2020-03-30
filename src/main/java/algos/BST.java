package algos;

public class BST {

    private Node root;
    class Node{

        int key, size, value;
        Node left, right;

        public Node(int key, int size, int value) {
            this.key = key;
            this.size = size;
            this.value = value;
        }
    }

    public void put(int key, int value){
        root = put(root, key ,value );
    }

    private Node put(Node root, int key, int value) {
        if(root == null) return new Node(key,1, value);
        if(key>root.key) root.right = put(root.right,key, value);
        else if(key<root.key) root.left = put(root.left, key, value);
        else root.value = value;
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    int size(){

      return   size(root);
    }

    public int size(Node root){

        if(root == null) return 0;
        else return root.size;
    }

    Integer get(int key){
       return get(root, key);
    }

    private Integer get(Node root, int key) {
        if(root ==  null) return null;
        if(root.key == key) return root.value;
        else if(root.key> key)return get(root.right,key);
        else return get(root.left, key);
    }

    boolean contains(int key){

        return get(key) != null;

    }

    void delete(int key){

      root =  delete( root,key);

    }

    private Node delete(Node root, int key) {
        if(root == null) return null;
        if(root.key == key) root =  root.right;
        else if(root.key>key) root = delete(root.right,key);
        else root = delete(root.left,key);
        root.size = size(root.left) + size(root.right) -1;
        return root;
    }

    Integer floor(int key){
     return  floor(root,key);

    }

    private Integer floor(Node root, int key) {
        if(root == null) return null;
        if(root.key == key) return root.value;
        else if(root.key>key) return floor(root.left,key);
        else {
//            if(root.right.left == null ) return root.key;
       //     else {
                Integer value = floor(root.right, key);
                if(value == null) return root.key;
                else return value;
        //    }
        }
    }


    Integer ceiling(int key){

      return   ceiling(root,key);


    }

    private Integer ceiling(Node root, int key) {

        if(root == null) return  null;
        if(root.key == key) return root.value;
        else if(root.key > key ) return ceiling(root.left, key);
        else {
            if(root.right == null) return root.value;
            else {
                Integer value = ceiling(root.right,key);
                if(value == null) return root.key;
                else if(value> root.key) return root.key;
                else return value;

            }
        }

    }

    Integer rank(int key){

      return   rank( root,key);


    }

    private Integer rank(Node root, int key) {
        if(root == null) return 0;
        if(root.key == key) return root.left.size+1; // TODO Check if adding 1 here causes a bug
        else
        if(root.key<key) return rank(root.left,key);
        else {

            return root.left.size + 1 + rank(root.right,key);

        }
    }

        void inorderTraversal(){

        inorderTraversal(root);


        }

    private void inorderTraversal(Node root) {
        if(root == null) return;
        if(root.left!= null) inorderTraversal(root.left);
        System.out.println(root.key);
        if(root.right!=null) inorderTraversal(root.right);
    }

    public static void main(String[] args) {

        BST bst = new BST();
        bst.put(1,1);
        bst.put(9,9);
        bst.put(6,6);

        bst.put(-12,-12);
        bst.put(-16,-16);
        bst.put(-9,-9);

        bst.put(-8,-8);
        bst.put(-19,-19);
        bst.put(-6,-6);

        bst.inorderTraversal();

        System.out.println( "Rank: " + bst.rank(1));

        System.out.println( "Cieling: " + bst.ceiling(13));

        System.out.println("Floor: "+   bst.floor(-13));

        System.out.println("Contains element: " +  bst.contains(-13));

        System.out.println(  "Size of bst: " + bst.size());


    }
}
