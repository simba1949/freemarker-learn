<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>值域</title>
</head>
<body>
<div>
    <h1>左闭右闭的值域</h1>
    <#-- 语法：start..end -->
    <#list 1..10 as x>
        ${x}
    </#list>
</div>
<div>
    <h1>左闭右开的值域</h1>
    <#-- 语法：start..<end -->
    <#list 0..<10 as x>
        ${x}
    </#list>
</div>
<div>
    <h1>定长的值域</h1>
    <#-- 语法：start..*length -->
    <#list 0..*4 as x>
        ${x}
    </#list>
</div>
<div>
    <h1>无边界的值域</h1>
    <#-- 语法：start.. -->
    <#list 0.. as x>
        ${x}
        <#if x == 10>
            <#break>
        </#if>
    </#list>
</div>
</body>
</html>