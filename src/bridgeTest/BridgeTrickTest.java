package bridgeTest;

import bridge.BridgeTrick;
import bridge.Card;
import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class BridgeTrickTest
{

    public static void main(String[] args)
    {
        // Create custom deck for testing
        CustomDeck deck = new CustomDeck();
        
        // Load test data
        Stack<String>  testData = new Stack<>();
        testData.push("King of Clubs");
        testData.push("Queen of Clubs");
        testData.push("Jack of Clubs");
        testData.push("10 of Clubs");
        testData.push("9 of Clubs");
        testData.push("8 of Clubs");
        testData.push("7 of Clubs");
        testData.push("6 of Clubs");
        testData.push("5 of Clubs");
        testData.push("4 of Clubs");
        testData.push("3 of Clubs");
        testData.push("2 of Clubs");

        BridgeTrick bridge = new BridgeTrick(deck);

        for (int rounds = 0; rounds < 12; rounds++)
        {
            bridge.pushToTable();
            
            Card winner = bridge.determineWinner();
            String test = testData.pop();
            
            if (winner.toString().equals(test))
            {
                System.out.println("pass");
            }
            else
            {
                System.out.println(winner);
                System.out.println(test);
                System.out.println("fail");
            }

            bridge.clearTable();
        }
    }
}
