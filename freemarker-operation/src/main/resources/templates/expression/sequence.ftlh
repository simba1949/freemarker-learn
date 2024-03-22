<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>序列</title>
</head>
<body>
<div>
    <h1>序列的遍历</h1>
    <#list ["foo", "bar", "baz"] as x>
        ${x}
    </#list>
</div>
<div>
    <h1>序列的连接</h1>
    <#list ["Joe", "Fred"] + ["Julia", "Kate"] as user>
        ${user}
    </#list>
</div>
<div>
    <h1>序列的切分</h1>
    <#assign  seq = ["A", "B", "C", "D", "E"]>
    <#list seq[1..3] as i>
        ${i}
    </#list>
</div>
</body>
</html>