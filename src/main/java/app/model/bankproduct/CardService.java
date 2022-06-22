package app.model.bankproduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardService {
    private static List<Card> cards = new ArrayList<>();

    public static Card getById(String userId) {

        Card result = new Card();
        result.setClientId("-1");

        for (Card card : cards) {
            if (card.getClientId().equals(userId)) {
                result = card;
            }
        }
        return result;
    }

    public boolean add(Card cardes) {

        for (Card card : cards) {
            if (card.getProductNumber() == cardes.getProductNumber() && card.getClientId().equals(cardes.getClientId())) {
                return false;
            }
        }
        return cards.add(cardes);
    }

    public boolean cardIsExist( String userId) {

        boolean result = false;

        for (Card card : cards) {
            if (card.getClientId().equals(userId)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
