package com.example.pokerface.Controllers;

import com.example.pokerface.Game.Card;
import com.example.pokerface.Game.CardHandler;
import com.example.pokerface.Game.HandAnalyzer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

@RestController
@EnableAutoConfiguration
public class PokerController {

    private final CardHandler cardHandler;
    private final HandAnalyzer handAnalyzer;

    public PokerController() {
        cardHandler = new CardHandler();
        handAnalyzer = new HandAnalyzer();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/analyze")
    @ResponseBody
    public HashMap<String, String> analyseHand(@RequestParam List<String> hand) {
        final Optional<Queue<Card>> cards = cardHandler.createCardQueueFromList(hand);
        if (cards.isPresent()) {
            final Queue<Card> cardsToAnalyze = cards.get();
            final Optional<String> analysisResult = handAnalyzer.analyzeHand(cardsToAnalyze);
            if (analysisResult.isPresent()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("analysis", analysisResult.get());
                return map;
            }
        }
        return new HashMap<>();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/deal")
    public HashMap<String, String> drawHand() {
        final Queue<Card> hand = cardHandler.drawHand();
        final Optional<String> analysisResult = handAnalyzer.analyzeHand(hand);
        final List<String> handCardNames = cardHandler.getCardNamesFromQueue(hand);

        if (analysisResult.isPresent()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("analysis", analysisResult.get());
            map.put("hand", handCardNames.toString());

            return map;
        }

        return new HashMap<>();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/dealNames")
    public ResponseEntity<List<String>> drawHandNames() {
        return ResponseEntity.ok(cardHandler.getCardNamesFromQueue(cardHandler.drawHand()));
    }

}


