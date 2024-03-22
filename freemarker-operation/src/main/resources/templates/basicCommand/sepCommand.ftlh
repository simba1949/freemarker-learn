<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SEP指令</title>
</head>
<body>
<div>
    <#-- freemarker sep 指令-->
    <table>
        <#--
        dataList 是要遍历的对象
        item 是每次迭代的值，使用 ${} 取值
        -->
        <#list dataList as item>
            ${item}
            <#sep>
            <#-- sep 指令，用于分隔符-->
                ,
            </#sep>
        <#else >
            dataList is empty
        </#list>
    </table>
</div>
</body>
</html>