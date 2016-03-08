package bridge;

import bridge.Card;
import bridge.Player;
import bridgeTest.CustomDeck;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author dpoumakis
 */
public class BridgeTrick
{
    ArrayList<Player> players;
    
    private CustomDeck deck;
    
    private Stack<Card> table;
    
    public BridgeTrick(CustomDeck deck) 
    {
        table = new Stack<>();
        
        players = new ArrayList<>();
        
        this.deck = deck;
        
        for (int player = 0; player < 4; player++)
        {
            players.add(new Player());
        }
        
        for (Player player : players)
        {
            for (int card = 0; card < 13; card++)
            {
                player.addCard(deck.getTopCard());
            }
        }
    }
    
    public void pushToTable()
    {
        for (Player player : players)
        {
            Card card = player.removeCard();
            table.push(card);
        }
    }
    
    public Stack<Card> getTable()
    {
        return table;
    }
    
    public void clearTable()
    {
        table.clear();
    }
    
    public Card determineWinner()
    {
        Card winner = table.pop();
        
        for (int card = 0; card < 3; card++)
        {
            Card currentCard = table.pop();
            
            if (currentCard.getSuitValue() == winner.getSuitValue())
            {
                
                if (currentCard.getFaceValue() > winner.getFaceValue())
                {
                    winner = currentCard;
                }
            }
        }
        
        return winner;
    }
}
