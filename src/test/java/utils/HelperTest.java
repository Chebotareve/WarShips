package utils;

import org.testng.annotations.Test;

public class HelperTest {
    @Test(expectedExceptions = IncorrectInputException.class)
    public void whenPassingEmptyStringThenGettingException() throws IncorrectInputException {
        Helper.checkTheString("");
    }

    @Test(expectedExceptions = IncorrectInputException.class)
    public void whenPassingTooLongStringThenGettingException() throws IncorrectInputException {
        Helper.checkTheString("a111");
    }

    @Test
    public void whenPassingCorrectStringThenGettingNoException() throws IncorrectInputException {
        Helper.checkTheString("a1");
    }
}