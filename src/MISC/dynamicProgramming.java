package MISC;

import com.sun.javafx.collections.MappingChange;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamicProgramming {

    static Map<Integer,Integer> subInstancesMap = new HashMap<>();

    public static void main(String[] args) {
        //System.out.println(fib_A(3));
        for(Map.Entry<Integer,Integer> entry:subInstancesMap.entrySet() ){
            int sequence = entry.getKey();
            int value = entry.getValue();
            // Show fibonacci sequence/computed value (key/pair) set.
            System.out.println("Fibonacci sequence at " + sequence +" has computed value: " + value);
        }
        //System.out.println(fib_B(7));

        // Collatz generator call
        System.out.println(collatzGeneratorCall(13));


    }


    // Recursive Fibonacci calculator
    public static int Fib(int n) {
        if (n <= 1) {
            return n; // Base cases: (i) Fib(0) == 0 && (ii) Fib(1) == 1. If (i) not mentioned then stackoverflow occurs!
        }

        {
            return Fib(n - 1) + Fib(n - 2);
        }
    }

    public static int fib_A(int n) {
        return fib_Memo(n,new int[n+1]); // Send new int array initialized with 0.
    }

    public static int fib_Memo(int n, int [] memo) {

        if (n <= 1) {
            return n;
        }
        int computed_SubFibInstances = memo[n]; // Set sub instance array element
        // if instances not computed yet, then set to computation expression
        if(computed_SubFibInstances ==0) {
            computed_SubFibInstances = fib_Memo(n-2,memo) + fib_Memo(n-1,memo);
            memo[n] = computed_SubFibInstances ; // set sub instance array element to new value
            subInstancesMap.put(n,computed_SubFibInstances);
        }                                        /* Note: computed_SubFibInstances = memo[n] ! yields wrong result !!
                                                    since memo[n] ==0 ! */


        return computed_SubFibInstances;
    }

    // Bottom-up variation of a fibonacci sequence

    public static int fib_B(int n){
        return fib_UsingLoop(n,new int[n+1]);
    }

    public static int fib_UsingLoop(int n, int [] array){
        if(n<=1){
            return n;
        }
        int array_val = array[n];
        if(array_val==0){
            for(int i=0;i<=n;i++){ // Note: Figure out why using array.length gives invalid result
                array_val = fib_UsingLoop(i-1,array) + fib_UsingLoop(i-2,array);
                array[n] = array_val;
            }

        }
        return array_val;
    }

    // Coding challenge: Collatz sequence

    public static int collatzGeneratorCall(int n){
       return collatzGenerator(n,  new ArrayList<>());

    }

    public static int collatzGenerator(int n,List<Integer> arrayList){

        // Initialize the array
        for(int i=0;i<n;i++){
            arrayList.add(i,0);
            return arrayList.size();

        }

        for(int i=0;i<n;i++){
            int array_val=arrayList.get(n-1);

            if(array_val==0){

                if(n<=1){ // Base case of recursion
                    arrayList.add(i,n);
                    return n;
                }

                else if(n%2 ==0){
                    array_val = collatzGenerator(n/2,arrayList);
                    arrayList.add(i,array_val);
                    return array_val;

                }
                else if (!(n%2==0)){
                    array_val = collatzGenerator((3*n)+1,arrayList);
                    arrayList.add(i,array_val);
                    return array_val;
                }


            }

           // return array_val;
        }

    return  arrayList.size();
    }



}

/*
import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
      List<String> arraylist = new ArrayList<>();
      arraylist.add("ABC");
      arraylist.add("BDBA");
      System.out.println(printArray(arraylist));

    }

    public static String printArray(List<String> arraylist){
      String each_string="";
      for (int i=0;i<arraylist.size();i++){
        each_string = arraylist.get(i);
        }
        return each_string;
      }
}
 */

/*
Initialising an Arraylist
  public static List<Integer> arrayM(List<Integer> somelist, int n) {

    for(int i=0;i<n;i++){
      somelist.add(i,0);
      }
      return somelist;
    }
 */