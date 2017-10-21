package MISC;
import java.util.regex.*;

public class todelete {


    public static void main(String[] args) {
        String input =
                "3,----1,-2";

        Pattern p = Pattern.compile("(\\,\\-\\d)");
        Matcher m = p.matcher(input);


        StringBuffer result = new StringBuffer();
        /*while (m.find()) {
            System.out.println("Masking: " + m.group(2));
            m.appendReplacement(result, m.group(1) + "***masked***");
        }
        m.appendTail(result);*/
        if (m.find()) {
            System.out.println(m.group(1));
        }
        //m.appendTail(result);
        //System.out.println(result);

    }
}
