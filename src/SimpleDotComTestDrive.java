import java.util.ArrayList;
import java.util.Arrays;

public class SimpleDotComTestDrive {
    public static void main() {
        DotCom dot = new DotCom();
        ArrayList<String> fakeShipLocation = new ArrayList<String>(Arrays.asList("2", "3", "4"));
        dot.setShipLocation(fakeShipLocation);
        String fakeGuess = "2";
        String fakeResult = dot.checkYourself(fakeGuess);
        String testResult = "failed";
        if (fakeResult.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }

}
