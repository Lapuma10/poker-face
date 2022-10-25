package com.example.pokerface.Game;

import java.util.*;

public class HandAnalyzer {

    public Optional<String> analyzeHand(final Queue<Card> hand) {
        if (hand != null && hand.size() > 0) {
            final String resultHand;
            if (isRoyalFlush(hand)) {
                resultHand = "Royal Flush";
            } else if (isHandAFourKind(hand)) {
                resultHand = "Four of a kind";
            } else if (isHandAFullHouse(hand)) {
                resultHand = "Full house";
            } else if (isHandAFlush(hand)) {
                resultHand = "Flush";
            } else if (isHandAStraight(hand)) {
                resultHand = "Straight";
            } else if (isHandAThreeKind(hand)) {
                resultHand = "Three of a kind";
            } else if (isHandATwoPair(hand)) {
                resultHand = "Two pair";
            } else if (isHandAPair(hand)) {
                resultHand = "One pair";
            } else {
                resultHand = "High card";
            }
            return Optional.of(resultHand);
        }
        return Optional.empty();
    }

    public boolean isRoyalFlush(final Queue<Card> hand) {
        return isHandAFlush(hand) && isHandAStraight(hand);
    }

    public boolean isHandAFlush(final Queue<Card> hand) {
        String prevType = null;
        for (Card card : hand) {
            if (prevType == null) {
                prevType = card.getType();
            } else if (!card.getType().equals(prevType)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHandAFourKind(final Queue<Card> hand) {

        HashMap<String, Integer> duplicateCount = getDuplicates(hand);

        for (int count : duplicateCount.values()) {
            if (count == 4) {
                return true;
            }
        }

        return false;
    }

    public boolean isHandAFullHouse(final Queue<Card> hand) {

        HashMap<String, Integer> duplicateCount = getDuplicates(hand);
        boolean isThree = false;
        boolean isTwo = false;

        for (int count : duplicateCount.values()) {
            if (count == 3) {
                isThree = true;
            } else if (count == 2) {
                isTwo = true;
            }
        }

        return isThree && isTwo;
    }

    public boolean isHandAThreeKind(final Queue<Card> hand) {

        HashMap<String, Integer> duplicateCount = getDuplicates(hand);

        for (int count : duplicateCount.values()) {
            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    public boolean isHandATwoPair(final Queue<Card> hand) {

        HashMap<String, Integer> duplicateCount = getDuplicates(hand);
        int pairCount = 0;

        for (int count : duplicateCount.values()) {
            if (count == 2) {
                pairCount++;
            }
        }

        return pairCount == 2;
    }

    public boolean isHandAPair(final Queue<Card> hand) {

        HashMap<String, Integer> duplicateCount = getDuplicates(hand);

        for (int count : duplicateCount.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }

    private HashMap<String, Integer> getDuplicates(final Queue<Card> hand) {
        HashMap<String, Integer> handSymbolMap = new HashMap<>();

        for (Card card : hand) {
            if (handSymbolMap.size() > 0) {
                final String cardSymbol = card.getSymbol();
                if (handSymbolMap.containsKey(cardSymbol)) {
                    final int count = handSymbolMap.get(cardSymbol) + 1;
                    handSymbolMap.replace(cardSymbol, count);
                } else {
                    handSymbolMap.put(card.getSymbol(), 1);
                }

            } else {
                handSymbolMap.put(card.getSymbol(), 1);
            }
        }

        return handSymbolMap;
    }

    public boolean isHandAStraight(final Queue<Card> hand) {
        final List<Integer> sortedHand = sortHandByStrength(hand);

        int prevCardStrength = sortedHand.get(0);
        for (final Integer cardStrength : sortedHand) {
            if (cardStrength != prevCardStrength) {
                return false;
            }
            prevCardStrength++;
        }

        return true;
    }

    private List<Integer> sortHandByStrength(final Queue<Card> hand) {
        List<Integer> sortedHand = new ArrayList<>(getHandStrength(hand));
        Collections.sort(sortedHand);
        return sortedHand;
    }

    private List<Integer> getHandStrength(final Queue<Card> hand) {
        List<Integer> strengthList = new ArrayList<>();

        for (Card card : hand) {
            strengthList.add(card.getStrength());
        }

        return strengthList;
    }

}
