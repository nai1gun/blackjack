┌───────${""?left_pad(context.totalChips?length, "─")}──────${""?left_pad(context.bet?length, "─")}┐
│Chips: <#if context.totalChips &gt;= 80>@|green <#--
--><#elseif context.totalChips &gt;= 20>@|yellow <#--
--><#else>@|red </#if><#--
-->${context.totalChips}|@ <#--
-->Bet: ${context.bet}│
└───────${""?left_pad(context.totalChips?length, "─")}──────${""?left_pad(context.bet?length, "─")}┘
