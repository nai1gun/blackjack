<#include "common/header.ftl">
<#if context.shuffleResult == "WIN">Player wins!</#if><#--
--><#if context.shuffleResult == "LOOSE">Player loses!</#if><#--
--><#if context.shuffleResult == "PUSH">Push!</#if>
<#include "common/table.ftl">
<#include "common/footer.ftl">