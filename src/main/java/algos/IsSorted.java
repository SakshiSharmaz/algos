package algos;

public class IsSorted {


      static public boolean isSortedArray(int[] array){

         for(int i = 0;i<array.length-1;i++){

             if( !(array[i]<array[i+1])) {
                 System.out.println(array[i]);
                 System.out.println(array[i+1]);
                 System.out.println(i + " " + (i +1) );
                 return false;
             }

         }
         return true;

     }

}
