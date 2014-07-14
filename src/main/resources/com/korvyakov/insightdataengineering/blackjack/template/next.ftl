<#include "common/header.ftl">
<#if context.shuffleResult == "WIN">@|bold,green Player wins!|@</#if><#--
--><#if context.shuffleResult == "LOOSE">@|bold,red Player loses!|@</#if><#--
--><#if context.shuffleResult == "PUSH">@|bold,yellow Push!|@</#if>
<#include "common/table.ftl">
<#include "common/footer.ftl">