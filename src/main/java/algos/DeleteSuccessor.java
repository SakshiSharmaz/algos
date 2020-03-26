package algos;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
// Question 3 in Problem Quiz 1-> question 3
public class DeleteSuccessor {

    // 1 specifies element exists else if its 0 then element has been deleted
    private int[] id;

    //initialization through constructor
    public DeleteSuccessor(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = 1;
        }
    }

    void remove(int p){
        id[p] = 0; // setting value to 0 to specify element has been deleted
    }

    int successor(int p ){
        if(p >= id.length) return 0 ;
        if(id[p] == 1 ) return p;
        else return successor(p+1);
    }
}
