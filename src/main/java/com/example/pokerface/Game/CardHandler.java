package com.example.pokerface.Game;

import java.util.*;

public class CardHandler {
    private static final List<String> BASE_CARDS = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k", "a");
    private static final List<String> CARD_SETS = Arrays.asList("h", "r", "k", "s");

    private List<String> createDeck() {

        List<String> deck = new ArrayList<>();

        for (final String cardSet : CARD_SETS) {
            for (final String baseCard : BASE_CARDS) {
                deck.add(baseCard + cardSet);
            }
        }

        return deck;
    }

    private Queue<String> shuffleDeck(final List<String> deck) {
        List<String> unshuffledCards = deck;
        Collections.shuffle(unshuffledCards);

        return new ArrayDeque<>(unshuffledCards);
    }

    private Queue<String> getNewShuffledDeck() {
        final List<String> unShuffledDeck = createDeck();
        return shuffleDeck(unShuffledDeck);
    }

    public Queue<String> drawHand() {
        final Queue<String> deck = getNewShuffledDeck();
        Queue<String> hand = new ArrayDeque<>();


        while (hand.size() < 5) {
            final String cardToInsert = deck.peek();
            if (cardToInsert != null) {
                hand.add(deck.poll());
            } else {
                break;
            }
        }

        return hand;
    }

}


