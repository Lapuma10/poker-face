package com.example.pokerface.Controllers;

import com.example.pokerface.Game.CardHandler;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;

@RestController
@EnableAutoConfiguration

public class PokerController {

    final CardHandler cardHandler;

    public PokerController() {
        cardHandler = new CardHandler();
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    //generate new hand

    //analyse hand
    public Queue<String> analyseHand() {
        return null;
    }

    @RequestMapping("/deal")
    public Queue<String> drawHand() {
        return cardHandler.drawHand();
    }

    //public


}


