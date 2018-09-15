<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>算法 运算</h1>
${100 - five * five}
${100 / five}
${100 % five}
<br>------------<br>
<h1>比较 运算</h1>
<#if 100 < five>
    100 小于 five
<#else >
    100 不小于 five
</#if>
<br>------------<br>
<h1>逻辑 运算</h1>
<#if (100 < five) && trueType >
    100 小于 five，并且 trueType = true
<#elseif trueType >
    100 不小于 five,并且 trueType = true
<#else >
    100 不小于 five,并且 trueType = false
</#if>
<br>------------<br>
</body>
</html>