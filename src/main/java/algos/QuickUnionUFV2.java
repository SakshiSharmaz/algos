package algos;

import java.util.Arrays;

//Weighted Quick Union
public class QuickUnionUFV2 {
    private int[] id;
    private int[] size;
    //initialization through constructor
    public QuickUnionUFV2(int N) {
        id = new int[N];
        size = new int[N];
        Arrays.fill(size, 1);
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = i;
        }
    }

    int root(int n){
        int i = n;
        while(id[i] != i ) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return  i;
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    void union(int p , int q ){
        int proot = root(p);
        int qroot = root(q);
        if(proot == qroot) return;
        if(size[proot] > size[qroot]);
        else {
            id[proot] = qroot;
            size[qroot] += size[proot];
        }

    }

    // Practice Quiz 0 -> question 2
    int find(int n){
        int root = root(n);
        int maxElement = n ;
        for(int i = 0 ;i<id.length; i++){
             if(root(i) == root)
                 if(maxElement< i )
                     maxElement = i;
        }
        return maxElement;
    }
}
