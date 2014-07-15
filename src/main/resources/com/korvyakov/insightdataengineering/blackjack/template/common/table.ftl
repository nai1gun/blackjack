<#macro cards cardList>
<#list cardList as card>┌──<#if !card_has_next>────┐</#if></#list>
<#list cardList as card>│@|${card.suit.color} ${card.value.symbols?right_pad(2)}|@<#if !card_has_next>    │</#if></#list>
<#list cardList as card>│@|${card.suit.color} ${card.suit.symbol}|@ <#if !card_has_next>    │</#if></#list>
<#list cardList as card>│  <#if !card_has_next>   @|${card.suit.color} ${card.suit.symbol}|@│</#if></#list>
<#list cardList as card>│  <#if !card_has_next>  @|${card.suit.color} ${card.value.symbols?left_pad(2)}|@│</#if></#list>
<#list cardList as card>└──<#if !card_has_next>────┘</#if></#list>
</#macro>
<#macro points name numPoints busted bj>
${name} points: ${numPoints} <#if busted>@|red (busted)|@</#if><#if bj>@|blink_slow,green (Blackjack!)|@</#if>
</#macro>
<@points "Dealer" context.dealerPoints context.dealerBusted context.dealerBlackjack/>
<@cards context.dealerCards/>
<@cards context.playerCards/>
<@points "Player" context.playerPoints context.playerBusted context.playerBlackjack/>
