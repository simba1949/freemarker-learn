<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<#list list>
    <#items as item>
        <#if item.id == 3>
            <#break>
        </#if>
        ${item}
    </#items>
<#else>
    list 为空
</#list>

</body>
</html>