import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer>array = createRandomArray(0);  
         System.out.println((array));
         double start = (double) System.currentTimeMillis() / 1000;
         bubbleSort(array);
         double timeSpent = (double) System.currentTimeMillis() / 1000 -start; 
         System.out.println( "Time spent bubblesort " + timeSpent + "s");
         System.out.println((array));

         double mergestart = (double) System.currentTimeMillis() /1000;
         mergeSort(array);
         double timemerge = (double) System.currentTimeMillis() / 1000 -mergestart; 
         System.out.println ( "Time spent mergesort " + timemerge + "s");
         System.out.println((array));
    }   

    public static void mergeSort(ArrayList<Integer> array){
      mergeSort(array, 0, array.size());
    }

public static void mergeSort(ArrayList<Integer> array, int start, int end){
    if(end - start <= 1) return;
    int middle = (start + end) / 2;
    mergeSort(array, start, middle);
    mergeSort(array, middle, end);
    merge(array, start, middle, end);
}
public static void merge(ArrayList<Integer>array, int start, int middle, int end){
    int i = start, j =middle;
    ArrayList<Integer> mergedArray = new ArrayList<Integer> (end- start);
    while (i < middle && j <end){
        if (array.get(i) <= array.get(j)){
            mergedArray.add(array.get(i));
            i++;
        } else{ 
            mergedArray.add(array.get(j));
            j++;
            }
        }
    while (i< middle){
        mergedArray.add(array.get(i));
        j++;
    }
    while (j < end) {
        mergedArray.add(array.get(j));
        j++;
    }
    for (i = start; i<end; i++){
        array.set(i, mergedArray.get(i-start));
    }
    }
    
    public static ArrayList<Integer> createRandomArray(int size){
        System.out.println("Please enter how many elements you would like in the array!");
        Scanner louis= new Scanner(System.in); 
        int q;
        q =louis.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer> (q);
        louis.close();

        int miau;
        Random random = new Random(0);  
         for(miau = 0; miau< q; miau++){
          array.add(random.nextInt(1000000));
    }
         return array;
}

    public static void bubbleSort(ArrayList<Integer> array){
        bubbleSort(array, 0, array.size());
}

    public static void woof(ArrayList<Integer> array, int i, int k){
        int meow= array.get(i);
        array.set(i, array.get(k));
        array.set(k, meow);
}

    public static void bubbleSort(ArrayList<Integer> array, int start, int end){
        if (end - start <= 1)
        return;
        for (int i = start; i < end -1; i++){
        if (array.get(i)> array.get(i+1)){
        woof(array, i, i+1);

    }
  }
        bubbleSort(array, start, end -1);
 }

}


