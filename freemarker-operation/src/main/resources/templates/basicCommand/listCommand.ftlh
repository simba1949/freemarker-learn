<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LIST指令</title>
</head>
<body>
<div>
    <#-- freemarker list指令-->
    <h1>第一种方式</h1>
    <table>
        <#--
        dataList 是要遍历的对象
        item 是每次迭代的值，使用 ${} 取值
        -->
        <#list dataList as item>
            <tr>
                <td>${item.name}</td>
                <td>${item.sex}</td>
                <td>${item.birthday}</td>
            </tr>
        <#else >
            dataList is empty
        </#list>
    </table>
    <h1>第二种方式</h1>
    <table>
        <#list dataList>
            <#items as item>
                <tr>
                    <td>${item.name}</td>
                    <td>${item.sex}</td>
                    <td>${item.birthday}</td>
                </tr>
            </#items>
        <#else>
            dataList is empty
        </#list>
    </table>
</div>
</body>
</html>