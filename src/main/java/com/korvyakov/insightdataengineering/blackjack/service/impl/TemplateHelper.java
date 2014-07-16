package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.domain.Card;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author <a href="mailto:korvyakov@redhelper.ru">Korvyakov</a>
 * @since 16.07.14
 */
@Component
public class TemplateHelper {

	@Resource private boolean isUnix;

	public String suit(Card.Suit suit) {
		return isUnix? suit.getSymbol(): suit.getAlternativeSymbol();
	}

    public String getCopyright() {
        return isUnix? "©": "(c)";
    }

}
