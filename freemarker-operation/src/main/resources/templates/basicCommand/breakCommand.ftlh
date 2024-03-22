<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BREAK指令</title>
</head>
<body>
<div>
    <#-- freemarker sep 指令-->
    <table>
        <#--
        dataList 是要遍历的对象
        item 是每次迭代的值，使用 ${} 取值
        -->
        <#--
        break/continue 将仅存在于为每个迭代项调用的指令体中，而且只能存在于这样的指令中。
        -->
        <#list dataList as item>
            <#if item == 6>
                <#break>
            <#else>
                ${item}
                <#continue>
            </#if>
        <#else >
            dataList is empty
        </#list>
    </table>
</div>
</body>
</html>