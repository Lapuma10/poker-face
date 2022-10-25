package com.example.pokerface.Game;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class HandAnalyzerTest {

    HandAnalyzer handAnalyzer = new HandAnalyzer();

    @Test
    public void analyzeHand_shouldReturnCorrectResult_givenAHand() {
        Queue<Card> hand = new ArrayDeque<>();
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();
        Queue<Card> hand3 = new ArrayDeque<>();
        Queue<Card> hand4 = new ArrayDeque<>();
        Queue<Card> hand5 = new ArrayDeque<>();
        Queue<Card> hand6 = new ArrayDeque<>();
        Queue<Card> hand7 = new ArrayDeque<>();
        Queue<Card> hand8 = new ArrayDeque<>();


        hand.add(new Card("j", "r", 11));
        hand.add(new Card("t", "r", 10));
        hand.add(new Card("q", "r", 12));
        hand.add(new Card("k", "r", 13));
        hand.add(new Card("a", "r", 14));

        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("j", "k", 11));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("2", "k", 2));
        hand2.add(new Card("5", "k", 5));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("3", "s", 3));

        hand3.add(new Card("5", "h", 5));
        hand3.add(new Card("6", "h", 6));
        hand3.add(new Card("7", "h", 7));
        hand3.add(new Card("8", "h", 8));
        hand3.add(new Card("3", "h", 3));

        hand4.add(new Card("j", "r", 11));
        hand4.add(new Card("t", "r", 10));
        hand4.add(new Card("j", "s", 11));
        hand4.add(new Card("t", "k", 10));
        hand4.add(new Card("j", "h", 11));

        hand5.add(new Card("j", "r", 11));
        hand5.add(new Card("t", "k", 10));
        hand5.add(new Card("8", "s", 8));
        hand5.add(new Card("7", "r", 7));
        hand5.add(new Card("9", "r", 9));

        hand6.add(new Card("3", "s", 3));
        hand6.add(new Card("3", "k", 3));
        hand6.add(new Card("3", "h", 3));
        hand6.add(new Card("5", "s", 5));
        hand6.add(new Card("6", "s", 6));

        hand7.add(new Card("3", "s", 3));
        hand7.add(new Card("8", "k", 8));
        hand7.add(new Card("4", "k", 4));
        hand7.add(new Card("4", "s", 4));
        hand7.add(new Card("2", "s", 2));

        hand8.add(new Card("3", "s", 3));
        hand8.add(new Card("9", "k", 9));
        hand8.add(new Card("4", "k", 4));
        hand8.add(new Card("k", "s", 13));
        hand8.add(new Card("2", "s", 2));

        assertEquals("Royal Flush", handAnalyzer.analyzeHand(hand).get());
        assertEquals("Four of a kind", handAnalyzer.analyzeHand(hand1).get());
        assertEquals("Two pair", handAnalyzer.analyzeHand(hand2).get());
        assertEquals("Flush", handAnalyzer.analyzeHand(hand3).get());
        assertEquals("Full house", handAnalyzer.analyzeHand(hand4).get());
        assertEquals("Straight", handAnalyzer.analyzeHand(hand5).get());
        assertEquals("Three of a kind", handAnalyzer.analyzeHand(hand6).get());
        assertEquals("One pair", handAnalyzer.analyzeHand(hand7).get());
        assertEquals("High card", handAnalyzer.analyzeHand(hand8).get());
        assertEquals(Optional.empty(), handAnalyzer.analyzeHand(null));
        assertEquals(Optional.empty(), handAnalyzer.analyzeHand(new ArrayDeque<>()));

    }

    @Test
    public void isHandAFlush() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();
        Queue<Card> hand3 = new ArrayDeque<>();
        Queue<Card> hand4 = new ArrayDeque<>();

        hand1.add(new Card("3", "s", 3));
        hand1.add(new Card("6", "s", 6));
        hand1.add(new Card("7", "s", 7));
        hand1.add(new Card("9", "s", 9));
        hand1.add(new Card("a", "s", 14));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("2", "k", 2));
        hand2.add(new Card("5", "k", 5));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("3", "s", 3));

        hand3.add(new Card("3", "r", 3));
        hand3.add(new Card("2", "r", 2));
        hand3.add(new Card("5", "r", 5));
        hand3.add(new Card("6", "r", 6));
        hand3.add(new Card("3", "s", 3));

        hand4.add(new Card("j", "r", 11));
        hand4.add(new Card("t", "r", 10));
        hand4.add(new Card("8", "r", 8));
        hand4.add(new Card("7", "r", 7));
        hand4.add(new Card("9", "r", 9));

        assertTrue(handAnalyzer.isHandAFlush(hand1));
        assertFalse(handAnalyzer.isHandAFlush(hand2));
        assertFalse(handAnalyzer.isHandAFlush(hand3));
        assertTrue(handAnalyzer.isHandAFlush(hand4));
    }

    @Test
    public void isHandAStraight() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();

        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("8", "r", 8));
        hand1.add(new Card("7", "r", 7));
        hand1.add(new Card("9", "r", 9));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("2", "k", 2));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("3", "s", 3));

        assertTrue(handAnalyzer.isHandAStraight(hand1));
        assertFalse(handAnalyzer.isHandAStraight(hand2));

    }

    @Test
    public void isHandARoyalFlush() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();
        Queue<Card> hand3 = new ArrayDeque<>();


        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("8", "r", 8));
        hand1.add(new Card("7", "r", 7));
        hand1.add(new Card("9", "r", 9));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("2", "k", 2));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("6", "s", 6));

        hand3.add(new Card("5", "h", 5));
        hand3.add(new Card("6", "h", 6));
        hand3.add(new Card("7", "h", 7));
        hand3.add(new Card("8", "h", 8));
        hand3.add(new Card("3", "h", 3));

        assertTrue(handAnalyzer.isRoyalFlush(hand1));
        assertFalse(handAnalyzer.isRoyalFlush(hand2));
        assertFalse(handAnalyzer.isRoyalFlush(hand3));


    }

    @Test
    public void isHandAFourKind() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();
        Queue<Card> hand3 = new ArrayDeque<>();


        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("j", "k", 11));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("2", "k", 2));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("6", "s", 6));

        hand3.add(new Card("5", "h", 5));
        hand3.add(new Card("6", "h", 6));
        hand3.add(new Card("7", "h", 7));
        hand3.add(new Card("8", "h", 8));
        hand3.add(new Card("3", "h", 3));

        assertTrue(handAnalyzer.isHandAFourKind(hand1));
        assertFalse(handAnalyzer.isHandAFourKind(hand2));
        assertFalse(handAnalyzer.isHandAFourKind(hand3));

    }

    @Test
    public void isHandAThreeKind() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();

        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("j", "k", 11));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("3", "k", 3));
        hand2.add(new Card("3", "h", 3));
        hand2.add(new Card("5", "s", 5));
        hand2.add(new Card("6", "s", 6));

        assertFalse(handAnalyzer.isHandAThreeKind(hand1));
        assertTrue(handAnalyzer.isHandAThreeKind(hand2));

    }

    @Test
    public void isHandAFullHouse() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();
        Queue<Card> hand3 = new ArrayDeque<>();


        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("t", "k", 10));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("3", "k", 3));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("4", "s", 4));
        hand2.add(new Card("2", "s", 2));

        hand3.add(new Card("5", "h", 5));
        hand3.add(new Card("6", "h", 6));
        hand3.add(new Card("7", "h", 7));
        hand3.add(new Card("8", "h", 8));
        hand3.add(new Card("3", "h", 3));

        assertTrue(handAnalyzer.isHandAFullHouse(hand1));
        assertFalse(handAnalyzer.isHandAFullHouse(hand2));
        assertFalse(handAnalyzer.isHandAFullHouse(hand3));

    }

    @Test
    public void isHandATwoPair() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();

        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("t", "k", 10));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("3", "k", 3));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("4", "s", 4));
        hand2.add(new Card("2", "s", 2));

        assertFalse(handAnalyzer.isHandATwoPair(hand1));
        assertTrue(handAnalyzer.isHandATwoPair(hand2));

    }

    @Test
    public void isHandAPair() {
        Queue<Card> hand1 = new ArrayDeque<>();
        Queue<Card> hand2 = new ArrayDeque<>();


        hand1.add(new Card("j", "r", 11));
        hand1.add(new Card("t", "r", 10));
        hand1.add(new Card("j", "s", 11));
        hand1.add(new Card("t", "k", 10));
        hand1.add(new Card("j", "h", 11));

        hand2.add(new Card("3", "s", 3));
        hand2.add(new Card("3", "k", 3));
        hand2.add(new Card("4", "k", 4));
        hand2.add(new Card("4", "s", 4));
        hand2.add(new Card("2", "s", 2));


        assertFalse(handAnalyzer.isHandATwoPair(hand1));
        assertTrue(handAnalyzer.isHandATwoPair(hand2));

    }

}