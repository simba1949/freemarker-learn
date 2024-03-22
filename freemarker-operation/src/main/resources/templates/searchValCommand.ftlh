<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>检索变量</title>
</head>
<body>
<div>
    <#-- freemarker boolean 判断-->
    <#if permission>
        有权限
    <#else>
        无权限
    </#if>
</div>
<div>
    <#-- freemarker hash 取值-->
    <#-- person.name?? 表示一个值是否存在 -->
    <#if book??>
        <p>book.author.name = ${book.author.name}</p>
        <p>book.["author"].name = ${book.["author"].name}</p>
        <p>book.author.["name"] = ${book.author.["name"]}</p>
        <p>book.["author"].["name"] = ${book.["author"].["name"]}</p>
    </#if>
</div>
<div>
    <#-- freemarker 序列取值-->
    <#-- person.name?? 表示一个值是否存在 -->
    <#if list??>
        <p>list[0].name = ${list[0].name}</p>
    </#if>
</div>
</body>
</html>