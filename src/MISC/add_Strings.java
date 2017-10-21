package MISC;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class add_Strings {
    public static void main(String[] args) {


        System.out.print(add_string_method("//;n3---121---1"));
    }

    public static int add_string_method(String input) {
        String delimiter = "";
        String inputStingwithoutprefix = input;
        if (input.startsWith("//")) {
            int delimiter_index = input.indexOf("//") + 2;
            delimiter = input.substring(delimiter_index, delimiter_index + 1); // Giving: ";"
            inputStingwithoutprefix = inputStingwithoutprefix.substring(delimiter_index + 2, input.length()); // Giving: 3;0;0

        }
        return add_string_method(inputStingwithoutprefix,0);

    }


    private static int add_string_method(String input,int a){

        // All non-numeric alphanumeric characters "[\\W]+"


        if( input.contains("[\\W]+") && input.contains("\\-{2,}\\g"));
            String [] numbers = input.split("[\\W]+");
            int accumulator=a;

        /*if(numbers.length>2){
            throw new RuntimeException("You have entered invalid number of arguements");
        }*/


            for(String each_number: numbers) {

                if(Integer.parseInt(each_number)>=0 && Integer.parseInt(each_number)<1000){
                    int int_holder = Integer.parseInt(each_number);
                    accumulator += int_holder;
                } // Condition for test case ignore N>=1000

                if(Integer.parseInt(each_number) <0){
                    throw new RuntimeException("One or more of the input string is of negative nature!");
                }
            }

    return accumulator;
    }

}
