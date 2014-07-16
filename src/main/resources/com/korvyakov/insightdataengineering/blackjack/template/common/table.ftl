<#macro color colorValue><#if colorValue!="default">@|${colorValue} </#if><#nested><#if colorValue!="default">|@</#if></#macro>
<#macro cards cardList>
<#list cardList as card>┌──<#if !card_has_next>────┐</#if></#list>
<#list cardList as card>│<@color card.suit.color>${card.value.symbols?right_pad(2)}</@color><#if !card_has_next>    │</#if></#list>
<#list cardList as card>│<@color card.suit.color>${h.suit(card.suit)}</@color> <#if !card_has_next>    │</#if></#list>
<#list cardList as card>│  <#if !card_has_next>   <@color card.suit.color>${h.suit(card.suit)}</@color>│</#if></#list>
<#list cardList as card>│  <#if !card_has_next>  <@color card.suit.color>${card.value.symbols?left_pad(2)}</@color>│</#if></#list>
<#list cardList as card>└──<#if !card_has_next>────┘</#if></#list>
</#macro>
<#macro points name numPoints busted bj>
${name} points: ${numPoints} <#if busted>@|red (busted)|@</#if><#if bj>@|blink_slow,green (Blackjack!)|@</#if>
</#macro>
<@points "Dealer" context.dealerPoints context.dealerBusted context.dealerBlackjack/>
<@cards context.dealerCards/>
<@cards context.playerCards/>
<@points "Player" context.playerPoints context.playerBusted context.playerBlackjack/>
