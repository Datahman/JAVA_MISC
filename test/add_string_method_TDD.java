import MISC.add_Strings;
import org.junit.Assert;
import org.junit.Test;

public class add_string_method_TDD {
    /*
    @Test(expected = RuntimeException.class)
    public final void test_add_string_throws_exception_for_three_arguements(){
        add_Strings.add_string_method("1,2,3");
    }*/

    @Test
    public final void test_add_string_does_not_throw_exception_on_two_arguements(){
        add_Strings.add_string_method("1,2");
        Assert.assertTrue(true);
    }
    @Test
    public final void test_add_string_does_not_throw_exception_on_one_arguement(){
        add_Strings.add_string_method("0");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void test_add_string_does_throw_runtime_exception_when_one_non_integer_given(){
        add_Strings.add_string_method("1,T");
        Assert.assertTrue(true); // Test result to be false
    }
    @Test
    public final void test_add_string_returns_same_number_when_one_number_used(){
        ;
        Assert.assertEquals(add_Strings.add_string_method("1"),1);
    }
    @Test
    public final void test_add_string_returns_sum_of_two_numbers(){
        Assert.assertEquals(add_Strings.add_string_method("6,3"),9);
    }

    // Test case: Throw run time exception when nothing given
    @Test(expected = RuntimeException.class)
    public final void test_add_string_returns_exception_when_nothing_given() {
        add_Strings.add_string_method("");
        Assert.assertTrue(true);
    }
    // Test case: Support addition of numbers beyond 2 arguments
    @Test
    public final void test_add_string_returns_sum_of_N_numbers(){
        Assert.assertEquals(add_Strings.add_string_method("1,2,3,4"),1+2+3+4);
    }

    // Test case: Support numbers with new lines
    @Test
    public final void test_add_string_adds_for_numbers_separated_with_newlines(){
        Assert.assertEquals(add_Strings.add_string_method("1\n2"),3);
    }

    // Test case: Support different delimiters e.g  ";"
    @Test
    public final void test_add_string_for_numbers_with_delimiters(){
        Assert.assertEquals(add_Strings.add_string_method("//;n3;1;0"),4); // Apply refactoration for this method
    }

    // Test case: A negative number will throw an exception
    @Test(expected = RuntimeException.class)
    public final void test_add_string_throws_runtime_exception_for_negative_numbers(){
        add_Strings.add_string_method("//;n3,-1,2");
        Assert.assertTrue(true); // Assert runtime exception to be true .
    }

    // Test case: Number larger than thousand must ignored

    @Test
    public final void test_add_string_must_ignore_numbers_greater_than_thousand(){
        Assert.assertEquals(add_Strings.add_string_method("//;n0,3,1000"),3);
    }

    @Test
    // Test case: Delimiter can be of any length
    public final void test_add_string_delimiters_of_any_length(){
        Assert.assertEquals(add_Strings.add_string_method("//;n3---124-%-1"),128);
    }




}
