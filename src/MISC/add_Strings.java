package MISC;
/*
* A simple program used to add string integers consisting of  delimiters of N-length and various other specifications.
* Coded as per the test driven frame work.
* See bottom for the specification list.
*/

import java.util.regex.*;

public class add_Strings {
    public static void main(String[] args) {

      //System.out.print(add_string_method("1,2"));
    }

    public static int add_string_method(String input) {
        String delimiter = "";
        String inputStingwithoutprefix = input;

        Pattern inputHasNegativeNumber = Pattern.compile("(\\,\\-\\d)"); // An input integer will always be present when string match is ',-N', where N is some digit
        Matcher m = inputHasNegativeNumber.matcher(input);


        StringBuffer negativeNumberResult = new StringBuffer();

        if (input.startsWith("//") && (!m.find())) {
            int delimiter_index = input.indexOf("//") + 2;
            delimiter = input.substring(delimiter_index, delimiter_index + 1); // Giving: ";"
            inputStingwithoutprefix = inputStingwithoutprefix.substring(delimiter_index + 2, input.length()); // Giving: 3;0;0
        }
        // Test case when only numbers provided
        String first_string = Character.toString(input.charAt(0));

        if(first_string.matches("\\d") && (!m.find()) ){
            inputStingwithoutprefix = input;
        }

        // Boolean conditional for negative number in arguement

        if (m.find()){
            //System.out.println(m.group(1));
            throw new RuntimeException("Input arguement has a negative integer !");

        }

        else if (input.isEmpty()){
            throw new RuntimeException("You have not provided any arguement");

        }

        return add_string_method(inputStingwithoutprefix,0);
    }


    private static int add_string_method(String input,int a){

        // All non-numeric alphanumeric characters "[\\W]+"

        // Any negative arguement is of the form \,{1,}\-\d -> (,-n,..)

        int accumulator=a;

        String [] numbers;

        if(input.contains("(\\W){2,}|(?=\\W)"));
            numbers = input.split("(\\W){2,}|(?=\\W) |(0-9)|\\W");


            for(String each_number: numbers) {
                // Due to regex, String numbers has an empty "" string at start.
                // Temporary work around: Use if to ghost it to zero integer
                if(each_number.isEmpty()){accumulator+=0;}
                else {

                    if (Integer.parseInt(each_number) >= 0 && Integer.parseInt(each_number) < 1000) {
                        int int_holder = Integer.parseInt(each_number);
                        accumulator += int_holder;
                    } // Condition for test case ignore N>=1000

                    if (Integer.parseInt(each_number) < 0) {
                        throw new RuntimeException("One or more of the input string is of negative nature!");
                    }
                }
            }

    return accumulator;
    }

}


/* Note: Addition of N- length of delimiters (-----) has thrown error off on negative number test case exception.
 * Reason: Input => //n3---4-----5,-1 must throw negative integer exception due to "-1" !! 
 but does not due to incorrect regexp i.e string splitting happens at every '-' so rendering "-1" -> 1, i.e (3+4+5+1) /*

 Solution (Look ahead operator):

 Left most expression (\\W){2,}: Match delimiters of length N>2 , (?=\\W): Don't retrieve any \W chars, (0-9): Select digits, \\W: Followd with any \W.

 Regex: "(\\W){2,}|(?=\\W) |(0-9)|\\W"

 Works on:
  "//;n--1-----3--1--2------12"
  * 1,2,3,4
*/
