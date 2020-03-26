package algos;

import java.util.Arrays;

// Maintaining the size of tree
public class QuickUnionUFV1 {
    private int[] id;
    private int[] size;
    //initialization through constructor
    public QuickUnionUFV1(int N) {
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
        while(id[i] != i )
            i = id[i];
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
}
