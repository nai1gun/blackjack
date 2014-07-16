package com.korvyakov.insightdataengineering.blackjack;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import com.korvyakov.insightdataengineering.blackjack.service.GameContext;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class GameContextTest {

    @Autowired private GameContext gameContext;

    @Test
    public void playerBusted() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
            new Card(Card.Value.KING, Card.Suit.CLUBS),
            new Card(Card.Value.KING, Card.Suit.CLUBS),
            new Card(Card.Value.TWO, Card.Suit.CLUBS)));
        gameContext.setDealerCards(Arrays.asList(new Card(Card.Value.JACK, Card.Suit.CLUBS)));
        Assert.assertTrue("Player should loose", gameContext.getShuffleResult() == ShuffleResult.LOOSE);
    }

    @Test
    public void dealerBusted() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
                new Card(Card.Value.KING, Card.Suit.CLUBS),
                new Card(Card.Value.SIX, Card.Suit.CLUBS),
                new Card(Card.Value.TWO, Card.Suit.HEARTS)));
        gameContext.setDealerCards(Arrays.asList(
                new Card(Card.Value.JACK, Card.Suit.CLUBS),
                new Card(Card.Value.EIGHT, Card.Suit.CLUBS),
                new Card(Card.Value.FOUR, Card.Suit.DIAMONDS)));
        Assert.assertTrue("Player should win", gameContext.getShuffleResult() == ShuffleResult.WIN);
    }

    @Test
    public void player21DealerBj() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
                new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Value.KING, Card.Suit.HEARTS),
                new Card(Card.Value.ACE, Card.Suit.SPADES)));
        gameContext.setDealerCards(Arrays.asList(
                new Card(Card.Value.JACK, Card.Suit.CLUBS),
                new Card(Card.Value.ACE, Card.Suit.CLUBS)));
        Assert.assertTrue("Player should loose", gameContext.getShuffleResult() == ShuffleResult.LOOSE);
    }

    @Test
    public void dealer21PlayerBj() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
                new Card(Card.Value.ACE, Card.Suit.CLUBS),
                new Card(Card.Value.TEN, Card.Suit.CLUBS)));

        gameContext.setDealerCards(Arrays.asList(
                new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Value.FIVE, Card.Suit.HEARTS),
                new Card(Card.Value.SIX, Card.Suit.SPADES)));
        Assert.assertTrue("Player should win", gameContext.getShuffleResult() == ShuffleResult.WIN);
    }

    @Test
    public void same() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
                new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Value.KING, Card.Suit.HEARTS)));
        gameContext.setDealerCards(Arrays.asList(
                new Card(Card.Value.JACK, Card.Suit.CLUBS),
                new Card(Card.Value.FOUR, Card.Suit.CLUBS),
                new Card(Card.Value.SIX, Card.Suit.CLUBS)));
        Assert.assertTrue("Should be push", gameContext.getShuffleResult() == ShuffleResult.PUSH);
    }

    @Test
    public void blackjacks() {
        gameContext.restart();
        gameContext.setPlayerCards(Arrays.asList(
                new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS),
                new Card(Card.Value.ACE, Card.Suit.HEARTS)));
        gameContext.setDealerCards(Arrays.asList(
                new Card(Card.Value.ACE, Card.Suit.CLUBS),
                new Card(Card.Value.JACK, Card.Suit.CLUBS)));
        Assert.assertTrue("Should be push", gameContext.getShuffleResult() == ShuffleResult.PUSH);
    }
}
