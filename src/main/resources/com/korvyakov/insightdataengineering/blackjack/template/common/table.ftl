Dealer points ${context.dealerPoints} <#if context.dealerBusted>@|red (busted)|@</#if><#if context.dealerBlackjack>@|blink_slow,green (Blackjack!)|@</#if>
<#list context.dealerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

<#list context.playerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

Player points: ${context.playerPoints} <#if context.playerBusted>@|red (busted)|@</#if><#if context.playerBlackjack>@|blink_slow,green (Blackjack!)|@</#if>
