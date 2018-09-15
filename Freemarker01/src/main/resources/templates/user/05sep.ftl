<html>
<head>
    <title>Welcome!</title>
</head>
<body>

<#list list as item>
    ${item}<#sep><br>-------<br></#sep>
<#else>
    list 为空
</#list>

</body>
</html>