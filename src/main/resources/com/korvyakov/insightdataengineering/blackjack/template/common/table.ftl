Dealer points ${context.dealerPoints} <#if context.dealerBusted>(busted)</#if><#if context.dealerBlackjack>(Blackjack!)</#if>
<#list context.dealerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

<#list context.playerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

Player points: ${context.playerPoints} <#if context.playerBusted>(busted)</#if><#if context.playerBlackjack>(Blackjack!)</#if>
