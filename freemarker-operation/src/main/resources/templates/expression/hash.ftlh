<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HASH</title>
</head>
<body>
<div>
    <h1>哈希的遍历</h1>
    <#assign hash = {"libai":666, "dufu": "888"} + {"baijuyi": true?c}>
    ${hash.libai} <br>
    ${hash.dufu} <br>
    ${hash.baijuyi} <br>
</div>
<div>
    <h1>哈希的连接</h1>
    <#assign ages = {"Joe":23, "Fred":25} + {"Joe":30, "Julia":18}>
    <p>Joe is ${ages.Joe}</p>
    <p>Fred is ${ages.Fred}</p>
    <p>Julia is ${ages.Julia}</p>
</div>
</body>
</html>