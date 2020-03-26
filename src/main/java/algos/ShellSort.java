package algos;

/**Best Case Complexity: O(n*log n)
 * Worse Case Complexity: O(n^2)
 * Shell with Selection sort
 */
public class ShellSort {

    private int[] array;

    public ShellSort(int[] array) {
        this.array = array;
    }

    public int[] sort(){

        int n = 2;
        while(array.length/n > 0){
            int gap = array.length/n;
            for(int i = 0;i<(array.length-gap);i++){
                if(array[i]> array[i+gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                }
            }
            n*=2;
        }
            return array;
    }

}
