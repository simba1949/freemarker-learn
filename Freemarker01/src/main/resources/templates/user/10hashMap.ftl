<html>
<head>
    <title>Title</title>
</head>
<body>

<#assign hash = {"libai":666, "dufu": "888"} + {"baijuyi": true?c}>
${hash.libai}<br>
${hash.dufu}<br>
${hash.baijuyi}<br>

</body>
</html>