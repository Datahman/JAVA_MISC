package MISC;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

public class string_Reversal {
    public static void main(String  args[]){

        System.out.printf("Actual String : %s with reversed string: %s","Hello",reverse("Hello"));

        // String reversal using the StringBuilder class
        StringBuilder input_String = new StringBuilder("Some string");
        String reversed_String = input_String.reverse().toString();
        System.out.println("\n"+reversed_String);

        // Check is StringPalindrome
        //System.out.printf("Palindrome string checking...: %s",isStringPalindrome("yak"));

        //System.out.println(counter);
        Character  dummyChar = new Character('a');

        // Note: Arrays.toString() used to describe the content of ANY array e.g Char[]
        //System.out.println(Arrays.toString(removeCharfromString("append",dummyChar)));
        // Now change new Char[] to a string !
        String str ="";
        for (Character c: removeCharfromString("aaappand",dummyChar)) {
            if(c != null){
            str += c.toString();
            }
        }
        System.out.println(str);

        // Ordered permutation problem

        /*char [] input = "ABC".toCharArray();
        stringPermutation(input);
        */

        String alphabets = "ABC";
        permStringSwap("ABC");
        /*for(int i=0;i<=alphabets.length();i++){
            System.out.println(alphabets.substring(0,i));
        }*/






    }

    // Reverse a string using for loop
    public static String reverse(String input_string){
        if(input_string==null || input_string.isEmpty()){
            return null;
        }
        {
            String reverse_string="";
            for(int i=input_string.length()-1;i>=0;i--){
                reverse_string=reverse_string + input_string.charAt(i);

            }
            return reverse_string;
        }
    }

    // Function to check if given string is palindrome
    // TO DO: Fix logic
    static int counter=0;
    static String stringdebugger="";
    static int count=0;
    public static Boolean isStringPalindrome(String inputString){
        if(inputString==null || inputString.isEmpty() ){
            return null;
        }
        {
            StringBuilder stringHolder = new StringBuilder(inputString);
            String reversedString = stringHolder.reverse().toString();
            int indexcounter= inputString.length();

            for (int i=indexcounter-1;i>=0;i--){ // start i from left side
                int j = abs(i-indexcounter+1); // start j from right side
                if(reversedString.charAt(j) != inputString.charAt(i)){
                    return false;
                }
                else {
                    counter=j;

                    stringdebugger = stringdebugger+inputString.charAt(i)+reversedString.charAt(j);
                    return true;

                }

            }
        }
    return null;
    }


    // Remove a specific character from a string

    public static Character[] removeCharfromString(String input_string,Character char_){
        if(input_string == null) {
            return null;
        }
        int len = input_string.length();

        Character[] charArray = new Character[len];
        for (int n=0;n<len;n++){
            if(input_string.charAt(n) != char_){
                charArray[n] = new Character(input_string.charAt(n));
            }



        }
        return charArray;
    }

    //

    /*
    static public String stringPermutations (String input_String,String swap1 , String swap2){

        String  otherString;
        for (int i=0;i<input_String.length();i++){
            StringBuilder dummyString = new StringBuilder(input_String.charAt(i)); // Build a new strong object for every key
            Character charA = new Character(input_String.charAt(i+1));
            Character charB = new Character(input_String.charAt(i+2));
            Character temp ;
            temp = charA;
            charA = charB;

            dummyString.append(temp).append(charA);
            otherString = dummyString.toString();
            return otherString ;

        }

    return otherString;}

*/

      public static void stringPermutation(char input[]) {
        Map<Character, Integer> charKeyCountMap = new TreeMap<>();

        for (char ch : input) {
            charKeyCountMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }

        char stringHolder[] = new char[charKeyCountMap.size()]; // [A,B,C]
        int distinctStringcount[] = new int[charKeyCountMap.size()]; // [1,1,1]
        int index = 0;
        // Iterate on the entire Tree map set. storing each entry pair (K,V)
        for (Map.Entry<Character, Integer> entry : charKeyCountMap.entrySet()) {
            stringHolder[index] += entry.getKey();
            distinctStringcount[index] += entry.getValue();
            index++; // Increment index to fill other entries
        }

        char result[] = new char[input.length]; // Empty result set of size input array, will hold N permutation result

        permutefunc(stringHolder, distinctStringcount, result, 0);
    }
        public static void permutefunc(char stringHolder[], int distinctStringCount[],char result[], int level) {
            if (level == result.length) {
                printArray(result);
                return;
            }

            for(int i=0; i<stringHolder.length;i++){
                if (distinctStringCount[i]==0) {
                    continue;
                }
                result[level] = stringHolder[i];
                distinctStringCount[i]--;
                permutefunc(stringHolder,distinctStringCount,result,level+1);
                distinctStringCount[i]++;

            }


    }
    public static void printArray(char input[]){
        for(char ch: input) {
            System.out.print(ch);
        }
        System.out.println();

    }
    // Permute string using swap. To do so change input strong to a Char array.
    public static void permStringSwap(String s){
        int n = s.length();
        char [] a = new char[n];

        for(int i=0;i<n;i++){
            a[i] = s.charAt(i);
        }
        permStringSwap(a,n);
    }
    private static void permStringSwap(char[] a , int n) {
        if (n == 1) {
            System.out.println(new String(a));
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permStringSwap(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    // swap i and j
    private static void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    }


























