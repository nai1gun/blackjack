<#include "common/header.ftl">
Dealer points ${context.dealerPoints}
<#list context.dealerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

<#list context.playerCards as card><#--
-->|${card.suit} ${card.value}| <#--
--></#list>

Your points: ${context.playerPoints} <#if context.playerBusted>(busted)</#if>
<#include "common/footer.ftl">