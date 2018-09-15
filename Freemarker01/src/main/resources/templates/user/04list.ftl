<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<#list list as item>
    ${item}
<#else>
    list 为空
</#list>
<br>------------------<br>
<#list list>
    <#items as item>
    ${item}
    </#items>
<#else>
    list 为空
</#list>
</body>
</html>