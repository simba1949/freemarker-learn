<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IF指令</title>
</head>
<body>
<div>
    <#-- freemarker if指令，数值型-->
    <#if val lt 0>
        val < 0
    <#elseif val gt 0 && val lt 18>
        val > 0 and val < 18
    <#else>
        val > 18
    </#if>
</div>
<div>
    <#-- freemarker if指令，字符串判断-->
    <#-- person.name?? 表示一个值是否存在 -->
    <#if person.name??>
        ${person.name}
    <#else>
        无名氏
    </#if>
</div>
</body>
</html>