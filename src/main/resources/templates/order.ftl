<#include "parts/head.ftl">

<#list message as messages>
<th>${messages.id}</th>
<th>${messages.price}</th>
</#list>

<#include "parts/basement.ftl">