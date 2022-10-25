package com.example.pokerface.Game;

import java.util.*;

public class CardHandler {
    private static final List<String> BASE_CARDS = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "t", "j", "q", "k", "a");
    private static final List<String> CARD_SETS = Arrays.asList("h", "r", "k", "s");
    private static final HashMap<String, Integer> SYMBOL_STRENGTH_MAP = new HashMap<>() {{
        put("t", 10);
        put("j", 11);
        put("q", 12);
        put("k", 13);
        put("a", 14);
    }};

    private List<Card> createDeck() {

        List<Card> deck = new ArrayList<>();

        for (final String cardSet : CARD_SETS) {
            int strength = 2;
            for (final String baseCard : BASE_CARDS) {
                final Card card = new Card(baseCard, cardSet, strength);
                deck.add(card);
                strength++;
            }
        }

        return deck;
    }

    private Queue<Card> shuffleDeck(final List<Card> deck) {
        Collections.shuffle(deck);
        return new ArrayDeque<>(deck);
    }

    private Queue<Card> getNewShuffledDeck() {
        final List<Card> unShuffledDeck = createDeck();
        return shuffleDeck(unShuffledDeck);
    }

    /**
     * Creates a new deck of cards, shuffles the deck and draws 5 cards
     *
     * @return Queue with 5 Cards
     */
    public Queue<Card> drawHand() {
        final Queue<Card> deck = getNewShuffledDeck();
        Queue<Card> hand = new ArrayDeque<>();

        while (hand.size() < 5) {
            final Card cardToInsert = deck.peek();
            if (cardToInsert != null) {
                hand.add(deck.poll());
            } else {
                break;
            }
        }

        return hand;
    }

    /**
     * Extracts card names from a given card queue
     *
     * @param deck the queue containing cards
     * @return a list of card names
     */
    public List<String> getCardNamesFromQueue(final Queue<Card> deck) {
        List<String> nameList = new ArrayList<>();

        for (Card card : deck) {
            nameList.add(card.getName());
        }

        return nameList;
    }

    /**
     * Creates a card queue from a list with card strings
     */
    public Optional<Queue<Card>> createCardQueueFromList(final List<String> cardList) {
        if (cardList != null && !cardList.isEmpty()) {
            Queue<Card> cardQueue = new ArrayDeque<>();
            for (String cardString : cardList) {
                if (!cardString.isBlank()) {
                    final Card card = convertCardStringToCard(cardString);
                    cardQueue.add(card);
                } else {
                    return Optional.empty();
                }
            }
            return Optional.of(cardQueue);
        }
        return Optional.empty();
    }

    private Card convertCardStringToCard(final String cardString) {
        final String cardSymbol = String.valueOf(cardString.charAt(0));
        final String cardType = String.valueOf(cardString.charAt(1));
        final int cardStrength = calculateCardStrengthFromSymbol(cardSymbol);

        return new Card(cardSymbol, cardType, cardStrength);
    }

    private int calculateCardStrengthFromSymbol(final String cardSymbol) {
        try {
            final int cardValue = Integer.parseInt(cardSymbol);
            if (cardValue > 2 && cardValue < 10) {
                return cardValue;
            }

        } catch (final NumberFormatException e) {
            final String cardSymbolToLowerCase = cardSymbol.toLowerCase();
            System.out.println("Encountered exception " + e + " while parsing string " + cardSymbol + " to int. Checking if the symbol is part of the game.");
            if (SYMBOL_STRENGTH_MAP.containsKey(cardSymbolToLowerCase)) {
                return SYMBOL_STRENGTH_MAP.get(cardSymbolToLowerCase);
            }
        }

        return 0;
    }

}


